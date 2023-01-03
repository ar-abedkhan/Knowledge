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
import com.abedkhan.knowledge.Modelclass.FirebaseChapterNoModel;
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
public class ReadFragment extends Fragment implements RecyclerDataListener{

    public ReadFragment() {
    }
    FragmentReadBinding binding;
//    List<FirebaseSubjectModel> firebaseSubjectModelList;
    List<FirebaseChapterNoModel> noModelList;


    FirebaseAuth firebaseAuth;
    DatabaseReference databaseReference;
    String chapterNo;
    String currentID , subjectName;
    Intent intent;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding=FragmentReadBinding.inflate(getLayoutInflater(),container,false);

        firebaseAuth = FirebaseAuth.getInstance();
        databaseReference = FirebaseDatabase.getInstance().getReference();

//        firebaseSubjectModelList = new ArrayList<>(); //-------- Getting data from firebase with all details---------
        noModelList = new ArrayList<>(); //-------- Getting data from firebase subject---------

//        _____________________ Getting subject Name from previous Activity _______________________

        intent = getActivity().getIntent();
        subjectName = intent.getStringExtra("subjectName");

        binding.subjectNameTitle.setText(subjectName);

        showDataToAdapter(subjectName);

//        FirebaseSubjectModel firebaseSubjectModel=new FirebaseSubjectModel();

//   binding.subjectNameTitle.setText(subjectName);
//
//       chapterno=firebaseSubjectModel.getChapterNumber();

//        binding.readOfflineBtn.setOnClickListener(view -> {
//
//        });


        return binding.getRoot();
    }

    private void showDataToAdapter(String subjectName) {

        try {
//        ------------------------- Retrieving data from firebase start-------------------------------
                databaseReference.child(subjectName).addValueEventListener(new ValueEventListener() {
                    //            databaseReference.child(subjectName).addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        Log.i("tag", "chapter");
                        noModelList.clear();

                        for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                            FirebaseChapterNoModel modelList = dataSnapshot.getValue(FirebaseChapterNoModel.class);
                            noModelList.add(modelList);
//                            Log.i("tag", "chapter" + modelList.getQuestion());
                        }

                        ChapterAdapter chapterAdapter = new ChapterAdapter(noModelList, requireActivity(), false, ReadFragment.this);
                        binding.readRecycler.setAdapter(chapterAdapter);
                        Log.i("tag", "Read fragment ended-----------------------------");

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
//        ------------------------- Retrieving data from firebase END-------------------------------
        }catch (Exception e){
            Log.i("TAG", "Error: "+ e);
        }


    }




//    --------------------- Starting download from the firebase -------------------------
//    TODO: EKhane FirebaseSubjectModel onujayi data boshbe

    @Override
    public void downloadSubjectData(String currentFirebaseID) {
        //            TODO: take the subject from the firebase and save it to the room database
        databaseReference.child(subjectName).child(currentFirebaseID).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                noModelList.clear(); //    TODO: EKhane FirebaseSubjectModel er list onujayi data boshbe

                for (DataSnapshot dataSnapshot: snapshot.getChildren()){
                    FirebaseChapterNoModel subjectModel = dataSnapshot.getValue(FirebaseChapterNoModel.class); //-------TODO: EKhane FirebaseSubjectModel onujayi data boshbe
                    noModelList.add(subjectModel);
                }
                //----------------- saveDataToRoom ---------
//                saveDataToRoom(noModelList);

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

//        firebaseStorageID, subjectName, chapterNumber, chapterName, writerName, question, rightAnswer, option1, option2, option3, answerDescription
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