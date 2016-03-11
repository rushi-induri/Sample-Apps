package com.induri.rushi.sample_services_unbinded;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    //Method to start the service
    public void startService(View view){
      //  Intent i = new Intent(getBaseContext(),service_unbinded.class);
       // startService(new Intent(getContext()),service_unbinded.class);
        Intent i = new Intent(this,Second_intentservice.class);
        i.putExtra("Msg","Trying to pass a msg from Intent");
        startService(i);
    }

    //Method to stop service
    public void stopService(View view){
        Intent i = new Intent(this,Second_intentservice.class);
        stopService(i);
    }

}
