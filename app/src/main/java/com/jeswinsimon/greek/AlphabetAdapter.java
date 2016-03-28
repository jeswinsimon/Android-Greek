package com.jeswinsimon.greek;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by jeswinsimon on 27/03/16.
 */
public class AlphabetAdapter extends ArrayAdapter<Alphabet> {

    public AlphabetAdapter(Context context, ArrayList<Alphabet> alphabets) {
        super(context, 0, alphabets);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Alphabet alphabet = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item_alphabet, parent, false);
        }

        TextView alphabetName = (TextView) convertView.findViewById(R.id.list_item_alphabet_text_view);
        alphabetName.setText(alphabet.name);
        return convertView;
    }


}
