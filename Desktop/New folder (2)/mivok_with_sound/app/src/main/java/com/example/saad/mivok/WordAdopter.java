package com.example.saad.mivok;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by saad on 9/24/2016.
 */
public class WordAdopter extends ArrayAdapter<Words>{
    public WordAdopter(Activity context, ArrayList<Words> words) {
        // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
        // the second argument is used when the ArrayAdapter is populating a single TextView.
        // Because this is a custom adapter for two TextViews and an ImageView, the adapter is not
        // going to use this second argument, so it can be any value. Here, we used 0.
        super(context, 0, words);
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Gets the AndroidFlavor object from the ArrayAdapter at the appropriate position


        View listItemView = convertView;

        // Adapters recycle views to AdapterViews.
        // If this is a new View object we're getting, then inflate the layout.
        // If not, this view already has the layout inflated from a previous call to getView,
        // and we modify the View widgets as usual.
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }

        Words currentWord = getItem(position);




        TextView DefaultTrans = (TextView) listItemView.findViewById(R.id.defaultTrans);
        DefaultTrans.setText(currentWord.getmDefaultTranslation());

        TextView MivokTrans = (TextView) listItemView.findViewById(R.id.mivokTrans);
        MivokTrans.setText(currentWord.getmMivokTranslation());

        ImageView imageView = (ImageView) listItemView.findViewById(R.id.image);
        imageView.setImageResource(currentWord.getmImageResourceId());

        return listItemView;
    }
}

