package com.garbagecollections.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.garbagecollections.ui.ui.dltdrivers.dlt_drivers;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, dlt_drivers.newInstance())
                    .commitNow();
        }
    }
}