package com.android.zpp.myskip;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.view.View;

import com.android.zpp.myskip.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding activityMainBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(activityMainBinding.getRoot());
        if (!MyAccessibilityService.isStart()) {
            try {
                startActivity(new Intent(Settings.ACTION_ACCESSIBILITY_SETTINGS));
            } catch (Exception e) {
                startActivity(new Intent(Settings.ACTION_SETTINGS));
                e.printStackTrace();
            }
        }
        if (MyAccessibilityService.mService != null) {
            activityMainBinding.status.setText("辅助功能开启");
        } else {
            activityMainBinding.status.setText("辅助功能未开启");
        }
        activityMainBinding.status.setOnClickListener(v -> {
            try {
                startActivity(new Intent(Settings.ACTION_ACCESSIBILITY_SETTINGS));
            } catch (Exception e) {
                startActivity(new Intent(Settings.ACTION_SETTINGS));
                e.printStackTrace();
            }
        });
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        if (MyAccessibilityService.mService != null) {
            activityMainBinding.status.setText("辅助功能开启");
        } else {
            activityMainBinding.status.setText("辅助功能未开启");
        }
    }
}