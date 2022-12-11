package com.abedkhan.knowledge.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.abedkhan.knowledge.Modelclass.ChapterModelClass;
import com.abedkhan.knowledge.R;
import com.abedkhan.knowledge.Viewholders.ChapterViewholder;

import java.util.List;

public class ChapterAdapter extends RecyclerView.Adapter<ChapterViewholder> {
    List<ChapterModelClass>chapterModelClasses;
    Context context;

    public ChapterAdapter(List<ChapterModelClass> chapterModelClasses, Context context) {
        this.chapterModelClasses = chapterModelClasses;
        this.context = context;
    }

    @NonNull
    @Override
    public ChapterViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.chapter_recycler_design,parent,false);

        return new ChapterViewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ChapterViewholder holder, int position) {

        ChapterModelClass chapterModelClass=chapterModelClasses.get(position);
//"অধ্যায় : "
        holder.chapter.setText(chapterModelClass.getChapter());
//        holder.chapterNo.setText(chapterModelClass.getChapterNumber());
        holder.chapterName.setText(chapterModelClass.getChapterName());
        holder.chapterWriter.setText(chapterModelClass.getChapterWriter());

        holder.cardView.setAnimation(AnimationUtils.loadAnimation(holder.itemView.getContext(),R.anim.animation));

    }

    @Override
    public int getItemCount() {
        return chapterModelClasses.size();
    }
}
