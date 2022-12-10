package com.abedkhan.knowledge;

import androidx.appcompat.app.AppCompatActivity;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;

import com.abedkhan.knowledge.Adapters.SubjectAdapter;
import com.abedkhan.knowledge.Fragments.CommerceDepartmentFragment;
import com.abedkhan.knowledge.Modelclass.DepartmentModelClass;
import com.abedkhan.knowledge.Modelclass.SubjectModelClass;
import com.abedkhan.knowledge.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
ActivityMainBinding binding;
List<DepartmentModelClass>departmentModelClassList;
List<SubjectModelClass>subjectModelClassList;

//FragmentManager fragmentManager=getFragmentManager();
//FragmentTransaction fragmentTransaction= fragmentManager.beginTransaction();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


subjectModelClassList=new ArrayList<>();
setSubjectListData();

departmentModelClassList=new ArrayList<>();
departmentListData();




//
//binding.commerceCard.setOnClickListener(view -> {
//    CommerceDepartmentFragment commerceDepartmentFragment=new CommerceDepartmentFragment();
//    getSupportFragmentManager().beginTransaction().add(R.id.framlayout,new CommerceDepartmentFragment()).commit();
////    AppCompatActivity appCompatActivity= (AppCompatActivity) view.getContext();
////    appCompatActivity.getSupportFragmentManager().beginTransaction().show()
//});
//















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
}