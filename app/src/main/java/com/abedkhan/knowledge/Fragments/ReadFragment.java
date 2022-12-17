package com.abedkhan.knowledge.Fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.abedkhan.knowledge.Adapters.ChapterAdapter;
import com.abedkhan.knowledge.Database.SubjectDatabase;
import com.abedkhan.knowledge.Database.SubjectModel;
import com.abedkhan.knowledge.Modelclass.ChapterModelClass;
import com.abedkhan.knowledge.Modelclass.FirebaseSubjectModel;
import com.abedkhan.knowledge.RecyclerDataListener;
import com.abedkhan.knowledge.databinding.FragmentReadBinding;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;


public class ReadFragment extends Fragment implements RecyclerDataListener {

    public ReadFragment() {
    }
    FragmentReadBinding binding;
    List<ChapterModelClass> chapterModelClassList;
    List<FirebaseSubjectModel> firebaseSubjectModelList;

    FirebaseAuth firebaseAuth;
    DatabaseReference databaseReference;

    int chapterno;
    String currentID, subjectName;

    Intent intent;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding=FragmentReadBinding.inflate(getLayoutInflater(),container,false);

        firebaseAuth = FirebaseAuth.getInstance();
        databaseReference = FirebaseDatabase.getInstance().getReference();

        chapterModelClassList=new ArrayList<>();
        firebaseSubjectModelList = new ArrayList<>(); //-------- Getting data from firebase ---------

//        _____________________ Getting subject Name from previous Activity _______________________
        intent = getActivity().getIntent();
        subjectName = intent.getStringExtra("subjectName");

//        showDataToAdapter(subjectName);

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

//
//        binding.readOfflineBtn.setOnClickListener(view -> {
//
//        });










        return binding.getRoot();
    }

    private void showDataToAdapter(String subjectName) {

        databaseReference.child(subjectName).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                firebaseSubjectModelList.clear();
                for (DataSnapshot dataSnapshot:snapshot.getChildren()){
                    FirebaseSubjectModel modelList = dataSnapshot.getValue(FirebaseSubjectModel.class);
                    firebaseSubjectModelList.add(modelList);
                }

                myAdapterRunner(firebaseSubjectModelList);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    private void myAdapterRunner(List<FirebaseSubjectModel> firebaseSubjectModelList) {
        //--------------This method run the Adapter and show data to the user ----------------

//        ChapterAdapter chapterAdapter=new ChapterAdapter(firebaseSubjectModelList,requireContext(), false);
//        binding.readRecycler.setAdapter(chapterAdapter);
    }

    @Override
    public void downloadSubjectData() {
        //            TODO: take the subject from the firebase and save it to the room database
        databaseReference.child(subjectName).child(currentID).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                firebaseSubjectModelList.clear();

                for (DataSnapshot dataSnapshot: snapshot.getChildren()){
                    FirebaseSubjectModel subjectModel = dataSnapshot.getValue(FirebaseSubjectModel.class);
                    firebaseSubjectModelList.add(subjectModel);
                }
                //----------------- saveDataToRoom ---------
                saveDataToRoom(firebaseSubjectModelList);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });



    }

    private void saveDataToRoom(List<FirebaseSubjectModel> modelList) {
//        ------- TODO: save data to the Room Database ---------
        FirebaseSubjectModel subjectModel = modelList.get(0);

        SubjectModel model = new SubjectModel(); //----------Room database subject model

//        firebaseStorageID, subjectName, chapterNumber, chapterName, writerName, question, rightAnswer, option1, option2, option3
        model.setFirebaseStorageID(subjectModel.getFirebaseStorageID());
        model.setSubjectName(subjectModel.getSubjectName());
        model.setChapterNumber(subjectModel.getChapterNumber());
        model.setChapterName(subjectModel.getChapterName());
        model.setWriterName(subjectModel.getWriterName());
        model.setQuestion(subjectModel.getQuestion());
        model.setRightAnswer(subjectModel.getRightAnswer());
        model.setOption1(subjectModel.getOption1());
        model.setOption2(subjectModel.getOption2());
        model.setOption3(subjectModel.getOption3());

        SubjectDatabase.getInstance(getContext()).getSubjectDao().insert(model);

    }
}