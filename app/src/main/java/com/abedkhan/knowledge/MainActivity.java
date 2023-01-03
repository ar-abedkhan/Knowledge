package com.abedkhan.knowledge;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.abedkhan.knowledge.Activities.AdminLoginActivity;
import com.abedkhan.knowledge.Adapters.SubjectAdapter;
import com.abedkhan.knowledge.Modelclass.FirebaseSubjectModel;
import com.abedkhan.knowledge.Modelclass.SubjectModelClass;
import com.abedkhan.knowledge.databinding.ActivityMainBinding;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
ActivityMainBinding binding;
List<SubjectModelClass>subjectModelClassList;
boolean isDepartmentClicked= false;
DatabaseReference databaseReference;
FirebaseAuth firebaseAuth;
    String currentID, subjectName;
    Intent intent;

    @SuppressLint("ResourceAsColor")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.scienceCard.setOnClickListener(new Click());
        binding.commerceCard.setOnClickListener(new Click());
        binding.artsCard.setOnClickListener(new Click());

        firebaseAuth=FirebaseAuth.getInstance();
        databaseReference= FirebaseDatabase.getInstance().getReference();
        sendSubjectToReadAndExamPage();

         intent = getIntent();
        subjectName = intent.getStringExtra("subjectName");
        subjectModelClassList=new ArrayList<>();
        setSubjectListData();


//databaseReference.child(subjectName).addValueEventListener(new ValueEventListener() {
//    @Override
//    public void onDataChange(@NonNull DataSnapshot snapshot) {
//        subjectModelClassList.clear();
//        for (DataSnapshot dataSnapshot:snapshot.getChildren()){
//            SubjectModelClass modelList = dataSnapshot.getValue(SubjectModelClass.class);
//            subjectModelClassList.add(modelList);
//        }
        SubjectAdapter subjectAdapter=new SubjectAdapter(subjectModelClassList,MainActivity.this);
        binding.dsubjectRecycler.setAdapter(subjectAdapter);

//    }
//
//    @Override
//    public void onCancelled(@NonNull DatabaseError error) {
//
//    }
//});


    }

    private void sendSubjectToReadAndExamPage() {

        binding.physicsCard.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, ReadAndExam.class);
//            ------------------ TODO: Intent er subject name firebase database er subject name same hobe..
            intent.putExtra("subjectName", "পদার্থবিজ্ঞান");
            startActivity(intent);
            finish();
        });
        binding.chemistryCard.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, ReadAndExam.class);
            intent.putExtra("subjectName", "রসায়ন");
            startActivity(intent);
            finish();
        });
        binding.biologyCard.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, ReadAndExam.class);
            intent.putExtra("subjectName", "জীববিজ্ঞান");
            startActivity(intent);
            finish();
        });
        binding.higherMathCard.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, ReadAndExam.class);
            intent.putExtra("subjectName", "উচ্চতর গণিত");
            startActivity(intent);
            finish();
        });
        binding.glovalStudiesCard.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, ReadAndExam.class);
            intent.putExtra("subjectName", "বাংলাদেশ ও বিশ্ব পরিচয়");
            startActivity(intent);
            finish();
        });

 //....................................................................... subject name for Business study

        binding.financeCard.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, ReadAndExam.class);
            intent.putExtra("subjectName", "ফিনান্স ও ব্যাঙ্কিং");
            startActivity(intent);
            finish();
        });
        binding.hisabbigganCard.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, ReadAndExam.class);
            intent.putExtra("subjectName", "হিসাববিজ্ঞান");
            startActivity(intent);
            finish();
        });
        binding.bigganCard.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, ReadAndExam.class);
            intent.putExtra("subjectName", "সাধারন বিজ্ঞান");
            startActivity(intent);
            finish();
        });
        binding.bebsaiUddagCard.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, ReadAndExam.class);
            intent.putExtra("subjectName", "ব্যবসায় উদ্যোগ");
            startActivity(intent);
            finish();
        });

  //................................................subject name for Humanities

        binding.pouronitiCard.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, ReadAndExam.class);
            intent.putExtra("subjectName", "পৌরনীতি ও নাগরিকতা");
            startActivity(intent);
            finish();
        });
        binding.itihashCard.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, ReadAndExam.class);
            intent.putExtra("subjectName", "বাংলাদেশের ইতিহাস ও বিশ্বসভ্যতা");
            startActivity(intent);
            finish();
        });
        binding.bugolCard.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, ReadAndExam.class);
            intent.putExtra("subjectName", "ভূগোল ও পরিবেশ");
            startActivity(intent);
            finish();
        });


  //...........................General subject clicked to read and exam fragment....................

    }


    //...........................General subject List..........................

    private void setSubjectListData() {

        subjectModelClassList.add(new SubjectModelClass("বাংলা সাহিত্য",R.drawable.banlamin));
        subjectModelClassList.add(new SubjectModelClass("বাংলা ভাষার ব্যাকরণ",R.drawable.banlamin));
        subjectModelClassList.add(new SubjectModelClass("English for Today",R.drawable.engmin));
        subjectModelClassList.add(new SubjectModelClass("English Grammar and Composition",R.drawable.engmin));
        subjectModelClassList.add(new SubjectModelClass("গণিত",R.drawable.math1min));
        subjectModelClassList.add(new SubjectModelClass("তথ্য ও যোগাযোগ প্রযুক্তি",R.drawable.ict));
        subjectModelClassList.add(new SubjectModelClass("ক্যারিয়ার এডুকেশন",R.drawable.careermin));
        subjectModelClassList.add(new SubjectModelClass("চারু ও কারুকলা",R.drawable.artbookmin));
        subjectModelClassList.add(new SubjectModelClass("কৃষিশিক্ষা",R.drawable.farmingmin));
        subjectModelClassList.add(new SubjectModelClass("গার্হস্থ্য বিজ্ঞান ",R.drawable.home_economicsmin));
        subjectModelClassList.add(new SubjectModelClass("শারীরিক শিক্ষা",R.drawable.physicaleducationmin));
        subjectModelClassList.add(new SubjectModelClass("ইসলাম ও নৈতিক শিক্ষা",R.drawable.islammin));
        subjectModelClassList.add(new SubjectModelClass("হিন্দু ধর্ম ও নৈতিক শিক্ষা",R.drawable.hindumin));
        subjectModelClassList.add(new SubjectModelClass("খ্রিষ্টধর্ম ও নৈতিক শিক্ষা",R.drawable.cristhanmin));
        subjectModelClassList.add(new SubjectModelClass("বৌদ্ধধর্ম ও নৈতিক শিক্ষা",R.drawable.buddhistmin));


        //    --------------- Going to the Admin Login Activity --------------
        binding.myProfile.setOnClickListener(view -> {
            startActivity(new Intent(MainActivity.this, AdminLoginActivity.class));
            finish();
        });

    }


//    ---------This Method handles the actions after clicking the Departments-----Start------------------

    public class Click implements View.OnClickListener{

        @SuppressLint("ResourceAsColor")
        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.scienceCard:
                    isDepartmentClicked = true;
//                    --------------- Setting background after clicked ------------
                    binding.scienceCard.setBackgroundResource(R.drawable.department_clicked);
                    binding.commerceCard.setBackgroundColor(R.drawable.department_clicked_null_back);
                    binding.artsCard.setBackgroundColor(R.drawable.department_clicked_null_back);


//                    ------------------- setting clickable --------------
                    binding.scienceCard.setEnabled(false);
                    binding.commerceCard.setEnabled(true);
                    binding.artsCard.setEnabled(true);
//                    ScienceDepartmentFragment scienceDepartmentFragment = new ScienceDepartmentFragment();
//                    getSupportFragmentManager().beginTransaction().add(R.id.scienceDepShow, new ScienceDepartmentFragment()).commit();

                    binding.departmentLayout.setVisibility(View.GONE);
                    binding.commerceDepShow.setVisibility(View.GONE);
                    binding.artsDepShow.setVisibility(View.GONE);
                    binding.scienceDepShow.setVisibility(View.VISIBLE);

                    break;
                case R.id.commerceCard:
                    isDepartmentClicked = true;
                    //                    --------------- Setting background after clicked ------------
                    binding.commerceCard.setBackgroundResource(R.drawable.department_clicked);
                    binding.scienceCard.setBackgroundColor(R.drawable.department_clicked_null_back);
                    binding.artsCard.setBackgroundColor(R.drawable.department_clicked_null_back);

                    binding.scienceCard.setEnabled(true);
                    binding.commerceCard.setEnabled(false);
                    binding.artsCard.setEnabled(true);
//                    CommerceDepartmentFragment commerceDepartmentFragment=new CommerceDepartmentFragment();
//                    getSupportFragmentManager().beginTransaction().add(R.id.commerceDepShow,new CommerceDepartmentFragment()).commit();

                    binding.departmentLayout.setVisibility(View.GONE);
                    binding.scienceDepShow.setVisibility(View.GONE);
                    binding.artsDepShow.setVisibility(View.GONE);
                    binding.commerceDepShow.setVisibility(View.VISIBLE);
                    break;
                case R.id.artsCard:
                    isDepartmentClicked = true;
                    //                    --------------- Setting background after clicked ------------
                    binding.artsCard.setBackgroundResource(R.drawable.department_clicked);
                    binding.commerceCard.setBackgroundColor(R.drawable.department_clicked_null_back);
                    binding.scienceCard.setBackgroundColor(R.drawable.department_clicked_null_back);

                    binding.scienceCard.setEnabled(true);
                    binding.commerceCard.setEnabled(true);
                    binding.artsCard.setEnabled(false);
//                    HuminitiesDepartmentFragment huminitiesDepartmentFragment=new HuminitiesDepartmentFragment();
//                    getSupportFragmentManager().beginTransaction().add(R.id.artsDepShow,new HuminitiesDepartmentFragment()).commit();

                    binding.departmentLayout.setVisibility(View.GONE);
                    binding.commerceDepShow.setVisibility(View.GONE);
                    binding.scienceDepShow.setVisibility(View.GONE);
                    binding.artsDepShow.setVisibility(View.VISIBLE);
                    break;

            }
        }
    }
//    ---------This Method handles the actions after clicking the Departments-----End----------------------



 //................................Working on back button and back dialog..............Start..........................................
    @Override
    public void onBackPressed() {
        if (isDepartmentClicked) {
            isDepartmentClicked = false;
            Intent intent = new Intent(MainActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        }
        else {
            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

            builder.setTitle("Exit!");
            builder.setIcon(R.drawable.warning_icon);
            builder.setMessage("Do you want to exit from the application?");

            builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    MainActivity.super.onBackPressed();
                }
            });

            builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {

                }
            });
            AlertDialog dialog = builder.create();
            dialog.show();

        }

    }

    //................................Working on back button and back dialog..............End..........................................

}