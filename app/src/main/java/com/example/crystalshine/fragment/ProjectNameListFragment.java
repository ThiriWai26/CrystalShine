package com.example.crystalshine.fragment;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.crystalshine.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProjectNameListFragment extends Fragment {


    public ProjectNameListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_project_name_list, container, false);
    }

}
