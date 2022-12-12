package com.abedkhan.knowledge.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.abedkhan.knowledge.R;
import com.abedkhan.knowledge.databinding.ActivityAdminLoginBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class AdminLoginActivity extends AppCompatActivity {

    ActivityAdminLoginBinding binding;
    FirebaseAuth firebaseAuth;
    FirebaseUser firebaseUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAdminLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
        if (firebaseUser.getUid() != null){

        }

        firebaseAuth = FirebaseAuth.getInstance();

//        ----------- Register option ----------
        binding.adminRegisterOption.setOnClickListener(view -> {
            startActivity(new Intent(AdminLoginActivity.this, RegisterAdmin.class));
            finish();
        });


//        ---------------- Login Button ----------------
        binding.adminLoginBtn.setOnClickListener(view -> {
            binding.progressBar.setVisibility(View.VISIBLE);
            binding.adminLoginBtn.setVisibility(View.GONE);

            String email = binding.adminEmail.getText().toString();
            String password = binding.adminPassword.getText().toString();

            firebaseAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()){
                        Toast.makeText(AdminLoginActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(AdminLoginActivity.this, AdminDashboard.class));
                        finish();
                    }
                    else{
                        showFailedAlert("Error!", task.getException().getLocalizedMessage());
                    }
                }
            });

        });
    }

    private void showFailedAlert(String title, String localizedErrorMessage) {
        AlertDialog.Builder builder = new AlertDialog.Builder(AdminLoginActivity.this);

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
        binding.adminLoginBtn.setVisibility(View.VISIBLE);
    }
}