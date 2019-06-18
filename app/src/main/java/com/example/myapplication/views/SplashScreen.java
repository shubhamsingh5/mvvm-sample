package com.example.myapplication.views;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        handler.sendEmptyMessageDelayed(100, 3000);
    }

    // Add event to looper
    // Looper is a worker that keeps a thread alive, loops through MessageQueue and sends
    // messages to the corresponding handler to process.
    // Handler enqueues tasks in the MessageQueue using Looper and also executes them.
    // In this case task runs on UI thread.
    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            if (msg.what == 100) {
                Intent i = new Intent(SplashScreen.this, MainActivity.class);
                startActivity(i);
                finish();
            }
        }
    };
}
