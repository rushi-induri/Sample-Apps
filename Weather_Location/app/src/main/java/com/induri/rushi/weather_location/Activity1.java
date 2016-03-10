package com.induri.rushi.weather_location;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.net.Uri;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

import static android.content.Intent.ACTION_VIEW;

/**
 * Created by Sony on 09-03-2016.
 */
public class Activity1 extends AppCompatActivity {

    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity1);

        button = (Button) findViewById(R.id.b1);
    }

    public void onClick(View view){
        Intent intent = null;
        Intent chooser = null;
        intent=new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("geo:19.046,72.877"));
        chooser=Intent.createChooser(intent,"Lauching Maps");
        startActivity(chooser);

    }
    public void appLaucher(View view){
        Intent intent = null;
        Intent chooser = null;
        intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("market://details?id=mobi.mgeek.TunnyBrowser.com"));
        chooser=Intent.createChooser(intent,"Lauch App Download");
        startActivity(chooser);
    }

    public void sentEmail(View view){
        if (view.getId() == R.id.b2) {
            Intent intent = null;
            Intent chooser = null;
            intent = new Intent(Intent.ACTION_SEND);
            intent.setData(Uri.parse("mailto:"));
            String[] to = {"indurirushi@gmail.com", "indurirushi@hotmail.com"};
            intent.putExtra(Intent.EXTRA_EMAIL, to);
            intent.putExtra(Intent.EXTRA_SUBJECT, "Sent from weather app");
            intent.putExtra(Intent.EXTRA_TEXT, "Hey ho!!");
            intent.setType("message/rfc822");
            chooser = Intent.createChooser(intent, "Send Email using");
            startActivity(chooser);
        }
        if (view.getId() == R.id.saveb){
            EditText email = (EditText)findViewById(R.id.edittext);
            List<String> a = new ArrayList<String>();
            //String [] a = new String[];
            a.add(email.getText().toString());
            String [] to = new String[a.size()];
            a.toArray(to);
            Intent intent = null;
            Intent chooser = null;
            intent = new Intent(Intent.ACTION_SEND);
            intent.setData(Uri.parse("mailto:"));
            intent.putExtra(Intent.EXTRA_EMAIL, to);
            intent.putExtra(Intent.EXTRA_SUBJECT, "Hello from Pragna");
            intent.putExtra(Intent.EXTRA_TEXT,"Sent from Weather App");
            intent.setType("message/rfc822");
            chooser = Intent.createChooser(intent,"Sent Email BY");
            startActivity(chooser);
        }
    }
}
