package com.example.musicplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    //Create objects for Image Buttons
    private ImageButton Start;
    private ImageButton Stop;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //map objects to buttons
        Start = findViewById(R.id.play);
        Stop = findViewById(R.id.stop);
        //hide the stop button initially
        Stop.setVisibility(View.GONE);
        //onclickListeners for each buttons
        Start.setOnClickListener(this);
        Stop.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        //if the button clicked is start the service, hide the start button and display the stop button
        if(view == Start){
            startService(new Intent( this, MusicPlay.class ) );
            Start.setVisibility(View.GONE);
            Stop.setVisibility(View.VISIBLE);

        }else{//if the button clicked is stop the service, hide the stop button and display the start button
            stopService(new Intent( this, MusicPlay.class ) );
            Stop.setVisibility(View.GONE);
            Start.setVisibility(View.VISIBLE);
        }
    }
}