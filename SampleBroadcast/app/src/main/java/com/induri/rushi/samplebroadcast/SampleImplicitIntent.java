package com.induri.rushi.samplebroadcast;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

/**
 * Created by Sony on 11-03-2016.
 */
public class SampleImplicitIntent extends AppCompatActivity {

    EditText et ;
    Intent intent ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.implicitintent);
        et  = (EditText) findViewById(R.id.editText);
    }

    public void sendIntent(View v){
        intent = new Intent(this,NextImplicitIntent.class);
        String s = et.getText().toString();
        intent.putExtra("Display",s);
        startActivity(intent);
    }
}
