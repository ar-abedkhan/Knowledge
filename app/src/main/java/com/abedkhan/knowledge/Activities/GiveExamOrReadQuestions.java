package com.abedkhan.knowledge.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.abedkhan.knowledge.Adapters.QuestionListAdapter;
import com.abedkhan.knowledge.Modelclass.FirebaseSubjectModel;
import com.abedkhan.knowledge.Modelclass.QuestionListModel;
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
    List<FirebaseSubjectModel> firebaseSubjectModelList;
    ViewPager viewPager;
    Intent intent;
    String storageId,chapterNo, chapterName, subjectName;
    boolean isExam;
    FirebaseAuth firebaseAuth;
    DatabaseReference databaseReference;

    CountDownTimer countDownTimer;
    int timelimit = 10;
    int count= 2000;
    TextView question, scoretv;
    int currentindex = 0, score = 0, totalquestion=0, questionno = 0;
    String userselectedans;
    Boolean isoptionselected=false;
    int rightans=0;
    int wrongans = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityGiveExamOrReadQuestionsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        firebaseAuth=FirebaseAuth.getInstance();
        databaseReference= FirebaseDatabase.getInstance().getReference();
        intent = getIntent();
        chapterNo =intent.getStringExtra("chapterNo");
        chapterName =intent.getStringExtra("chapterName");
        subjectName =intent.getStringExtra("subjectName");
        isExam = intent.getBooleanExtra("isExam", false);   //--- checking if it is for exam or only reading
        firebaseSubjectModelList=new ArrayList<>();
        showDataToAdapter();
        binding.chapterNo.setText(chapterNo);



    }

    private void showDataToAdapter() {
        databaseReference.child(subjectName+" chapter").child(subjectName + " "+ chapterNo).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                firebaseSubjectModelList.clear();

                for (DataSnapshot dataSnapshot:snapshot.getChildren()){
                    FirebaseSubjectModel subjectModel=dataSnapshot.getValue(FirebaseSubjectModel.class);
                    firebaseSubjectModelList.add(subjectModel);
//                    Log.i("tag", "Chapter Number: "+subjectModel.getChapterNumber());
                    binding.chapterNo.setText(chapterNo);
                    binding.chapterName.setText(subjectModel.getChapterName());
                }

                if (isExam){
                    binding.readQuestionListRecycler.setVisibility(View.GONE);
                    binding.examLayout.setVisibility(View.VISIBLE);
//
//                    Log.i("TAG", "--------------------EXAM---------------------------");
//                    FirebaseSubjectModel model = firebaseSubjectModelList.get(0);
////                  TODO: ekhane firebaseSubject model theke data pacche nah
//
//                    Log.i("TAG", "---------Exam--: "+model.getQuestion());
//                    Log.i("TAG", "---------Exam--: "+model.getOption1());
//                    binding.questionTv.setText(model.getQuestion());
//
//                    binding.answerOne.setText(model.getRightAnswer());
//                    binding.answertwo.setText(model.getOption1());
//                    binding.answerThree.setText(model.getOption2());
//                    binding.answerFour.setText(model.getOption3());


                    showQuestion();


                }
                else {
//                   ..................TODO: ekhane read er jonnu fragment ta open korben...................
                    Log.i("TAG", "------------------Read------------------ ");
                    binding.readQuestionListRecycler.setVisibility(View.VISIBLE);
                    binding.examLayout.setVisibility(View.GONE);

                    QuestionListAdapter questionListAdapter=new QuestionListAdapter(firebaseSubjectModelList,GiveExamOrReadQuestions.this);
                    binding.readQuestionListRecycler.setAdapter(questionListAdapter);

                }



            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    private void showQuestion() {


    setQuestuin(currentindex);

    binding.optionGroup.setOnCheckedChangeListener((radioGroup, i) -> {
    totalquestion= firebaseSubjectModelList.size();
    RadioButton selectedOption =findViewById(i);
    userselectedans =selectedOption.getText().toString();
    isoptionselected=true;
    Log.i("TAG", "option selected: " +userselectedans);


});


        binding.submitAns.setOnClickListener(view -> {
            checkRightAns();
            if (isoptionselected=false){

            }else {
                return;
            }

        });


    }

    private void setQuestuin(int currentindex) {


        if (currentindex==firebaseSubjectModelList.size()){
            finishQuiz();
            return;

        }
//            timer();


//        activityQuizItBinding.scoretv.setText("SCORE:"+score);
        binding.questionNo.setText("Question : "+questionno+"/"+totalquestion);
//        activityQuizItBinding.rightAns.setText("Right Ans :"+ rightans+"/"+totalquestion);
//        activityQuizItBinding.wrongAns.setText("Wrong Ans :"+wrongans+"/"+totalQuestion);


        binding.questionTv.setText(firebaseSubjectModelList.get(currentindex).getQuestion());
        binding.answerOne.setText(firebaseSubjectModelList.get(currentindex).getOption1());
        binding.answertwo.setText(firebaseSubjectModelList.get(currentindex).getOption2());
        binding.answerThree.setText(firebaseSubjectModelList.get(currentindex).getOption3());
        binding.answerFour.setText(firebaseSubjectModelList.get(currentindex).getRightAnswer());

        binding.answerOne.setChecked(false);
        binding.answertwo.setChecked(false);
        binding.answerThree.setChecked(false);
        binding.answerFour.setChecked(false);

    }

//    private void timer() {
//        countDownTimer = new CountDownTimer(50000,1000) {
//            @Override
//            public void onTick(long l) {
//                binding.playQuizTimer.setText("00:"+timelimit);
//                timelimit--;
//            }
//
//            @Override
//            public void onFinish() {
//                    currentindex++;
//                setQuestuin(currentindex);
//                finishtimer();
//
//            }
//
//            private void finishtimer() {
//
//                countDownTimer.cancel();
//                binding.questionTv.setClickable(false);
//                binding.answerOne.setClickable(false);
//                binding.answertwo.setClickable(false);
//                binding.answerThree.setClickable(false);
//                binding.answerFour.setClickable(false);
//
//                setQuestuin(currentindex);
////                Intent splashintent=new Intent(quiz_it.this,dashboard.class);
////                startActivity(splashintent);
//            }
//        }.start();
//    }


    private void finishQuiz() {

//        Intent intent =new Intent(this,dashboard.class);
//        intent.putExtra("rightans",rightans);
//        intent.putExtra("wrongans",wrongans);
//        intent.putExtra("score",score);
//        intent.putExtra("totalquestion",totalquestion);
//        startActivity(intent);



    }

    private void checkRightAns() {

        if (firebaseSubjectModelList.get(currentindex).getRightAnswer().equals(userselectedans)){
            score = score+5;
            rightans++;
            questionno++;
            currentindex++;
            setQuestuin(currentindex);
            Toast.makeText(this, "Right ans.CONGRATULATION!You won 5 point", Toast.LENGTH_SHORT).show();

        }else {
            score =score-5;
            currentindex++;
            questionno++;
            wrongans++;
            setQuestuin(currentindex);
            Log.i("TAG", "wrong ans: ");
            Toast.makeText(this, "Wrong ans.You lose 5 point.", Toast.LENGTH_SHORT).show();

        }
    }
}