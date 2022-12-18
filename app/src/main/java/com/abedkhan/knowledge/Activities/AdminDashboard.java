package com.abedkhan.knowledge.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.abedkhan.knowledge.Fragments.AddFragment;
import com.abedkhan.knowledge.MainActivity;
import com.abedkhan.knowledge.R;
import com.abedkhan.knowledge.databinding.ActivityAdminDashboardBinding;
import com.google.firebase.auth.FirebaseAuth;

public class AdminDashboard extends AppCompatActivity {

    ActivityAdminDashboardBinding binding;
    FirebaseAuth firebaseAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityAdminDashboardBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        firebaseAuth = FirebaseAuth.getInstance();

//        ----------------sign out option handling --------------------
        binding.signOutBtn.setOnClickListener(view -> {
            firebaseAuth.signOut();
        });

        binding.addOption.setOnClickListener(view -> {
        binding.dashboard.setVisibility(View.GONE);
        getSupportFragmentManager().beginTransaction().add(R.id.fragmentView,new AddFragment()).commit();

        });

    }





    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(this, MainActivity.class));
    }
}