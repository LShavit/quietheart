package com.example.quietheart;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.webkit.WebView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class FifthActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);

        WebView webView = findViewById(R.id.webView);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl("https://dotadomination.kyiv.ua/");

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation_view);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Intent intent;
                if (item.getItemId() == R.id.action_third) {
                    intent = new Intent(FifthActivity.this, ThirdActivity.class);
                    startActivity(intent);
                    return true;
                } else if (item.getItemId() == R.id.action_fourth) {
                    intent = new Intent(FifthActivity.this, FourthActivity.class);
                    startActivity(intent);
                    return true;
                } else if (item.getItemId() == R.id.action_fifth) {
                    intent = new Intent(FifthActivity.this, FifthActivity.class);
                    startActivity(intent);
                    return true;
                } else if (item.getItemId() == R.id.action_six) {
                    intent = new Intent(FifthActivity.this, SixActivity.class);
                    startActivity(intent);
                    return true;
                }
                return false;
            }
        });

        bottomNavigationView.getMenu().getItem(0).setChecked(false);
    }
}
