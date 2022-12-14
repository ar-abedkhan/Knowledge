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

        binding.addDataBtn.setOnClickListener(view -> {
            subjectName = binding.subjectName.getText().toString();
            chapterName = binding.chapterName.getText().toString();
            chapterNumber = binding.chapterName.getText().toString();

            writerName = binding.writerName.getText().toString();
            question = binding.question.getText().toString();
            rightAnswer = binding.rightAns.getText().toString();
            option1 = binding.answarwOne.getText().toString();
            option2 = binding.answareTwo.getText().toString();
            option3 = binding.answerThree.getText().toString();

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

        binding.subjectName.setText("");
        binding.chapterName.setText("");
        binding.chapterNumber.setText("");
        binding.writerName.setText("");
        binding.question.setText("");
        binding.rightAns.setText("");
        binding.answarwOne.setText("");
        binding.answareTwo.setText("");
        binding.answerThree.setText("");
    }
}