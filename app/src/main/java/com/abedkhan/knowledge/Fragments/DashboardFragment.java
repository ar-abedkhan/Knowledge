package com.abedkhan.knowledge.Fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SimpleAdapter;

import com.abedkhan.knowledge.MainActivity;
import com.abedkhan.knowledge.R;
import com.abedkhan.knowledge.databinding.FragmentDashboardBinding;

public class DashboardFragment extends Fragment {
    public DashboardFragment() {
        // Required empty public constructor
    }

    FragmentDashboardBinding binding;
    Intent intent;
    int userrightans,userwrongans,totalquestion;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
binding=FragmentDashboardBinding.inflate(getLayoutInflater(),container,false);

intent=getActivity().getIntent();




        userrightans=intent.getIntExtra("rightAns",0);
        binding.rightans.setText(""+userrightans);
        userwrongans=intent.getIntExtra("wrongAns",0);
        binding.wrongans.setText(""+userwrongans);

        totalquestion=intent.getIntExtra("totalquestion",0);


        binding.circularProgressBar.setProgress(userrightans);
        binding.progressscore.setText(userrightans+"/"+totalquestion);


binding.readAgain.setOnClickListener(view -> {
    startActivity(new Intent(requireContext(),ReadFragment.class));
});
binding.reExam.setOnClickListener(view -> {
    startActivity(new Intent(requireContext(),ExamFragment.class));
});
binding.backToHome.setOnClickListener(view -> {
    startActivity(new Intent(requireContext(), MainActivity.class));
});

        return binding.getRoot();
    }
}