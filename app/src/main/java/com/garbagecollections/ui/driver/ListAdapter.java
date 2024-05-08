package com.garbagecollections.ui.driver;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.garbagecollections.R;

import java.util.List;

public class ListAdapter extends ArrayAdapter<String> {

    public ListAdapter(Context context, List<String> items) {
        super(context, 0, items);
    }


    @Override
    public View getView(int position, View convertView,ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_view, parent, false);
        }

        String item = getItem(position);

        TextView listItemText = listItemView.findViewById(R.id.listItemText);
        listItemText.setText(item);

        return listItemView;
    }
}
