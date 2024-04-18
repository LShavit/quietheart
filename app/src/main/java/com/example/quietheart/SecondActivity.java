package com.example.quietheart;

import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.widget.Toast;
import androidx.annotation.NonNull;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import androidx.appcompat.app.AppCompatActivity;
import android.view.MenuItem;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Window window = getWindow();
        window.setStatusBarColor(getResources().getColor(R.color.blue));

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation_view);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Intent intent;
                if (item.getItemId() == R.id.action_third) {
                    intent = new Intent(SecondActivity.this, ThirdActivity.class);
                    startActivity(intent);
                    return true;
                } if (item.getItemId() == R.id.action_fourth) {
                    intent = new Intent(SecondActivity.this, FourthActivity.class);
                    startActivity(intent);
                    return true;
                } if (item.getItemId() == R.id.action_fifth) {
                    intent = new Intent(SecondActivity.this, FifthActivity.class);
                    startActivity(intent);
                    return true;
                } if (item.getItemId() == R.id.action_six) {
                    intent = new Intent(SecondActivity.this, SixActivity.class);
                    startActivity(intent);
                    return true;
                }

                return false;
            }
        });

        bottomNavigationView.getMenu().getItem(0).setChecked(false);
    }

    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}