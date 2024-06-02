package com.example.quietheart;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class FourthActivity extends AppCompatActivity {

    private VideoView videoView;
    private Button buttonPlayPause;
    private Button buttonNext;
    private int currentVideo = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourth);

        videoView = findViewById(R.id.videoView1);
        buttonPlayPause = findViewById(R.id.buttonPlayPause);
        buttonNext = findViewById(R.id.buttonNext);

        playVideo(currentVideo);

        buttonPlayPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                togglePlayPause();
            }
        });

        buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playNextVideo();
            }
        });

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation_view);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Intent intent;
                if (item.getItemId() == R.id.action_third) {
                    intent = new Intent(FourthActivity.this, ThirdActivity.class);
                    startActivity(intent);
                    return true;
                } else if (item.getItemId() == R.id.action_fourth) {
                    intent = new Intent(FourthActivity.this, FourthActivity.class);
                    startActivity(intent);
                    return true;
                } else if (item.getItemId() == R.id.action_fifth) {
                    intent = new Intent(FourthActivity.this, FifthActivity.class);
                    startActivity(intent);
                    return true;
                } else if (item.getItemId() == R.id.action_six) {
                    intent = new Intent(FourthActivity.this, SixActivity.class);
                    startActivity(intent);
                    return true;
                }
                return false;
            }
        });

        bottomNavigationView.getMenu().getItem(0).setChecked(false);
    }

    private void playVideo(int videoIndex) {
        if (videoView.isPlaying()) {
            videoView.stopPlayback();
        }

        String videoPath = "android.resource://" + getPackageName() + "/raw/video" + videoIndex;
        Uri uri = Uri.parse(videoPath);
        videoView.setVideoURI(uri);

        MediaController mediaController = new MediaController(this);
        videoView.setMediaController(mediaController);

        videoView.start();
        currentVideo = videoIndex;
    }

    public void togglePlayPause() {
        if (videoView.isPlaying()) {
            videoView.pause();
            buttonPlayPause.setText("Play");
        } else {
            videoView.start();
            buttonPlayPause.setText("Pause");
        }
    }

    public void playNextVideo() {
        if (currentVideo == 1) {
            playVideo(2);
        } else {
            playVideo(1);
        }
    }
}
