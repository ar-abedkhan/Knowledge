package com.abedkhan.knowledge.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;

import com.abedkhan.knowledge.R;

public class GiveExamOrReadQuestions extends AppCompatActivity {

    ViewPager viewPager;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_give_exam_or_read_questions);

        viewPager = findViewById(R.id.examOrReadFragmentHolder);
        intent = getIntent();

        if (intent.hasExtra("firebaseStorageID")){
            if (intent.getBooleanExtra("isExam", false)){
//                ..................TODO: ekhane exam dewar jonnu fragment ta open korben...................

                FragmentTransaction ft = getFragmentManager().beginTransaction();
//                ft.add().commit();
            }
            else {
//                   ..................TODO: ekhane read er jonnu fragment ta open korben...................
            }
        }

    }
}