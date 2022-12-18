package com.abedkhan.knowledge.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.abedkhan.knowledge.Adapters.ChapterAdapter;
import com.abedkhan.knowledge.Modelclass.ChapterModelClass;
import com.abedkhan.knowledge.R;
import com.abedkhan.knowledge.RecyclerDataListener;
import com.abedkhan.knowledge.databinding.FragmentExamBinding;

import java.util.ArrayList;
import java.util.List;

public class ExamFragment extends Fragment implements RecyclerDataListener {

    public ExamFragment() {
    }

    FragmentExamBinding binding;
    List<ChapterModelClass> chapterModelClassList;
    int chapterNo;




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding=FragmentExamBinding.inflate(getLayoutInflater(),container,false);


        chapterModelClassList=new ArrayList<>();

        chapterNo=chapterModelClassList.size()+1;

        chapterModelClassList.add(new ChapterModelClass("Chapter","Chapter name 1","Me",chapterNo));
        chapterModelClassList.add(new ChapterModelClass("Chapter","Chapter name 2","Zeeshan",chapterNo));
        chapterModelClassList.add(new ChapterModelClass("Chapter","Chapter name 3","Abed",chapterNo));
        chapterModelClassList.add(new ChapterModelClass("Chapter","Chapter name 4","Abeir",chapterNo));
        chapterModelClassList.add(new ChapterModelClass("Chapter","Chapter name 5","Yasin",chapterNo));
        chapterModelClassList.add(new ChapterModelClass("Chapter","Chapter name 6","Ashik",chapterNo));
        chapterModelClassList.add(new ChapterModelClass("Chapter","Chapter name 7","mehedi",chapterNo));
        chapterModelClassList.add(new ChapterModelClass("Chapter","Chapter name 1","Me",chapterNo));
        chapterModelClassList.add(new ChapterModelClass("Chapter","Chapter name 2","Zeeshan",chapterNo));
        chapterModelClassList.add(new ChapterModelClass("Chapter","Chapter name 3","Abed",chapterNo));
        chapterModelClassList.add(new ChapterModelClass("Chapter","Chapter name 4","Abeir",chapterNo));
        chapterModelClassList.add(new ChapterModelClass("Chapter","Chapter name 5","Yasin",chapterNo));
        chapterModelClassList.add(new ChapterModelClass("Chapter","Chapter name 6","Ashik",chapterNo));
        chapterModelClassList.add(new ChapterModelClass("Chapter","Chapter name 7","mehedi",chapterNo));
        chapterModelClassList.add(new ChapterModelClass("Chapter","Chapter name 1","Me",chapterNo));
        chapterModelClassList.add(new ChapterModelClass("Chapter","Chapter name 2","Zeeshan",chapterNo));
        chapterModelClassList.add(new ChapterModelClass("Chapter","Chapter name 3","Abed",chapterNo));
        chapterModelClassList.add(new ChapterModelClass("Chapter","Chapter name 4","Abeir",chapterNo));
        chapterModelClassList.add(new ChapterModelClass("Chapter","Chapter name 5","Yasin",chapterNo));
        chapterModelClassList.add(new ChapterModelClass("Chapter","Chapter name 6","Ashik",chapterNo));
        chapterModelClassList.add(new ChapterModelClass("Chapter","Chapter name 7","mehedi",chapterNo));


        ChapterAdapter chapterAdapter=new ChapterAdapter(chapterModelClassList,requireContext(), true, this);
        binding.examRecycler.setAdapter(chapterAdapter);

        return binding.getRoot();
    }

    @Override
    public void downloadSubjectData(String currentFirebaseID) {

    }
}