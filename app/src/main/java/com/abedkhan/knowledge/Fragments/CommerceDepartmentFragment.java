package com.abedkhan.knowledge.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.abedkhan.knowledge.R;
import com.abedkhan.knowledge.databinding.FragmentCommerceDepartmentBinding;

public class CommerceDepartmentFragment extends Fragment {

    public CommerceDepartmentFragment() {
        // Required empty public constructor
    }
FragmentCommerceDepartmentBinding binding;

//    View view;
//    FragmentManager fragmentManager = getFragmentManager();
//    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding=FragmentCommerceDepartmentBinding.inflate(getLayoutInflater(),container,false);







        return binding.getRoot();
    }
}