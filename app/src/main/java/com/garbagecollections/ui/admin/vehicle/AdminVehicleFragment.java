package com.garbagecollections.ui.admin.vehicle;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.garbagecollections.R;
import com.google.firebase.Firebase;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AdminVehicleFragment extends Fragment {

    private AdminVehicleViewModel mViewModel;

    public static AdminVehicleFragment newInstance() {
        return new AdminVehicleFragment();
    }

    private EditText textView14, catagory, V_number;
    private Button add_button,del_button;
    private DatabaseReference rootDatabaseref;



    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(AdminVehicleViewModel.class);

        // TODO: Use the ViewModel
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_admin_vehicle, container, false);
    }

}