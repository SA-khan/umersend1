package com.example.saad.inventrymanagementapp;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by saad on 12/22/2016.
 */
public class WordAdaptor extends ArrayAdapter<Word> {
    public WordAdaptor(Activity context, ArrayList<Word> list) {
        super(context, 0, list);
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Gets the AndroidFlavor object from the ArrayAdapter at the appropriate position
        Word currentWord = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }





        TextView versionNameView = (TextView) convertView.findViewById(R.id.id1);
        versionNameView.setText(String.valueOf(currentWord.getMid()));

        TextView versionNumberView = (TextView) convertView.findViewById(R.id.name);
        versionNumberView.setText(currentWord.getmName());

        TextView type = (TextView) convertView.findViewById(R.id.type);
        type.setText(currentWord.getmType());

        TextView price = (TextView) convertView.findViewById(R.id.price);
        price.setText(String.valueOf(currentWord.getMPrice()));
        return convertView;
    }
}
