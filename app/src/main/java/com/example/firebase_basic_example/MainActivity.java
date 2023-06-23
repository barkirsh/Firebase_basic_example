package com.example.firebase_basic_example;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import com.google.firebase.iid.FirebaseInstanceId;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
retrieveFCMToken();
        NotificationPermissionHandler notificationPermissionHandler = null;

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            notificationPermissionHandler = new NotificationPermissionHandler(this);
        }

        // Check permission and request if necessary
        if (notificationPermissionHandler != null) {
            notificationPermissionHandler.checkAndRequestPermission();
        }
    }
   private void retrieveFCMToken() {
        FirebaseInstanceId.getInstance().getInstanceId()
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        String token = task.getResult().getToken();
                        Log.d("FCM Token", token);
                        // TODO: Use the token as needed (e.g., send it to your server)
                   } else {
                        Log.w("FCM Token", "getInstanceId failed", task.getException());
                    }
                });
//    }

    }
}
