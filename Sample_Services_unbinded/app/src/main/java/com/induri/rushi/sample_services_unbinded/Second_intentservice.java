package com.induri.rushi.sample_services_unbinded;

import android.app.IntentService;
import android.content.Intent;
import android.widget.Toast;
import android.util.Log;

/**
 * Created by Sony on 11-03-2016.
 */

//Advantage of using intentservice is that it uses a sperate thread to perform the service unlike the service which uses
    //the main UI thread

public class Second_intentservice extends IntentService {
    /**
     * Creates an IntentService.  Invoked by your subclass's constructor.
     *
     * @param name Used to name the worker thread, important only for debugging.
     */
    public Second_intentservice() {
        super("My Service Thread");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        Log.d("Intent Srvice Tag","From on handle intent");

    }

    @Override
    public void onCreate() {
        Toast.makeText(this,"Service Created",Toast.LENGTH_LONG).show();
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Toast.makeText(this, "Service Started", Toast.LENGTH_LONG).show();
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        Toast.makeText(this,"Service Destroyed",Toast.LENGTH_LONG).show();
        super.onDestroy();
    }
}
