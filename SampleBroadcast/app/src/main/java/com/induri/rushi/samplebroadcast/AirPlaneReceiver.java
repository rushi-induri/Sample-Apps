package com.induri.rushi.samplebroadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;
import android.support.v7.app.AppCompatActivity;

//import static android.support.v4.app.ActivityCompat.startActivity;

/**
 * Created by Sony on 11-03-2016.
 */
public class AirPlaneReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context,"Air Plane MOde",Toast.LENGTH_SHORT).show();
        Intent intent1 = new Intent(context,Hello.class);
        intent1.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent1);
    }

}
