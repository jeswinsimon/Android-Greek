package com.jeswinsimon.greek;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class MainActivityFragment extends Fragment {

    private AlphabetAdapter adapter;

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);

        AlphabetParser alphabetParser = new AlphabetParser();
        InputStream inputStream = getResources().openRawResource(R.raw.greek);
        final ArrayList<Alphabet> alphabetsArrayList = alphabetParser.getAlphabets(inputStream);

        adapter = new AlphabetAdapter(this.getActivity(), alphabetsArrayList);
        ListView listView = (ListView) rootView.findViewById(R.id.list_view_alphabets);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Alphabet alphabet = alphabetsArrayList.get(position);
                Intent alphabetIntent = new Intent(getActivity(), DetailActivity.class).putExtra("alphabet", alphabet);
                startActivity(alphabetIntent);
            }
        });

        return rootView;
    }
}
