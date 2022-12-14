package com.abedkhan.knowledge.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.abedkhan.knowledge.Fragments.AddFragment;
import com.abedkhan.knowledge.MainActivity;
import com.abedkhan.knowledge.R;
import com.abedkhan.knowledge.databinding.ActivityAdminDashboardBinding;

public class AdminDashboard extends AppCompatActivity {
ActivityAdminDashboardBinding binding;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityAdminDashboardBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


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