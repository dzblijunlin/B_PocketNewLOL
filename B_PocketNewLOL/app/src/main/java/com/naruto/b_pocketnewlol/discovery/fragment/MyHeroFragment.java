package com.naruto.b_pocketnewlol.discovery.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.naruto.b_pocketnewlol.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class MyHeroFragment extends Fragment {


    public MyHeroFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_my_hero, container, false);
    }

}