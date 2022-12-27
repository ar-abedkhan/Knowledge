package com.abedkhan.knowledge.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;

import com.abedkhan.knowledge.Adapters.QuestionListAdapter;
import com.abedkhan.knowledge.Modelclass.QuestionListModel;
import com.abedkhan.knowledge.R;
import com.abedkhan.knowledge.databinding.ActivityGiveExamOrReadQuestionsBinding;

import java.util.ArrayList;
import java.util.List;

public class GiveExamOrReadQuestions extends AppCompatActivity {

    ActivityGiveExamOrReadQuestionsBinding binding;
    List<QuestionListModel>questionListModelList;
    ViewPager viewPager;
    Intent intent;
    String storageId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityGiveExamOrReadQuestionsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

//        viewPager = findViewById(R.id.examOrReadFragmentHolder);
        intent = getIntent();
//        storageId=intent.getStringExtra("firebaseStorageID");

        questionListModelList=new ArrayList<>();




        if (intent.hasExtra("firebaseStorageID")){

            QuestionListAdapter questionListAdapter=new QuestionListAdapter(questionListModelList,this);
            binding.readQuestionListRecycler.setAdapter(questionListAdapter);


//
//            if (intent.getBooleanExtra("isExam", false)){
////                ..................TODO: ekhane exam dewar jonnu fragment ta open korben...................
//
//                FragmentTransaction ft = getFragmentManager().beginTransaction();
////                ft.add().commit();
//            }
//            else {
//
////                   ..................TODO: ekhane read er jonnu fragment ta open korben...................
//            }
        }

    }
}