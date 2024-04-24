package com.garbagecollections.ui.admin;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.garbagecollections.R;
import com.garbagecollections.ui.admin.home.AdminHomeFragment;

public class AdminHome extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_home);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, AdminHomeFragment.newInstance())
                    .commitNow();
        }
    }
}