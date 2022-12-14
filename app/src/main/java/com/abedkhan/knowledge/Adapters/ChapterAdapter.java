package com.abedkhan.knowledge.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.abedkhan.knowledge.Activities.GiveExamOrReadQuestions;
import com.abedkhan.knowledge.Fragments.ReadFragment;
import com.abedkhan.knowledge.Modelclass.ChapterModelClass;
import com.abedkhan.knowledge.Modelclass.FirebaseChapterNoModel;
import com.abedkhan.knowledge.Modelclass.FirebaseSubjectModel;
import com.abedkhan.knowledge.R;
import com.abedkhan.knowledge.ReadAndExam;
import com.abedkhan.knowledge.RecyclerDataListener;
import com.abedkhan.knowledge.Viewholders.ChapterViewholder;

import java.util.List;

public class ChapterAdapter extends RecyclerView.Adapter<ChapterViewholder> {
    List<FirebaseChapterNoModel> chapterModelClasses;
    Context context;
    boolean isExam;
    RecyclerDataListener listener;

    public ChapterAdapter(List<FirebaseChapterNoModel> chapterModelClasses, Context context, boolean isExam, RecyclerDataListener listener) {
        this.chapterModelClasses = chapterModelClasses;
        this.context = context;
        this.isExam = isExam;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ChapterViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.chapter_recycler_design,parent,false);

        return new ChapterViewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ChapterViewholder holder, int position) {

        FirebaseChapterNoModel chapterModelClass=chapterModelClasses.get(position);

//"অধ্যায় : "

//        holder.chapter.setText(chapterModelClass.getChapter());
//        holder.chapterNo.setText(chapterModelClass.getChapterNumber());

// TODO: Exam == true hole apni exam activity te niye jaben and false hole apni Reading activity te niye jaben.... (Same adapter ta Exam fragment eo use hobe)

            holder.chapterName.setText(chapterModelClass.getChapterName());
            holder.chapterWriter.setText(chapterModelClass.getWriterName());
            holder.chapterNo.setText(chapterModelClass.getChapterNumber());
            holder.cardView.setAnimation(AnimationUtils.loadAnimation(holder.itemView.getContext(), R.anim.animation));

        String subject_name = chapterModelClass.getSubjectName();

        if (subject_name.equals("English for Today") || subject_name.equals("English Grammar and Composition")){
            holder.chapter.setText("Lesson: ");
        }

    holder.itemView.setOnClickListener(view -> {
    Intent intent=new Intent(context, GiveExamOrReadQuestions.class);
//    intent.putExtra("firebaseStorageID",chapterModelClass.getFirebaseStorageID());

    intent.putExtra("isExam", isExam);

    intent.putExtra("subjectName",chapterModelClass.getSubjectName());
    intent.putExtra("chapterNo",chapterModelClass.getChapterNumber());
    intent.putExtra("chapterName",chapterModelClass.getChapterName());
    context.startActivity(intent);

});

//        -------------------TODO: Read offline button clicked ----------------

//        holder.readOffline.setOnClickListener(view -> {
////            listener.downloadSubjectData(chapterModelClass.get);
//
//        });

    }

    @Override
    public int getItemCount() {
        return chapterModelClasses.size();
    }
}
