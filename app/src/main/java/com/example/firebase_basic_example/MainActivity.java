package com.example.firebase_basic_example;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;

import com.google.firebase.iid.FirebaseInstanceId;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

              FirebaseInstanceId.getInstance().getInstanceId().addOnSuccessListener(MainActivity.this, instanceIdResult -> {
               String newToken = instanceIdResult.getToken();
         });
        NotificationPermissionHandler notificationPermissionHandler = null;

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            notificationPermissionHandler = new NotificationPermissionHandler(this);
        }

// Check permission and request if necessary
        if (notificationPermissionHandler != null) {
            notificationPermissionHandler.checkAndRequestPermission();
        }

    }

}