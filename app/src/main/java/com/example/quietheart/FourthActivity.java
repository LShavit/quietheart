package com.example.quietheart;

import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;
import androidx.appcompat.app.AppCompatActivity;

public class FourthActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourth);

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
    }
}
