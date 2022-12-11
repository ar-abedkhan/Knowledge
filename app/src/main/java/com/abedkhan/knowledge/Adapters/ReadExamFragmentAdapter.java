package com.abedkhan.knowledge.Adapters;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.abedkhan.knowledge.Fragments.ExamFragment;
import com.abedkhan.knowledge.Fragments.ReadFragment;

public class ReadExamFragmentAdapter extends FragmentPagerAdapter {
    String [] name={"Read","Exam"};

    public ReadExamFragmentAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new ReadFragment();
            case 1:
                return new ExamFragment();
        }
        return null;
    }

    @Override
    public int getCount() {
        return name.length;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return name[position];
    }
}
