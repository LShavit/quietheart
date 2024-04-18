package com.example.quietheart;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class ThirdActivity extends AppCompatActivity {

    private MediaPlayer mediaPlayer1;
    private MediaPlayer mediaPlayer2;
    private MediaPlayer mediaPlayer3;

    private ImageView playButton1;
    private ImageView playButton2;
    private ImageView playButton3;
    private TextView timeTextView1;
    private TextView timeTextView2;
    private TextView timeTextView3;

    private Handler mHandler1 = new Handler();
    private Handler mHandler2 = new Handler();
    private Handler mHandler3 = new Handler();

    private int currentPosition1 = 0;
    private int currentPosition2 = 0;
    private int currentPosition3 = 0;
    private boolean isPaused1 = false;
    private boolean isPaused2 = false;
    private boolean isPaused3 = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        Window window = getWindow();
        window.setStatusBarColor(getResources().getColor(R.color.white));

        playButton1 = findViewById(R.id.knkazka1ImageView);
        playButton2 = findViewById(R.id.knkazka2ImageView);
        playButton3 = findViewById(R.id.knkazka3ImageView);
        timeTextView1 = findViewById(R.id.timeTextView1);
        timeTextView2 = findViewById(R.id.timeTextView2);
        timeTextView3 = findViewById(R.id.timeTextView3);

        mediaPlayer1 = MediaPlayer.create(this, R.raw.smihuha);
        mediaPlayer2 = MediaPlayer.create(this, R.raw.homik);
        mediaPlayer3 = MediaPlayer.create(this, R.raw.mriynik);

        playButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playAudio(mediaPlayer1, playButton1, mHandler1, timeTextView1, currentPosition1, isPaused1);
            }
        });

        playButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playAudio(mediaPlayer2, playButton2, mHandler2, timeTextView2, currentPosition2, isPaused2);
            }
        });

        playButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playAudio(mediaPlayer3, playButton3, mHandler3, timeTextView3, currentPosition3, isPaused3);
            }
        });

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation_view);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Intent intent;
                if (item.getItemId() == R.id.action_third) {
                    intent = new Intent(ThirdActivity.this, ThirdActivity.class);
                    startActivity(intent);
                    return true;
                } if (item.getItemId() == R.id.action_fourth) {
                    intent = new Intent(ThirdActivity.this, FourthActivity.class);
                    startActivity(intent);
                    return true;
                } if (item.getItemId() == R.id.action_fifth) {
                    intent = new Intent(ThirdActivity.this, FifthActivity.class);
                    startActivity(intent);
                    return true;
                } if (item.getItemId() == R.id.action_six) {
                    intent = new Intent(ThirdActivity.this, SixActivity.class);
                    startActivity(intent);
                    return true;
                }
                return false;
            }
        });

        bottomNavigationView.getMenu().getItem(0).setChecked(false);
    }

    private void playAudio(MediaPlayer mediaPlayer, ImageView playButton, Handler handler, TextView timeTextView, int currentPosition, boolean isPaused) {
        try {
            if (mediaPlayer.isPlaying()) {
                mediaPlayer.pause();
                playButton.setImageResource(R.drawable.img_g);
                saveCurrentPosition(mediaPlayer, currentPosition);
                if (!isPaused) {
                    resetTimer(handler, timeTextView);
                }
            } else {
                mediaPlayer.seekTo(getSavedCurrentPosition(mediaPlayer, currentPosition));
                mediaPlayer.start();
                playButton.setImageResource(R.drawable.img_g2);
                updateSeekBar(mediaPlayer, handler, timeTextView);
                updatePlayButtonImage(mediaPlayer, playButton);
            }
        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(ThirdActivity.this, "Error playing audio", Toast.LENGTH_SHORT).show();
        }
    }

    private void saveCurrentPosition(MediaPlayer mediaPlayer, int currentPosition) {
        if (mediaPlayer == mediaPlayer1) {
            currentPosition1 = mediaPlayer.getCurrentPosition();
        } else if (mediaPlayer == mediaPlayer2) {
            currentPosition2 = mediaPlayer.getCurrentPosition();
        } else if (mediaPlayer == mediaPlayer3) {
            currentPosition3 = mediaPlayer.getCurrentPosition();
        }
    }

    private int getSavedCurrentPosition(MediaPlayer mediaPlayer, int currentPosition) {
        if (mediaPlayer == mediaPlayer1) {
            return currentPosition1;
        } else if (mediaPlayer == mediaPlayer2) {
            return currentPosition2;
        } else if (mediaPlayer == mediaPlayer3) {
            return currentPosition3;
        }
        return 0;
    }

    private void updateSeekBar(MediaPlayer mediaPlayer, Handler handler, TextView timeTextView) {
        Runnable mRunnable = new Runnable() {
            @Override
            public void run() {
                int currentPosition = mediaPlayer.getCurrentPosition() / 1000;
                int minutes = currentPosition / 60;
                int seconds = currentPosition % 60;
                String time = String.format("%02d:%02d", minutes, seconds);
                timeTextView.setText(time);
                handler.postDelayed(this, 1000);

                if (!mediaPlayer.isPlaying()) {
                    resetTimer(handler, timeTextView);
                }
            }
        };
        handler.postDelayed(mRunnable, 0);
    }

    private void resetTimer(Handler handler, TextView timeTextView) {
        handler.removeCallbacksAndMessages(null);
        timeTextView.setText("00:00");
    }

    private void updatePlayButtonImage(MediaPlayer mediaPlayer, ImageView playButton) {
        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                playButton.setImageResource(R.drawable.img_g);
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mHandler1.removeCallbacksAndMessages(null);
        mHandler2.removeCallbacksAndMessages(null);
        mHandler3.removeCallbacksAndMessages(null);
        if (mediaPlayer1 != null) {
            mediaPlayer1.release();
        }
        if (mediaPlayer2 != null) {
            mediaPlayer2.release();
        }
        if (mediaPlayer3 != null) {
            mediaPlayer3.release();
        }
    }
}
