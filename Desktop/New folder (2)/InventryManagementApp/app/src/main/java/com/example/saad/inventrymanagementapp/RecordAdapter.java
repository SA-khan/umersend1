package com.example.saad.inventrymanagementapp;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by saad on 12/21/2016.
 */
public class RecordAdapter extends ArrayAdapter<Record> {
    public RecordAdapter(Activity context, ArrayList<Record> list) {
        super(context, 0, list);
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Gets the AndroidFlavor object from the ArrayAdapter at the appropriate position
        Record currentWord = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.my_list, parent, false);
        }





        TextView ID = (TextView) convertView.findViewById(R.id.ID1);
        ID.setText(currentWord.getmID());

        TextView Name = (TextView) convertView.findViewById(R.id.Name1);
        Name.setText(currentWord.getmName());

        TextView Type = (TextView) convertView.findViewById(R.id.Type1);
        Type.setText(currentWord.getmType());

        TextView Cost = (TextView) convertView.findViewById(R.id.Price1);
        Type.setText(currentWord.getmCost());

        return convertView;
    }
}
