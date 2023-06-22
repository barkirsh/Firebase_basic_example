package com.example.firebase_basic_example;

import android.os.Build;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        NotificationPermissionHandler notificationPermissionHandler = null;

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            notificationPermissionHandler = new NotificationPermissionHandler(this);
        }

        // Check permission and request if necessary
        if (notificationPermissionHandler != null) {
            notificationPermissionHandler.checkAndRequestPermission();
        }
    }
}
