package com.abedkhan.knowledge.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.abedkhan.knowledge.Modelclass.SubjectModelClass;
import com.abedkhan.knowledge.R;
import com.abedkhan.knowledge.Viewholders.SubjectViewholder;
import com.bumptech.glide.Glide;

import java.util.List;

public class SubjectAdapter extends RecyclerView.Adapter<SubjectViewholder> {
    List<SubjectModelClass>subjectModelClassList;
    Context context;

    public SubjectAdapter(List<SubjectModelClass> subjectModelClassList, Context context) {
        this.subjectModelClassList = subjectModelClassList;
        this.context = context;
    }

    @NonNull
    @Override
    public SubjectViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.subject_design,parent,false);
        return new SubjectViewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SubjectViewholder holder, int position) {
        SubjectModelClass subjectModelClass=subjectModelClassList.get(position);

        holder.subjectName.setText(subjectModelClass.getSubjectName());
        Glide.with(context).load(subjectModelClass.getSubjectIMG()).into(holder.subjectImg);

        holder.cardView.setAnimation(AnimationUtils.loadAnimation(holder.itemView.getContext(),R.anim.animation));
    }

    @Override
    public int getItemCount() {
        return subjectModelClassList.size();
    }
}
