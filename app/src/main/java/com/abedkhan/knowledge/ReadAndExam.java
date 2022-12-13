package com.abedkhan.knowledge;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;

import com.abedkhan.knowledge.Adapters.ReadExamFragmentAdapter;
import com.abedkhan.knowledge.databinding.ActivityReadAndExamBinding;

public class ReadAndExam extends AppCompatActivity {
ActivityReadAndExamBinding binding;
FragmentManager fragmentManager;
ReadExamFragmentAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityReadAndExamBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());



fragmentManager=getSupportFragmentManager();
adapter=new ReadExamFragmentAdapter(fragmentManager,101);
binding.readExamViewpager.setAdapter(adapter);
binding.tabLayout.setupWithViewPager(binding.readExamViewpager);











    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(this,MainActivity.class));
        finish();
    }
}