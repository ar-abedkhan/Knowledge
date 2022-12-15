package com.abedkhan.knowledge.Fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.abedkhan.knowledge.Adapters.ChapterAdapter;
import com.abedkhan.knowledge.Modelclass.ChapterModelClass;
import com.abedkhan.knowledge.databinding.FragmentReadBinding;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;


public class ReadFragment extends Fragment {

    public ReadFragment() {
    }
    FragmentReadBinding binding;
    List<ChapterModelClass> chapterModelClassList;
    FirebaseAuth firebaseAuth;
    DatabaseReference databaseReference;

    int chapterno;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding=FragmentReadBinding.inflate(getLayoutInflater(),container,false);

        firebaseAuth = FirebaseAuth.getInstance();
        databaseReference = FirebaseDatabase.getInstance().getReference();

        chapterModelClassList=new ArrayList<>();

        chapterno=chapterModelClassList.size()+1;

        chapterModelClassList.add(new ChapterModelClass("Chapter","Chapter name 1","Me",chapterno));
        chapterModelClassList.add(new ChapterModelClass("Chapter","Chapter name 2  testing multiline chapter recycler...this is also testing line design","Zeeshan",chapterno));
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


        ChapterAdapter chapterAdapter=new ChapterAdapter(chapterModelClassList,requireContext(), false);
        binding.readRecycler.setAdapter(chapterAdapter);


//        binding.re.setOnClickListener(view -> {
//
// /*           TODO: take the subject from the firebase and save it to the room database
//            databaseReference.child(subjectName).child(currentID).addValueEventListener(new ValueEventListener() {
//                @Override
//                public void onDataChange(@NonNull DataSnapshot snapshot) {
//
//                }
//
//                @Override
//                public void onCancelled(@NonNull DatabaseError error) {
//
//                }
//            });
//
//            */
//
//
//        });










return binding.getRoot();
    }
}