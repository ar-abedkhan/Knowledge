package com.abedkhan.knowledge.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.abedkhan.knowledge.MainActivity;
import com.abedkhan.knowledge.R;
import com.abedkhan.knowledge.databinding.ActivityRegisterAdminBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class RegisterAdmin extends AppCompatActivity {
    ActivityRegisterAdminBinding binding;
    String email, password, rePassword;
    FirebaseAuth firebaseAuth;
    FirebaseUser firebaseUser;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRegisterAdminBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        firebaseAuth = FirebaseAuth.getInstance();
        databaseReference = FirebaseDatabase.getInstance().getReference();

//        --------- login option ----------
        binding.adminLoginOption.setOnClickListener(view -> {
            startActivity(new Intent(RegisterAdmin.this, AdminLoginActivity.class));
            finish();
        });

//        ------------------- Handling Register button click ---------------------
        binding.adminRegisterBtn.setOnClickListener(view -> {

            binding.progressBar.setVisibility(View.VISIBLE);
            binding.adminRegisterBtn.setVisibility(View.INVISIBLE);

            email = binding.adminEmail.getText().toString();
            password = binding.adminPassword.getText().toString();
            rePassword = binding.adminRePassword.getText().toString();

            if (!password.equals(rePassword)){
                binding.adminRePassword.setError("Password did not Matched");
            }
            else{
//            ---------------- Saving Admin ------------------
                firebaseAuth.createUserWithEmailAndPassword(email, password).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                    @Override
                    public void onSuccess(AuthResult authResult) {
                        firebaseUser = FirebaseAuth.getInstance().getCurrentUser();

                        HashMap<String, Object> user = new HashMap<>();
                        user.put("email", email);
                        user.put("password", password);

//                        --------------- Storing user to the realtime database --------------
                        databaseReference.child("user").child(firebaseUser.getUid()).setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {

                                if (task.isSuccessful()){
                                    binding.progressBar.setVisibility(View.GONE);
                                    binding.adminRegisterBtn.setVisibility(View.VISIBLE);

                                    Toast.makeText(RegisterAdmin.this, "New contributor added successfully", Toast.LENGTH_SHORT).show();
                                    startActivity(new Intent(RegisterAdmin.this, AdminLoginActivity.class));
                                    finish();
                                }
                                else{
                                    showFailedAlert("Error!" ,task.getException().getLocalizedMessage());
                                }
                            }
                        });


                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        showFailedAlert("Failed!!", e.getLocalizedMessage());

                    }
                });
            }

        });
    }

    private void showFailedAlert(String title, String localizedErrorMessage) {
        AlertDialog.Builder builder = new AlertDialog.Builder(RegisterAdmin.this);

        builder.setTitle(title);
        builder.setIcon(R.drawable.warning_icon);
        builder.setMessage(localizedErrorMessage);

        builder.setNegativeButton("Okay", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();
        binding.progressBar.setVisibility(View.GONE);
        binding.adminRegisterBtn.setVisibility(View.VISIBLE);
    }
}