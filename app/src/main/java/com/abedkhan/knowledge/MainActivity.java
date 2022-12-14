package com.abedkhan.knowledge;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.abedkhan.knowledge.Activities.AdminLoginActivity;
import com.abedkhan.knowledge.Adapters.SubjectAdapter;
import com.abedkhan.knowledge.Modelclass.SubjectModelClass;
import com.abedkhan.knowledge.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
ActivityMainBinding binding;
List<SubjectModelClass>subjectModelClassList;
boolean isDepartmentClicked= false;

    @SuppressLint("ResourceAsColor")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    binding.scienceCard.setOnClickListener(new Click());
            binding.commerceCard.setOnClickListener(new Click());
            binding.artsCard.setOnClickListener(new Click());

            sendSubjectToReadAndExamPage();


subjectModelClassList=new ArrayList<>();
setSubjectListData();


            SubjectAdapter subjectAdapter=new SubjectAdapter(subjectModelClassList,this);
        binding.dsubjectRecycler.setAdapter(subjectAdapter);

    }

    private void sendSubjectToReadAndExamPage() {
        binding.physicsCard.setOnClickListener(view -> {
            startActivity(new Intent(MainActivity.this, ReadAndExam.class));
            finish();
        });
        binding.chemistryCard.setOnClickListener(view -> {
            startActivity(new Intent(MainActivity.this, ReadAndExam.class));
            finish();
        });
        binding.biologyCard.setOnClickListener(view -> {
            startActivity(new Intent(MainActivity.this, ReadAndExam.class));
            finish();
        });
        binding.higherMathCard.setOnClickListener(view -> {
            startActivity(new Intent(MainActivity.this, ReadAndExam.class));
            finish();
        });
        binding.glovalStudiesCard.setOnClickListener(view -> {
            startActivity(new Intent(MainActivity.this, ReadAndExam.class));
            finish();
        });

 //.......................................................................

        binding.financeCard.setOnClickListener(view -> {
            startActivity(new Intent(MainActivity.this, ReadAndExam.class));
            finish();
        });
        binding.hisabbigganCard.setOnClickListener(view -> {
            startActivity(new Intent(MainActivity.this, ReadAndExam.class));
            finish();
        });
        binding.bigganCard.setOnClickListener(view -> {
            startActivity(new Intent(MainActivity.this, ReadAndExam.class));
            finish();
        });
        binding.bebsaiUddagCard.setOnClickListener(view -> {
            startActivity(new Intent(MainActivity.this, ReadAndExam.class));
            finish();
        });

  //................................................

        binding.pouronitiCard.setOnClickListener(view -> {
            startActivity(new Intent(MainActivity.this, ReadAndExam.class));
            finish();
        });
        binding.itihashCard.setOnClickListener(view -> {
            startActivity(new Intent(MainActivity.this, ReadAndExam.class));
            finish();
        });
        binding.bugolCard.setOnClickListener(view -> {
            startActivity(new Intent(MainActivity.this, ReadAndExam.class));
            finish();
        });



    }


    private void setSubjectListData() {

        subjectModelClassList.add(new SubjectModelClass("বাংলা ১ম",R.drawable.banlamin));
        subjectModelClassList.add(new SubjectModelClass("বাংলা ২য়",R.drawable.banlamin));
        subjectModelClassList.add(new SubjectModelClass("English 1st",R.drawable.engmin));
        subjectModelClassList.add(new SubjectModelClass("English 2nd",R.drawable.engmin));
        subjectModelClassList.add(new SubjectModelClass("G. Math",R.drawable.math1min));
        subjectModelClassList.add(new SubjectModelClass("I.C.T",R.drawable.ict));
        subjectModelClassList.add(new SubjectModelClass("Career Education",R.drawable.careermin));
        subjectModelClassList.add(new SubjectModelClass("Arts and Crafts",R.drawable.artbookmin));
        subjectModelClassList.add(new SubjectModelClass("Agricultural Science",R.drawable.farmingmin));
        subjectModelClassList.add(new SubjectModelClass("Home Economics",R.drawable.home_economicsmin));
        subjectModelClassList.add(new SubjectModelClass("Physical Education, Health Science and Sports",R.drawable.physicaleducationmin));
        subjectModelClassList.add(new SubjectModelClass("Islam and moral education",R.drawable.islammin));
        subjectModelClassList.add(new SubjectModelClass("Hindu and Moral Education",R.drawable.hindumin));
        subjectModelClassList.add(new SubjectModelClass("Christian and Moral Education",R.drawable.cristhanmin));
        subjectModelClassList.add(new SubjectModelClass("Buddhist and Moral Education",R.drawable.buddhistmin));


        //    --------------- Going to the Admin Login Activity --------------
        binding.myProfile.setOnClickListener(view -> {
            startActivity(new Intent(MainActivity.this, AdminLoginActivity.class));
            finish();
        });

    }


//    ---------This Method handles the actions after clicking the Departments---------
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
}