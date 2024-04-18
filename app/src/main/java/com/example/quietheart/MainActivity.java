package com.example.quietheart;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Window window = getWindow();
        window.setStatusBarColor(getResources().getColor(R.color.white2));
    }

    public void onHeartClick(View view) {
<<<<<<< HEAD
        Intent intent = new Intent(this, SecondActivity.class);
=======
        Intent intent = new Intent(this, FourthActivity.class);
>>>>>>> 88706a12a60adeb406b59000ecc260abcc9e3c85
        startActivity(intent);
    }
}
