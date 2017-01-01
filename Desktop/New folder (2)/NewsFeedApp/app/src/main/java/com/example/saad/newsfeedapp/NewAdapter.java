package com.example.saad.newsfeedapp;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by saad on 12/19/2016.
 */
public class NewAdapter extends ArrayAdapter<New> {
    public NewAdapter(Activity context, ArrayList<New> list) {
        super(context, 0, list);
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Gets the AndroidFlavor object from the ArrayAdapter at the appropriate position
        New currentWord = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.my_list, parent, false);
        }





        TextView title = (TextView) convertView.findViewById(R.id.title);
        title.setText(currentWord.getmTitle());

        TextView author = (TextView) convertView.findViewById(R.id.author);
        author.setText(currentWord.getmAuthor());

        TextView publishedAt = (TextView) convertView.findViewById(R.id.publishedAt);
        publishedAt.setText(currentWord.getmPublichedAt());

        return convertView;
    }
}
