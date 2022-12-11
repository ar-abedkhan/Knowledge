package com.abedkhan.knowledge.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.abedkhan.knowledge.R;
import com.abedkhan.knowledge.databinding.FragmentExamBinding;

public class ExamFragment extends Fragment {

    public ExamFragment() {
    }
FragmentExamBinding binding;





    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding=FragmentExamBinding.inflate(getLayoutInflater(),container,false);














        return binding.getRoot();
    }
}