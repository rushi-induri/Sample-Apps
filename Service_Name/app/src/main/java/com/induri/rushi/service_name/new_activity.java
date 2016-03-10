package com.induri.rushi.service_name;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import java.util.ServiceConfigurationError;

/**
 * Created by Sony on 09-03-2016.
 */
public class new_activity extends AppCompatActivity {

    private FetchDataService service;



    @Override
    protected void onResume() {
        super.onResume();
        Intent i = new Intent(this,FetchDataService.class);
        bindService(i,connection, Context.BIND_AUTO_CREATE);
    }

    @Override
    protected void onPause() {
        super.onPause();
        unbindService(connection);
    }

    private ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder binder) {
            FetchDataService.DataBinder b = (FetchDataService.DataBinder) binder;
            service = b.getService();
            Toast.makeText(new_activity.this,"Connection Succesful",Toast.LENGTH_LONG).show();
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            service = null;
        }
    };
}
