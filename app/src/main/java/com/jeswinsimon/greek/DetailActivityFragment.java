package com.jeswinsimon.greek;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * A placeholder fragment containing a simple view.
 */
public class DetailActivityFragment extends Fragment {

    public DetailActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Intent intent = getActivity().getIntent();
        View rootView =  inflater.inflate(R.layout.fragment_detail, container, false);

        if(intent != null && intent.hasExtra("alphabet")){
            Alphabet alphabet = intent.getParcelableExtra("alphabet");

            getActivity().setTitle((CharSequence) alphabet.name);

            ((TextView) rootView.findViewById(R.id.text_view_name)).setText(alphabet.name);
            ((TextView) rootView.findViewById(R.id.text_view_uppercase)).append(alphabet.uppercase);
            ((TextView) rootView.findViewById(R.id.text_view_lowercase)).append(alphabet.lowercase);
            ((TextView) rootView.findViewById(R.id.text_view_description)).setText(alphabet.description);

        }

        return rootView;
    }
}
