package com.abedkhan.knowledge.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.abedkhan.knowledge.Adapters.ChapterAdapter;
import com.abedkhan.knowledge.Modelclass.ChapterModelClass;
import com.abedkhan.knowledge.databinding.FragmentReadBinding;

import java.util.ArrayList;
import java.util.List;


public class ReadFragment extends Fragment {

    public ReadFragment() {
    }
    FragmentReadBinding binding;
List<ChapterModelClass>chapterModelClassList;
int chapterno;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
binding=FragmentReadBinding.inflate(getLayoutInflater(),container,false);

chapterModelClassList=new ArrayList<>();

chapterno=chapterModelClassList.size()+1;

chapterModelClassList.add(new ChapterModelClass("Chapter","Chapter name 1","Me",chapterno));
chapterModelClassList.add(new ChapterModelClass("Chapter","Chapter name 2","Zeeshan",chapterno));
chapterModelClassList.add(new ChapterModelClass("Chapter","Chapter name 3","Abed",chapterno));
chapterModelClassList.add(new ChapterModelClass("Chapter","Chapter name 4","Abeir",chapterno));
chapterModelClassList.add(new ChapterModelClass("Chapter","Chapter name 5","Yasin",chapterno));
chapterModelClassList.add(new ChapterModelClass("Chapter","Chapter name 6","Ashik",chapterno));
chapterModelClassList.add(new ChapterModelClass("Chapter","Chapter name 7","mehedi",chapterno));
chapterModelClassList.add(new ChapterModelClass("Chapter","Chapter name 1","Me",chapterno));
chapterModelClassList.add(new ChapterModelClass("Chapter","Chapter name 2","Zeeshan",chapterno));
chapterModelClassList.add(new ChapterModelClass("Chapter","Chapter name 3","Abed",chapterno));
chapterModelClassList.add(new ChapterModelClass("Chapter","Chapter name 4","Abeir",chapterno));
chapterModelClassList.add(new ChapterModelClass("Chapter","Chapter name 5","Yasin",chapterno));
chapterModelClassList.add(new ChapterModelClass("Chapter","Chapter name 6","Ashik",chapterno));
chapterModelClassList.add(new ChapterModelClass("Chapter","Chapter name 7","mehedi",chapterno));
chapterModelClassList.add(new ChapterModelClass("Chapter","Chapter name 1","Me",chapterno));
chapterModelClassList.add(new ChapterModelClass("Chapter","Chapter name 2","Zeeshan",chapterno));
chapterModelClassList.add(new ChapterModelClass("Chapter","Chapter name 3","Abed",chapterno));
chapterModelClassList.add(new ChapterModelClass("Chapter","Chapter name 4","Abeir",chapterno));
chapterModelClassList.add(new ChapterModelClass("Chapter","Chapter name 5","Yasin",chapterno));
chapterModelClassList.add(new ChapterModelClass("Chapter","Chapter name 6","Ashik",chapterno));
chapterModelClassList.add(new ChapterModelClass("Chapter","Chapter name 7","mehedi",chapterno));


        ChapterAdapter chapterAdapter=new ChapterAdapter(chapterModelClassList,requireContext());
        binding.readRecycler.setAdapter(chapterAdapter);












return binding.getRoot();
    }
}