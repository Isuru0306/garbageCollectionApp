package com.garbagecollections.utils.helps;

import android.app.DatePickerDialog;
import android.content.Context;
import android.widget.DatePicker;

import java.util.Calendar;
public class DatePickerHelper {

    private final Context context;
    private final OnDateSetListener listener;

    public DatePickerHelper(Context context, OnDateSetListener listener) {
        this.context = context;
        this.listener = listener;
    }

    public void show() {
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(context,
                listener::onDateSet, year, month, dayOfMonth);

        datePickerDialog.show();
    }

    public interface OnDateSetListener {
        void onDateSet(DatePicker view, int year, int month, int dayOfMonth);
    }
}
