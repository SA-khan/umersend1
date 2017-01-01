package com.example.saad.firebasechat;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by saad on 12/25/2016.
 */
public class WordAdapter extends ArrayAdapter<Word> {
        public WordAdapter(Activity context, ArrayList<Word> list) {
            super(context, 0, list);
        }
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            // Gets the AndroidFlavor object from the ArrayAdapter at the appropriate position
            Word currentWord = getItem(position);

            if (convertView == null) {
                convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
            }





            TextView versionNameView = (TextView) convertView.findViewById(R.id.one);
            versionNameView.setText(currentWord.getDefaultTranslate());

           // TextView versionNumberView = (TextView) convertView.findViewById(R.id.lutti);
           // versionNumberView.setText(currentWord.getMivokTranslate());

            return convertView;
        }
    }

