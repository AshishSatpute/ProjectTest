package com.ashish.sevice;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;

public class MyForgoundService extends Service {


    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
       /* new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    Log.i("forgound", "runing: ");
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                    }
                }
            }
        }).start();*/

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    Log.i("backgound", "runing: " + i);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        }).start();
        //   stopSelf();

        Log.i("forgound", "runing: ");


        final String CHANNELID = "Forgound Service id";

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            NotificationChannel notificationChannel = new NotificationChannel(
                    CHANNELID,
                    CHANNELID,
                    NotificationManager.IMPORTANCE_LOW
            );
            getSystemService(NotificationManager.class).createNotificationChannel(notificationChannel);

            Notification.Builder notifation = new Notification.Builder(this, CHANNELID)
                    .setContentText("Service is reunning")
                    .setContentTitle("Service enable")
                    .setSmallIcon(R.drawable.ic_launcher_background);
            startForeground(1001, notifation.build());
        }


        return super.onStartCommand(intent, flags, startId);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
