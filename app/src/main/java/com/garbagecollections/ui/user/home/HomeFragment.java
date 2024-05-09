package com.garbagecollections.ui.user.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.garbagecollections.DriverDrawerActivity;
import com.garbagecollections.R;
import com.garbagecollections.activities.Login;
import com.garbagecollections.activities.user.UserFeedback;
import com.garbagecollections.databinding.FragmentHomeBinding;
import com.garbagecollections.utils.models.helpers.FeedbackHelper;
import com.google.android.gms.location.LocationServices;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        assert inflater != null;
        View rootView = inflater.inflate(R.layout.fragment_home, null);

        Button feedbackView = rootView.findViewById(R.id.feedback_view_btn);
        feedbackView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent userFeedback = new Intent(requireContext(), UserFeedback.class);
                startActivity(userFeedback);
            }
        });

        return rootView;
    }

    @NonNull
    @Override
    public String toString() {
        return "HomeFragment";
    }

}