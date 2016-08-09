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
public class Third_fragment extends Fragment {


    public Third_fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_third_fragment, container, false);
        ImageView iv = (ImageView) view.findViewById(R.id.iv_link_page3);
        return view;
    }

}
