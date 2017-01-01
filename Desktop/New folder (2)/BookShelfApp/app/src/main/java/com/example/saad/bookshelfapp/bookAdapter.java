package com.example.saad.bookshelfapp;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by saad on 12/17/2016.
 */
public class bookAdapter extends ArrayAdapter<Book> {
    public bookAdapter(Activity context, ArrayList<Book> list) {
        super(context, 0, list);
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Gets the AndroidFlavor object from the ArrayAdapter at the appropriate position
        Book currentWord = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.my_list, parent, false);
        }





        TextView book_name = (TextView) convertView.findViewById(R.id.book_name);
        book_name.setText(currentWord.getmBook());

        TextView book_author = (TextView) convertView.findViewById(R.id.book_author);
        book_author.setText(currentWord.getmAuthor());

        TextView book_selflink = (TextView) convertView.findViewById(R.id.book_selflink);
        book_selflink.setText(currentWord.getmSelflink());

        return convertView;
    }
}
