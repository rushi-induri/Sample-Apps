package com.induri.rushi.service_name;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import java.util.Calendar;

/**
 * Created by Sony on 09-03-2016.
 */
public class CustomBrodcastReciever extends BroadcastReceiver {
    private static final long REPEAT_TIME = 1000*30 ;

    @Override
    public void onReceive(Context context, Intent intent) {
       // Intent i = new Intent(context,FetchDataService.class);
        //context.startService(i);
        Intent i = new Intent(context,FetchDataService.class);
        AlarmManager am = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(context,1,i,PendingIntent.FLAG_CANCEL_CURRENT);
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.SECOND,30);
        am.setInexactRepeating(AlarmManager.RTC_WAKEUP,cal.getTimeInMillis(),REPEAT_TIME,pendingIntent);
    }
}
