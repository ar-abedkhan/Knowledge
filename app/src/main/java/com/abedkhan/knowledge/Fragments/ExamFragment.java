package com.abedkhan.knowledge.Fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.abedkhan.knowledge.Adapters.ChapterAdapter;
import com.abedkhan.knowledge.Database.SubjectDatabase;
import com.abedkhan.knowledge.Database.SubjectModel;
import com.abedkhan.knowledge.Modelclass.FirebaseSubjectModel;
import com.abedkhan.knowledge.RecyclerDataListener;
import com.abedkhan.knowledge.databinding.FragmentExamBinding;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class ExamFragment extends Fragment implements RecyclerDataListener {
    public ExamFragment() {
    }

    FragmentExamBinding binding;
    List<FirebaseSubjectModel>firebaseSubjectModelList;
    int chapterNo;
    FirebaseAuth firebaseAuth;
    DatabaseReference databaseReference;
    Intent intent;
    String currentID, subjectName;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding=FragmentExamBinding.inflate(getLayoutInflater(),container,false);

        firebaseAuth=FirebaseAuth.getInstance();
        databaseReference= FirebaseDatabase.getInstance().getReference();

        intent=getActivity().getIntent();
        subjectName=intent.getStringExtra("subjectName");
        showDataToAdapter(subjectName);

        firebaseSubjectModelList=new ArrayList<>();
        chapterNo=firebaseSubjectModelList.size()+1;

        binding.subjectName.setText(subjectName);



        return binding.getRoot();
    }

    private void showDataToAdapter(String subjectName) {

        databaseReference.child(subjectName).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                Log.i("tag", "exam data: ");
                firebaseSubjectModelList.clear();
                for (DataSnapshot dataSnapshot:snapshot.getChildren()){
                    FirebaseSubjectModel firebaseSubjectModel=dataSnapshot.getValue(FirebaseSubjectModel.class);
                    firebaseSubjectModelList.add(firebaseSubjectModel);
                    Log.i("tag", "exam data: "+firebaseSubjectModel.getSubjectName());
                }
                ChapterAdapter chapterAdapter=new ChapterAdapter(firebaseSubjectModelList,requireContext(), true, ExamFragment.this);
                binding.examRecycler.setAdapter(chapterAdapter);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }

    @Override
    public void downloadSubjectData(String currentFirebaseID) {

        databaseReference.child(subjectName).child(currentFirebaseID).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                firebaseSubjectModelList.clear();
                for (DataSnapshot dataSnapshot:snapshot.getChildren()){
                    FirebaseSubjectModel firebaseSubjectModel=snapshot.getValue(FirebaseSubjectModel.class);
                    firebaseSubjectModelList.add(firebaseSubjectModel);
                }
                saveDataToRoom(firebaseSubjectModelList);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    private void saveDataToRoom(List<FirebaseSubjectModel> firebaseSubjectModelList) {

        FirebaseSubjectModel subjectModel=firebaseSubjectModelList.get(0);

        SubjectModel model=new SubjectModel();

        model.setFirebaseStorageID(subjectModel.getID());
        model.setSubjectName(subjectModel.getSubjectName());
        model.setChapterNumber(subjectModel.getChapterNumber());
        model.setChapterName(subjectModel.getChapterName());
        model.setWriterName(subjectModel.getWriterName());
        model.setQuestion(subjectModel.getQuestion());
        model.setRightAnswer(subjectModel.getRightAnswer());
        model.setOption1(subjectModel.getOption1());
        model.setOption2(subjectModel.getOption2());
        model.setOption3(subjectModel.getOption3());
        model.setAnswerDescription(subjectModel.getAnswerDescription());

        SubjectDatabase.getInstance(getContext()).getSubjectDao().insert(model);

    }

    }
