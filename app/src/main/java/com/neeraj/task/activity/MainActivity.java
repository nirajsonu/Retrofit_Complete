package com.neeraj.task.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.neeraj.task.R;
import com.neeraj.task.dao.UserDao;

public class MainActivity extends AppCompatActivity {
public static final int TIMER=3000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                goToSecondActivity();
            }
        },TIMER);
    }

    private void goToSecondActivity() {
        startActivity(new Intent(getApplicationContext(),GetDataActivity.class));
        finish();
    }
}
