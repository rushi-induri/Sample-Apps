package com.induri.rushi.service_binded;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by Sony on 11-03-2016.
 */
public class Binded_Service extends Service {
    private final IBinder mbinder = new LocalBinder();
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return mbinder;
    }

    public class LocalBinder extends Binder{

        public Binded_Service getService(){
            return Binded_Service.this;
        }

    }

    public int findFactorial( int a){
        int fact = 1;
        for (int i=1;i<=a;i++){
            fact = fact*i;
        }
        return fact;
    }
}
