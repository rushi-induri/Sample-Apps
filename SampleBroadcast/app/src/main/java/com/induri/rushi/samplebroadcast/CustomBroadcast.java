package com.induri.rushi.samplebroadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by Sony on 11-03-2016.
 */
public class CustomBroadcast extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context,"Custom Broadcast Received",Toast.LENGTH_SHORT).show();
    }
}
