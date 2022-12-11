package com.abedkhan.knowledge;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.abedkhan.knowledge.Adapters.SubjectAdapter;
import com.abedkhan.knowledge.Fragments.CommerceDepartmentFragment;
import com.abedkhan.knowledge.Fragments.HuminitiesDepartmentFragment;
import com.abedkhan.knowledge.Fragments.ScienceDepartmentFragment;
import com.abedkhan.knowledge.Modelclass.DepartmentModelClass;
import com.abedkhan.knowledge.Modelclass.SubjectModelClass;
import com.abedkhan.knowledge.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
ActivityMainBinding binding;
List<DepartmentModelClass>departmentModelClassList;
List<SubjectModelClass>subjectModelClassList;
boolean isScienceClicked =false ,isCommerceClicked =false ,isArtsClicked =false;
int depclick;
//FragmentManager fragmentManager=getFragmentManager();
//FragmentTransaction fragmentTransaction= fragmentManager.beginTransaction();

    @SuppressLint("ResourceAsColor")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    binding.scienceCard.setOnClickListener(new Click());
            binding.commerceCard.setOnClickListener(new Click());
            binding.artsCard.setOnClickListener(new Click());


subjectModelClassList=new ArrayList<>();
setSubjectListData();

departmentModelClassList=new ArrayList<>();
departmentListData();




//if (isCommerceClicked==true){

//    binding.commerceCard.setOnClickListener(view -> {
//        binding.commerceCard.setBackgroundColor(R.color.sky);
//        binding.commerceCard.setEnabled(false);
//        CommerceDepartmentFragment commerceDepartmentFragment=new CommerceDepartmentFragment();
//        getSupportFragmentManager().beginTransaction().add(R.id.commerceDepShow,new CommerceDepartmentFragment()).commit();
//        binding.departmentLayout.setVisibility(View.GONE);
//        binding.commerceDepShow.setVisibility(View.VISIBLE);
////    AppCompatActivity appCompatActivity= (AppCompatActivity) view.getContext();
////    appCompatActivity.getSupportFragmentManager().beginTransaction().show()
//
//    });

//}else if (isScienceClicked==true) {

//    binding.scienceCard.setOnClickListener(view -> {
//        binding.scienceCard.setBackgroundColor(R.color.sky);
//        binding.scienceCard.setEnabled(false);
//        ScienceDepartmentFragment scienceDepartmentFragment = new ScienceDepartmentFragment();
//        getSupportFragmentManager().beginTransaction().add(R.id.scienceDepShow, new ScienceDepartmentFragment()).commit();
//
//        binding.departmentLayout.setVisibility(View.GONE);
//        binding.scienceDepShow.setVisibility(View.VISIBLE);
//
//    });

//}else if (isArtsClicked==true){


//    binding.artsCard.setOnClickListener(view -> {
//        binding.artsCard.setBackgroundColor(R.color.sky);
//        binding.artsCard.setEnabled(false);
//        HuminitiesDepartmentFragment huminitiesDepartmentFragment=new HuminitiesDepartmentFragment();
//        getSupportFragmentManager().beginTransaction().add(R.id.artsDepShow,new HuminitiesDepartmentFragment()).commit();
//        binding.departmentLayout.setVisibility(View.GONE);
//        binding.artsDepShow.setVisibility(View.VISIBLE);
//    });

//}

//switch (depclick){
//    case 1:
//        binding.scienceCard.setOnClickListener(view -> {
//            binding.scienceCard.setBackgroundColor(R.color.sky);
//            binding.scienceCard.setEnabled(false);
//            ScienceDepartmentFragment scienceDepartmentFragment=new ScienceDepartmentFragment();
//            getSupportFragmentManager().beginTransaction().add(R.id.scienceDepShow,new ScienceDepartmentFragment()).commit();
//            binding.departmentLayout.setVisibility(View.GONE);
//            binding.scienceDepShow.setVisibility(View.VISIBLE);
//        });
//        break;
//
//        case 2:
//            binding.commerceCard.setOnClickListener(view -> {
//                binding.commerceCard.setBackgroundColor(R.color.sky);
//                binding.commerceCard.setEnabled(false);
//                CommerceDepartmentFragment commerceDepartmentFragment = new CommerceDepartmentFragment();
//                getSupportFragmentManager().beginTransaction().add(R.id.commerceDepShow, new CommerceDepartmentFragment()).commit();
//                binding.departmentLayout.setVisibility(View.GONE);
//                binding.commerceDepShow.setVisibility(View.VISIBLE);
//            });
//            break;
//    case 3:
//        binding.artsCard.setOnClickListener(view -> {
//            binding.artsCard.setBackgroundColor(R.color.sky);
//            binding.artsCard.setEnabled(false);
//            HuminitiesDepartmentFragment huminitiesDepartmentFragment=new HuminitiesDepartmentFragment();
//            getSupportFragmentManager().beginTransaction().add(R.id.artsDepShow,new HuminitiesDepartmentFragment()).commit();
//            binding.departmentLayout.setVisibility(View.GONE);
//            binding.artsDepShow.setVisibility(View.VISIBLE);
//        });
//        break;
//    default:
//
//
//}














            SubjectAdapter subjectAdapter=new SubjectAdapter(subjectModelClassList,this);
        binding.dsubjectRecycler.setAdapter(subjectAdapter);

//       DepartmentAdapter departmentAdapter=new DepartmentAdapter(departmentModelClassList,this);
//        binding.departmentRecycler.setAdapter(departmentAdapter);
//




    }

    private void departmentListData() {

        departmentModelClassList.add(new DepartmentModelClass("Science",R.drawable.science));
        departmentModelClassList.add(new DepartmentModelClass("Commerce",R.drawable.commers1));
        departmentModelClassList.add(new DepartmentModelClass("Humanities",R.drawable.humanities));

    }

    private void setSubjectListData() {

        subjectModelClassList.add(new SubjectModelClass("বাংলা ১ম",R.drawable.banla));
        subjectModelClassList.add(new SubjectModelClass("বাংলা ২য়",R.drawable.banla));
        subjectModelClassList.add(new SubjectModelClass("English 1st",R.drawable.eng));
        subjectModelClassList.add(new SubjectModelClass("English 2nd",R.drawable.eng));
        subjectModelClassList.add(new SubjectModelClass("G. Math",R.drawable.math1));
        subjectModelClassList.add(new SubjectModelClass("I.C.T",R.drawable.ict2));
        subjectModelClassList.add(new SubjectModelClass("Career Education",R.drawable.career));
        subjectModelClassList.add(new SubjectModelClass("Arts and Crafts",R.drawable.artbook));
        subjectModelClassList.add(new SubjectModelClass("Agricultural Science",R.drawable.farming));
        subjectModelClassList.add(new SubjectModelClass("Home Economics",R.drawable.home_economics));
        subjectModelClassList.add(new SubjectModelClass("Physical Education, Health Science and Sports",R.drawable.physicaleducation));
        subjectModelClassList.add(new SubjectModelClass("Islam and moral education",R.drawable.islam));
        subjectModelClassList.add(new SubjectModelClass("Hindu and Moral Education",R.drawable.hindu));
        subjectModelClassList.add(new SubjectModelClass("Christian and Moral Education",R.drawable.cristhan));
        subjectModelClassList.add(new SubjectModelClass("Buddhist and Moral Education",R.drawable.buddhist));

    }

//    ---------This Method handles the actions after clicking the Departments---------
    public class Click implements View.OnClickListener{

        @SuppressLint("ResourceAsColor")
        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.scienceCard:
                    // TODO: What if background colour is already sky colour selected
//                    binding.scienceCard.setBackgroundColor(R.color.sky);
//                    --------------- Setting background after clicked ------------
                    binding.scienceCard.setBackgroundResource(R.drawable.department_clicked);
                    binding.commerceCard.setBackgroundColor(R.color.gray_50_backgroundd);
                    binding.artsCard.setBackgroundColor(R.color.gray_50_backgroundd);

//                    ------------------- setting clickable --------------
                    binding.scienceCard.setEnabled(false);
                    binding.commerceCard.setEnabled(true);
                    binding.artsCard.setEnabled(true);
                    ScienceDepartmentFragment scienceDepartmentFragment = new ScienceDepartmentFragment();
                    getSupportFragmentManager().beginTransaction().add(R.id.scienceDepShow, new ScienceDepartmentFragment()).commit();

                    binding.departmentLayout.setVisibility(View.GONE);
                    binding.commerceDepShow.setVisibility(View.GONE);
                    binding.artsDepShow.setVisibility(View.GONE);
                    binding.scienceDepShow.setVisibility(View.VISIBLE);

                    break;
                case R.id.commerceCard:
                    // TODO: What if background colour is already sky colour selected
//                    binding.commerceCard.setBackgroundColor(R.color.sky);
                    //                    --------------- Setting background after clicked ------------
                    binding.commerceCard.setBackgroundResource(R.drawable.department_clicked);
                    binding.scienceCard.setBackgroundColor(R.color.gray_50_backgroundd);
                    binding.artsCard.setBackgroundColor(R.color.gray_50_backgroundd);

                    binding.scienceCard.setEnabled(true);
                    binding.commerceCard.setEnabled(false);
                    binding.artsCard.setEnabled(true);
                    CommerceDepartmentFragment commerceDepartmentFragment=new CommerceDepartmentFragment();
                    getSupportFragmentManager().beginTransaction().add(R.id.commerceDepShow,new CommerceDepartmentFragment()).commit();

                    binding.departmentLayout.setVisibility(View.GONE);
                    binding.scienceDepShow.setVisibility(View.GONE);
                    binding.artsDepShow.setVisibility(View.GONE);
                    binding.commerceDepShow.setVisibility(View.VISIBLE);
                    break;
                case R.id.artsCard:
                    // TODO: What if background colour is already sky colour selected
//                    binding.artsCard.setBackgroundColor(R.color.sky);
                    //                    --------------- Setting background after clicked ------------
                    binding.artsCard.setBackgroundResource(R.drawable.department_clicked);
                    binding.commerceCard.setBackgroundColor(R.color.gray_50_backgroundd);
                    binding.scienceCard.setBackgroundColor(R.color.gray_50_backgroundd);

                    binding.scienceCard.setEnabled(true);
                    binding.commerceCard.setEnabled(true);
                    binding.artsCard.setEnabled(false);
                    HuminitiesDepartmentFragment huminitiesDepartmentFragment=new HuminitiesDepartmentFragment();
                    getSupportFragmentManager().beginTransaction().add(R.id.artsDepShow,new HuminitiesDepartmentFragment()).commit();

                    binding.departmentLayout.setVisibility(View.GONE);
                    binding.commerceDepShow.setVisibility(View.GONE);
                    binding.scienceDepShow.setVisibility(View.GONE);
                    binding.artsDepShow.setVisibility(View.VISIBLE);
                    break;
//                default:
//                    break;
            }
        }
    }

    @Override
    public void onBackPressed() {
//        super.onBackPressed();
        Intent intent = new Intent(MainActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}