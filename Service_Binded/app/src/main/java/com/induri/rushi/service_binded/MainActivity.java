package com.induri.rushi.service_binded;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText et ;
    Binded_Service mbind;
    boolean status;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et = (EditText) findViewById(R.id.editText);

    }
    public void bindMethod(View v){
        Intent i = new Intent(this,Binded_Service.class);
        bindService(i,conn,BIND_AUTO_CREATE);
        status = true;
        Toast.makeText(getBaseContext(),"Service Binded to activity",Toast.LENGTH_LONG).show();
    }
    public void unbindMethod(View v){
        if (status){
            unbindService(conn);
            Toast.makeText(getBaseContext(),"Service unbinded ",Toast.LENGTH_LONG).show();
            status = false;
        }
        else {
            Toast.makeText(getBaseContext(),"Service already Unbinded",Toast.LENGTH_LONG).show();
        }

    }
    public void factorialMethod(View v){

        if (status){
            int temp = Integer.parseInt(et.getText().toString());
            int result = mbind.findFactorial(temp);
            Toast.makeText(getBaseContext(),"Factorial    =  "+result,Toast.LENGTH_LONG).show();
        }
        else {
            Toast.makeText(getBaseContext(),"First bind the Service",Toast.LENGTH_SHORT).show();
        }

    }

    private ServiceConnection conn = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            Binded_Service.LocalBinder lb = (Binded_Service.LocalBinder) service;
            mbind = lb.getService();
            status = true;
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };

}
