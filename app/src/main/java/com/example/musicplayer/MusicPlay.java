package com.example.musicplayer;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;

import androidx.annotation.Nullable;


public class MusicPlay extends Service {
    private MediaPlayer mp;

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        //create a media player service
        mp = MediaPlayer.create(this, R.raw.audio);
        //repeat the song again and again after the song ends
        mp.setLooping(true);
        //start the Service
        mp.start();

        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        //stop the Service
        mp.stop();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
