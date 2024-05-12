package com.garbagecollections.ui.user.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;


import com.garbagecollections.R;
import com.garbagecollections.activities.user.EditProfile;
import com.garbagecollections.activities.user.UserFeedback;
import com.garbagecollections.databinding.FragmentHomeBinding;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        assert inflater != null;
        View rootView = inflater.inflate(R.layout.fragment_home, null);

        // Feedback
        Button feedbackView = rootView.findViewById(R.id.feedback_view_btn);
        feedbackView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent userFeedback = new Intent(requireContext(), UserFeedback.class);
                startActivity(userFeedback);
            }
        });

        // Edit profile
        Button editPro = rootView.findViewById(R.id.editProfile);
        editPro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent userEdit = new Intent(requireContext(), EditProfile.class);
                startActivity(userEdit);
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