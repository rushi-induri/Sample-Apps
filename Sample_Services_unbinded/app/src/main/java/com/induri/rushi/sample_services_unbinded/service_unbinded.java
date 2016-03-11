package com.induri.rushi.sample_services_unbinded;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.os.Bundle;
import android.widget.Toast;

/**
 * Created by Sony on 10-03-2016.
 */
public class service_unbinded extends Service {
    //Indicate service status and how to behave when killed
    int mStartMode = -1;

    //Sample Interface for Clinets to bind
    IBinder mBinder;

    //To indicate whether rebind is allowed
    boolean mAllowRebind = false;
    //Called when the service is being created
    @Override
    public void onCreate() {
        super.onCreate();
        Toast.makeText(this,"Service Created",Toast.LENGTH_SHORT).show();
    }
    //The service is started call from startservice()
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        //return super.onStartCommand(intent, flags, startId);
        //return mStartMode;
        Toast.makeText(this,"Service Started",Toast.LENGTH_LONG).show();
        String s = intent.getStringExtra("Msg");
        Toast.makeText(this,""+s,Toast.LENGTH_LONG).show();
        return START_NOT_STICKY;
    }
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public boolean onUnbind(Intent intent) {
        //return super.onUnbind(intent);
        return mAllowRebind;
    }

    @Override
    public void onRebind(Intent intent) {
        super.onRebind(intent);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Toast.makeText(this,"Service destroyed",Toast.LENGTH_LONG).show();
    }
}
