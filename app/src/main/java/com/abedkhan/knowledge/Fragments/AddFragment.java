package com.abedkhan.knowledge.Fragments;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.abedkhan.knowledge.R;
import com.abedkhan.knowledge.databinding.FragmentAddBinding;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class AddFragment extends Fragment {

    public AddFragment() {
    }


    FragmentAddBinding binding;
    String subjectName, chapterName, writerName, question, rightAnswer, option1, option2, option3;
    String currentID;
    String chapterNumber;

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
                "Enlish Grammer and Composition",
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
                "ভূগোল ও পরিবেশ ", "পৌরনীতি ও নাগরিকতা", "বাংলাদেশের ইতিহাস ও বিশ্বসভ্যতা",
                "ফিনান্স ও ব্যাঙ্কিং","হিসাববিজ্ঞান","সাধারন বিজ্ঞান","ব্যবসায় উদ্যোগ"
        };

        ArrayAdapter<String> subjectAdapter = new ArrayAdapter<>(getContext(),
                android.R.layout.simple_dropdown_item_1line,
                allSubject);
        binding.subjectName.setAdapter(subjectAdapter);


//        ----------------------- Add button settings ----------------
        binding.addDataBtn.setOnClickListener(view -> {
            subjectName = binding.subjectName.getSelectedItem().toString();
            subjectName = binding.subjectName.getSelectedItem().toString();
            chapterName = binding.chapterName.getText().toString();
            chapterNumber = binding.chapterName.getText().toString();

            writerName = binding.writerName.getText().toString();
            question = binding.mainQuestion.getText().toString();
            rightAnswer = binding.rightAns.getText().toString();
            option1 = binding.answarwOne.getText().toString();
            option2 = binding.answareTwo.getText().toString();
            option3 = binding.answarwThree.getText().toString();

            saveDataToFirebase(subjectName, chapterNumber, chapterName, writerName, question, rightAnswer, option1, option2, option3);

        });



        return binding.getRoot();
    }

    private void saveDataToFirebase(String subjectName, String chapterNumber, String chapterName, String writerName, String question, String rightAnswer, String option1, String option2, String option3) {
        currentID = databaseReference.push().getKey();

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

//        ------------------ Adding data to the firebase storage ------------------
        databaseReference.child(subjectName).child(currentID).setValue(addData).addOnSuccessListener(new OnSuccessListener<Void>() {
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

    private void blankAllFields() {

        binding.subjectName.getSelectedItem();
        binding.chapterName.setText("");
        binding.chapterNumber.setText("");
        binding.writerName.setText("");
        binding.mainQuestion.setText("");
        binding.rightAns.setText("");
        binding.answarwOne.setText("");
        binding.answareTwo.setText("");
        binding.answarwThree.setText("");
    }
}