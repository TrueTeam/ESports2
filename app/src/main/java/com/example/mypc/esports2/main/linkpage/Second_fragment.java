package com.example.mypc.esports2.main.linkpage;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.mypc.esports2.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Second_fragment extends Fragment {


    public Second_fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_second_fragment, container, false);
        ImageView iv = (ImageView) view.findViewById(R.id.iv_link_page2);
        return view;
    }

}
