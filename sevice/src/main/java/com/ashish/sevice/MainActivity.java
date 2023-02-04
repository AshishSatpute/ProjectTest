package com.ashish.sevice;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityManagerCompat;
import androidx.core.content.ContextCompat;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.provider.SyncStateContract;
import android.view.TextureView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button stop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


       /*  Intent intent = new Intent(getApplicationContext(),MyBackgoundService.class);
         startService(intent);*/

        if (!forgoundServiceRunning()) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                Intent intent = new Intent(getApplicationContext(), MyForgoundService.class);
                getApplicationContext().startForegroundService(intent);
            }
        }


        stop = findViewById(R.id.stop);
        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (forgoundServiceRunning()) {
                    Intent intent = new Intent(getApplicationContext(), MyForgoundService.class);
                    stopService(intent);
                }

            }
        });

    }

    public boolean forgoundServiceRunning() {
        ActivityManager activityManager =
                (ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);

        for (ActivityManager.RunningServiceInfo serviceInfo : activityManager.getRunningServices(Integer.MAX_VALUE)) {
            if (MyForgoundService.class.getName().equals(serviceInfo.service.getClassName())) {
                return true;
            }
        }

        return false;
    }
}