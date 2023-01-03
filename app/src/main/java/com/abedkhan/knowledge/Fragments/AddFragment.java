package com.abedkhan.knowledge.Fragments;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.provider.ContactsContract;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.abedkhan.knowledge.Modelclass.FirebaseChapterNoModel;
import com.abedkhan.knowledge.R;
import com.abedkhan.knowledge.databinding.FragmentAddBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;

public class AddFragment extends Fragment {

    public AddFragment() {
    }


    FragmentAddBinding binding;
    String subjectName, chapterName, writerName, question, rightAnswer, option1, option2, option3, answerDescription;
    String currentID;
    String chapterNumber;

    String chapterId;

    FirebaseUser firebaseUser;
    DatabaseReference databaseReference;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentAddBinding.inflate(getLayoutInflater(), container, false);

        databaseReference = FirebaseDatabase.getInstance().getReference();

//        -------------------- Spinner settings ----------------
//        ...TODO: shob gula subject name eikhane add koiren

        String[] allSubject = {

                "বাংলা সাহিত্য",
                "বাংলা ভাষার ব্যাকরণ",
                "English for Toady",
                "গণিত",
                "English Grammar and Composition",
                "তথ্য ও যোগাযোগ প্রযুক্তি",
                "শারীরিক শিক্ষা",
                "চারু ও কারুকলা",
                "ক্যারিয়ার এডুকেশন",
                "খ্রিষ্টধর্ম ও নৈতিক শিক্ষা",
                "বৌদ্ধধর্ম ও নৈতিক শিক্ষা",
                "হিন্দু ধর্ম ও নৈতিক শিক্ষা",
                "ইসলাম ও নৈতিক শিক্ষা",
                "গার্হস্থ্য বিজ্ঞান ",
                "কৃষিশিক্ষা",
                "পদার্থবিজ্ঞান", "রসায়ন", "জীববিজ্ঞান", "উচ্চতর গণিত","বাংলাদেশ ও বিশ্ব পরিচয়",
                "ভূগোল ও পরিবেশ", "পৌরনীতি ও নাগরিকতা", "বাংলাদেশের ইতিহাস ও বিশ্বসভ্যতা",
                "ফিনান্স ও ব্যাঙ্কিং","হিসাববিজ্ঞান","সাধারন বিজ্ঞান","ব্যবসায় উদ্যোগ"
        };

        ArrayAdapter<String> subjectAdapter = new ArrayAdapter<>(getContext(),
                android.R.layout.simple_dropdown_item_1line,
                allSubject);
        binding.subjectName.setAdapter(subjectAdapter);


//        ----------------------- Add button settings ----------------
        binding.addDataBtn.setOnClickListener(view -> {
//            subjectName = binding.subjectName.getSelectedItem().toString();
            subjectName = binding.subjectName.getSelectedItem().toString().trim();
            chapterName = binding.chapterName.getText().toString().trim();
            chapterNumber = binding.chapterNumber.getText().toString().trim();
            writerName = binding.writerName.getText().toString().trim();
            question = binding.mainQuestion.getText().toString().trim();
            rightAnswer = binding.rightAns.getText().toString().trim();
            option1 = binding.answarwOne.getText().toString().trim();
            option2 = binding.answareTwo.getText().toString().trim();
            option3 = binding.answarwThree.getText().toString().trim();
            answerDescription = binding.answerDescription.getText().toString().trim();

//            ------------------ Checking if there are any Item with the same name in the firebase ------------------
            databaseReference.child(subjectName).addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    /*
                    * Ekhane firebase theke data niye agee dekha hocche same chapter ki agee thekei include kora ache kina
                    * jodi na thake tahole notun kore include kora hocche r jodi thake tahole just data include kora hocche
                    * */

                    boolean isChapterMatched = false;
                    for (DataSnapshot dataSnapshot:snapshot.getChildren()){
                        FirebaseChapterNoModel chapterNoModel = dataSnapshot.getValue(FirebaseChapterNoModel.class);
//                        Log.i("TAG", "Chapter number firebase--->: "+ chapterNoModel.getChapterNumber());
//                        Log.i("TAG", "Chapter number----------->>> "+ chapterNumber);

//                        ------------ If the chapter No. matches that means there are no need for new chapter id ------------
                        String tempChapterNo = chapterNoModel.getChapterNumber();
                        if (tempChapterNo.equals(chapterNumber)){
                            chapterId = chapterNoModel.getChapterId();
//                            Log.i("TAG", "----------------same chapter id----------------");
                            isChapterMatched = true;
                            break;
                        }

                    }

                    if (isChapterMatched == false){
//                        Log.i("TAG", "_______________________ Task false ____________________________ ");
                        chapterId = databaseReference.push().getKey();
                        saveDataToFirebase(subjectName, chapterNumber, chapterName, writerName, question, rightAnswer, option1, option2, option3, answerDescription);
                    }else {
//                        Log.i("TAG", "_______________________ Task true ____________________________ ");
                        saveDataToFirebase(subjectName, chapterNumber, chapterName, writerName, question, rightAnswer, option1, option2, option3, answerDescription);
                    }

                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {
//                    Log.i("TAG", "_______________________ Task canceled ____________________________ ");
                    chapterId = databaseReference.push().getKey();
                    saveDataToFirebase(subjectName, chapterNumber, chapterName, writerName, question, rightAnswer, option1, option2, option3, answerDescription);
                }
            });


        });



        return binding.getRoot();
    }

    private void saveDataToFirebase(String subjectName, String chapterNumber, String chapterName, String writerName, String question, String rightAnswer, String option1, String option2, String option3, String answerDescription) {
        currentID = databaseReference.push().getKey();

//---------------------------- Chapter Number data save START --------------------------

        HashMap<String, Object> myData = new HashMap<>();
        myData.put("chapterId", chapterId);
        myData.put("subjectName", subjectName);
        myData.put("chapterNumber", chapterNumber);
        myData.put("chapterName", chapterName);
        myData.put("writerName", writerName);

        databaseReference.child(subjectName).child(chapterId).setValue(myData).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()){
                    //        ------------------ Adding data to the firebase storage ------------------
                    HashMap<String, Object> addData = new HashMap<>();
                    addData.put("subjectName", subjectName);
                    addData.put("ID", currentID);
                    addData.put("chapterNumber", chapterNumber);
                    addData.put("chapterName", chapterName);
                    addData.put("writerName", writerName);
                    addData.put("question", question);
                    addData.put("rightAnswer", rightAnswer);
                    addData.put("option1", option1);
                    addData.put("option2", option2);
                    addData.put("option3", option3);
                    addData.put("answerDescription", answerDescription);

//        ------------------ Passing data to the firebase storage ------------------
                    databaseReference.child(subjectName + " " + chapterNumber).child(currentID).setValue(addData).addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void unused) {
                            Toast.makeText(getContext(), "Data added successfully <3", Toast.LENGTH_SHORT).show();
                            blankAllFields();
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {

                            AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                            builder.setTitle("Error!");
                            builder.setMessage("Sorry, there was an error while saving data");
                            builder.setIcon(R.drawable.warning_icon);
                            builder.setPositiveButton("Okay", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {

                                }
                            });
                            AlertDialog dialog = builder.create();
                            dialog.show();

                        }
                    });


                }
                else {
                    AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                    builder.setTitle("Error!");
                    builder.setMessage(task.getException().getLocalizedMessage());
                    builder.setIcon(R.drawable.warning_icon);
                    builder.setPositiveButton("Okay", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                        }
                    });
                    AlertDialog dialog = builder.create();
                    dialog.show();
                }
            }
        });

//---------------------------- Chapter Number data save END --------------------------


    }

    private void blankAllFields() {

        binding.subjectName.getSelectedItem();
//        binding.chapterName.setText("");
//        binding.chapterNumber.setText("");
        binding.writerName.setText("");
        binding.mainQuestion.setText("");
        binding.rightAns.setText("");
        binding.answarwOne.setText("");
        binding.answareTwo.setText("");
        binding.answarwThree.setText("");
        binding.answerDescription.setText("");
    }
}