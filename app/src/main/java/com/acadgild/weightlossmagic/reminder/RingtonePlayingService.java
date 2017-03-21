package com.acadgild.weightlossmagic.reminder;

/**
 * Created by DivyaVipin on 2/28/2017.
 */import android.annotation.TargetApi;

import android.app.Notification;

import android.app.NotificationManager;

import android.app.PendingIntent;

import android.app.Service;

import android.content.Context;

import android.content.Intent;

import android.content.pm.PackageManager;

import android.media.AudioManager;

import android.media.MediaPlayer;

import android.media.RingtoneManager;

import android.net.Uri;

import android.os.Build;

import android.os.Environment;

import android.os.IBinder;

import android.provider.MediaStore;

import android.util.Log;

import android.widget.TextView;


import com.acadgild.weightlossmagic.R;

import java.io.IOException;

import java.util.Random;



public class RingtonePlayingService extends Service {



    private boolean isRunning;

    private Context context;

    MediaPlayer mMediaPlayer;

    private int startId;



    @Override

    public IBinder onBind(Intent intent)

    {

        return null;

    }





    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)

    @Override

    public int onStartCommand(Intent intent, int flags, int startId)

    {





        final NotificationManager mNM = (NotificationManager)

                getSystemService(NOTIFICATION_SERVICE);



        Intent intent1 = new Intent(this.getApplicationContext(), AlarmActivity.class);

        PendingIntent pIntent = PendingIntent.getActivity(this, 0, intent1, 0);

        String message=intent.getExtras().getString("reminder_message");

        Notification mNotify  = new Notification.Builder(this)

                .setContentTitle("Reminder Message:" + "!"+message)

                .setContentText(message)

                .setSmallIcon(R.drawable.reminder)

                .setContentIntent(pIntent)

                .setAutoCancel(true)

                .build();



        String state = intent.getExtras().getString("extra");

        assert state != null;

        switch (state) {

            case "no":

                startId = 0;

                break;

            case "yes":

                startId = 1;

                break;

            default:

                startId = 0;

                break;

        }




        if(!this.isRunning && startId == 1) {




            mMediaPlayer = MediaPlayer.create(this, R.raw.music1);

            mMediaPlayer.start();



            mNM.notify(0, mNotify);



            this.isRunning = true;

            this.startId = 0;



        }

        else if (!this.isRunning && startId == 0){




            this.isRunning = false;

            this.startId = 0;



        }



        else if (this.isRunning && startId == 1){

            this.isRunning = true;

            this.startId = 0;



        }

        else {


            mMediaPlayer.stop();

            mMediaPlayer.reset();



            this.isRunning = false;

            this.startId = 0;

        }


        return START_NOT_STICKY;

    }







    @Override

    public void onDestroy() {



        super.onDestroy();



        this.isRunning = false;

    }





}