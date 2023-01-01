package com.abedkhan.knowledge.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.abedkhan.knowledge.Adapters.QuestionListAdapter;
import com.abedkhan.knowledge.Modelclass.FirebaseSubjectModel;
import com.abedkhan.knowledge.Modelclass.QuestionListModel;
import com.abedkhan.knowledge.R;
import com.abedkhan.knowledge.databinding.ActivityGiveExamOrReadQuestionsBinding;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class GiveExamOrReadQuestions extends AppCompatActivity {

    ActivityGiveExamOrReadQuestionsBinding binding;
    List<QuestionListModel>questionListModelList;
    List<FirebaseSubjectModel> firebaseSubjectModelList;
    ViewPager viewPager;
    Intent intent;
    String storageId,chapterNo,chaptername, subjectName;
    boolean isExam;

    FirebaseAuth firebaseAuth;
    DatabaseReference databaseReference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityGiveExamOrReadQuestionsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        firebaseAuth=FirebaseAuth.getInstance();
        databaseReference= FirebaseDatabase.getInstance().getReference();

//        viewPager = findViewById(R.id.examOrReadFragmentHolder);
        intent = getIntent();
//        storageId=intent.getStringExtra("firebaseStorageID");
        chapterNo=intent.getStringExtra("chapterNo");
        chaptername=intent.getStringExtra("chapterName");
        subjectName=intent.getStringExtra("subjectName");

        isExam = intent.getBooleanExtra("isExam", false);   //--- checking if it is for exam or only reading


//        questionListModelList=new ArrayList<>();
        firebaseSubjectModelList=new ArrayList<>();
        showDataToAdapter(chaptername);

        binding.chapterNo.setText(chapterNo);



// vai ekhane ami data bse use kore call korsi adapter theke bt question show hoi na besh kichu bhul ase bujte parsi..dekhte hobe...ami asi check korbo...
 // ar questionlist name j model korsi oita bad diya sob firebasemodel e ani dekhbo taile hobe asha kori ar ekta jamela ase..
 //seta hocche amra to sob gula list e rakhsi chapter no er under e rakhi nai so dekgte gobe chapte no call korle sob ase kina..
 //r apni puarata 1bar check diyen....give questionExam page e layout bosaisi gone kre rakhsi r question er kj korsi



        if (isExam){
            binding.readQuestionListRecycler.setVisibility(View.GONE);
            binding.examLayout.setVisibility(View.VISIBLE);

            Log.i("TAG", "--------------------EXAM---------------------------");
//            FirebaseSubjectModel model = firebaseSubjectModelList.get(0);
//            TODO: ekhane firebaseSubject model theke data pacche nah

//            Log.i("TAG", "---------Exam--: "+model.getQuestion());
//            Log.i("TAG", "---------Exam--: "+model.getOption1());

//            binding.questionTv.setText(model.getQuestion());
//
//            binding.questionTv.setText(model.getQuestion());
//
//            binding.answerOne.setText(model.getRightAnswer());
//            binding.answerTwo.setText(model.getOption1());
//            binding.answerThree.setText(model.getOption2());
//            binding.answerFour.setText(model.getOption3());

        }
        else {
//                   ..................TODO: ekhane read er jonnu fragment ta open korben...................
            binding.readQuestionListRecycler.setVisibility(View.VISIBLE);
            binding.examLayout.setVisibility(View.GONE);

            QuestionListAdapter questionListAdapter=new QuestionListAdapter(firebaseSubjectModelList,GiveExamOrReadQuestions.this);
            binding.readQuestionListRecycler.setAdapter(questionListAdapter);
            Log.i("tag", "question: "+questionListAdapter);

        }





//        if (intent.hasExtra("firebaseStorageID")){
//
//
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
//        }
//
    }

    private void showDataToAdapter(String chapterNo) {
        databaseReference.child(subjectName).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                firebaseSubjectModelList.clear();
//                Log.i("tag", "question: ");
                for (DataSnapshot dataSnapshot:snapshot.getChildren()){
                    FirebaseSubjectModel subjectModel=dataSnapshot.getValue(FirebaseSubjectModel.class);
                    if (subjectModel.getChapterNumber().equals(chapterNo)) {

                        firebaseSubjectModelList.add(subjectModel);
                    }
//                    Log.i("tag", "question: "+subjectModel.getQuestion());
//                    Log.i("tag", "Chapter Number: "+subjectModel.getChapterNumber());

                    binding.chapterNo.setText(chapterNo);
                    binding.chapterName.setText(subjectModel.getChapterName());
                }


//        ------------
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}