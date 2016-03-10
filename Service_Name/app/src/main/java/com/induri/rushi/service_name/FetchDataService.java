package com.induri.rushi.service_name;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Sony on 09-03-2016.
 */
public class FetchDataService extends Service {

    private final Binder databinder = new DataBinder();

    public ArrayList<String> getNames() {
        return names;
    }

    private ArrayList<String> names = new ArrayList<>();
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return databinder;
    }

    public class DataBinder extends Binder {
        FetchDataService getService(){
            return FetchDataService.this;
        }
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Random r = new Random();
        if(r.nextBoolean()){
            names.add("Rahul");
        }
        if(r.nextBoolean()){
            names.add("Rohith");
        }
        if(r.nextBoolean()){
            names.add("Rushi");
        }
        if(r.nextBoolean()){
            names.add("Harsha");
        }

        return Service.START_NOT_STICKY;
    }
}
