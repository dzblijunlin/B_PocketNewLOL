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
public class AllHeroFragment extends Fragment {


    public AllHeroFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_all_hero, container, false);
    }

}