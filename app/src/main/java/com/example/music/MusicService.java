package com.example.music;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

public class MusicService extends Service {
    private static final String TAG = "MusicService";
    MediaPlayer player;
    
    @Override
    public IBinder onBind(Intent intent){
        return null;
    }
    
    @Override
    public void onCreate() {
        Log.d(TAG, "onCreate()");
        
        player = MediaPlayer.create(this, R.raw.old_pop);
        player.setLooping(false); // Set looping
    }
    
    @Override
    public void onDestroy(){
        Toast.makeText(this, "Music Service Stop", Toast.LENGTH_LONG).show();
        Log.d(TAG, "onDestroy()");
        player.stop();
    }
    
    @Override
    public int onStartCommand(Intent intent, int flags, int startId){
        Toast.makeText(this, "Music Service Start", Toast.LENGTH_LONG).show();
        Log.d(TAG, "onStart()");
        player.start();
        return super.onStartCommand(intent, flags, startId);
    }
}
