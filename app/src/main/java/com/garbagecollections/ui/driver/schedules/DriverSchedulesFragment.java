package com.garbagecollections.ui.driver.schedules;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.Calendar;

import com.garbagecollections.R;
import com.garbagecollections.utils.helps.DatePickerHelper;

public class DriverSchedulesFragment extends Fragment {

    private DriverSchedulesViewModel mViewModel;

    public static DriverSchedulesFragment newInstance() {
        return new DriverSchedulesFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        assert inflater != null;
        View rootView = inflater.inflate(R.layout.fragment_driver_schedules, null);

        // TO DO
        DatePickerHelper datePickerHelper = new DatePickerHelper(requireContext(), new DatePickerHelper.OnDateSetListener() {
            @Override
            public void onDateSet(android.widget.DatePicker view, int selectedYear, int selectedMonth, int selectedDayOfMonth) {
                System.out.println(selectedYear);
                System.out.println(selectedMonth);
                System.out.println(selectedDayOfMonth);
            }
        });

        datePickerHelper.show();

        return rootView;
    }

    @NonNull
    @Override
    public String toString(){
        return "DriverSchedulesFragment";
    }


}