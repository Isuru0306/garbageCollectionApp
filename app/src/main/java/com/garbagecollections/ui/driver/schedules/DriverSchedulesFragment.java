package com.garbagecollections.ui.driver.schedules;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.Toast;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

        ListView listView = (ListView) rootView.findViewById(R.id.listView);

        String[] items = {"Item 1", "Item 2", "Item 3", "Item 4", "Item 5"};
        List<String> itemList = new ArrayList<>(Arrays.asList(items));

        ListAdapter adapter = new ListAdapter (this, itemList);
        listView.setAdapter(adapter);

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