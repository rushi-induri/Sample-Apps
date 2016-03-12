package com.induri.rushi.samplebroadcast;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by Sony on 11-03-2016.
 */
public class NextImplicitIntent extends AppCompatActivity {
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nextimplicit);
    // String ns = null;
        textView = (TextView) findViewById(R.id.txt2);
        String ns = getIntent().getStringExtra("Display");
        textView.setText(ns);
    }
}