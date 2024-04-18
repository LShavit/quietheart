package com.example.quietheart;

<<<<<<< HEAD
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.VideoView;

import androidx.annotation.NonNull;
=======
import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;
>>>>>>> 88706a12a60adeb406b59000ecc260abcc9e3c85
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

<<<<<<< HEAD
        videoView = findViewById(R.id.videoView1);
        buttonPlayPause = findViewById(R.id.buttonPlayPause);
        buttonNext = findViewById(R.id.buttonNext);

        // Установка пути к начальному видео
        playVideo(currentVideo);

        // Установка обработчика нажатия на кнопку Play/Pause
        buttonPlayPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                togglePlayPause();
            }
        });

        // Установка обработчика нажатия на кнопку Next
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

    // Метод для воспроизведения видео
    private void playVideo(int videoIndex) {
        // Останавливаем предыдущее видео, если оно играет
        if (videoView.isPlaying()) {
            videoView.stopPlayback();
        }

        // Устанавливаем новое видео
        String videoPath = "android.resource://" + getPackageName() + "/raw/video" + videoIndex;
        Uri uri = Uri.parse(videoPath);
        videoView.setVideoURI(uri);

        // Начинаем воспроизведение
        videoView.start();

        // Обновляем текущее видео
        currentVideo = videoIndex;
    }

    // Метод для переключения между воспроизведением и паузой
    public void togglePlayPause() {
        if (videoView.isPlaying()) {
            videoView.pause();
            buttonPlayPause.setText("Play");
        } else {
            videoView.start();
            buttonPlayPause.setText("Pause");
        }
    }

    // Метод для переключения на следующее видео
    public void playNextVideo() {
        if (currentVideo == 1) {
            playVideo(2);
        } else {
            playVideo(1);
        }
=======
        // Получаем путь к видео из ресурсов res/raw
        String videoPath = "android.resource://" + getPackageName() + "/" + R.raw.hand;

        // Находим видео-вью в макете
        VideoView videoView = findViewById(R.id.videoView);

        // Устанавливаем путь к видеофайлу
        Uri uri = Uri.parse(videoPath);
        videoView.setVideoURI(uri);

        // Создаем медиа-контроллер
        MediaController mediaController = new MediaController(this);
        mediaController.setAnchorView(videoView);

        // Устанавливаем медиа-контроллер для видео-вью
        videoView.setMediaController(mediaController);

        // Начинаем воспроизведение видео
        videoView.start();
>>>>>>> 88706a12a60adeb406b59000ecc260abcc9e3c85
    }
}
