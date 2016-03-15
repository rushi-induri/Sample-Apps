package com.induri.rushi.listviewadapter;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by Sony on 12-03-2016.
 */
public class NewActivity extends AppCompatActivity {
    TextView textView;
    Intent i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.newlayout);
        textView = (TextView) findViewById(R.id.tv);
        i = getIntent();
        String s = i.getStringExtra("Sent");
        textView.setText(s);

    }
}
