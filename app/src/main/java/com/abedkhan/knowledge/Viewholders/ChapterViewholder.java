package com.abedkhan.knowledge.Viewholders;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.abedkhan.knowledge.R;

public class ChapterViewholder extends RecyclerView.ViewHolder {
    public TextView chapter,chapterNo,chapterName,chapterWriter;
//    public ImageView readOffline;
    public CardView cardView;

    public ChapterViewholder(@NonNull View itemView) {
        super(itemView);

        chapter=itemView.findViewById(R.id.chapter);
        chapterNo=itemView.findViewById(R.id.chapterNumber);
        chapterName=itemView.findViewById(R.id.chapterTopicName);
        chapterWriter=itemView.findViewById(R.id.topicWriterName);
        cardView=itemView.findViewById(R.id.chapterCard);

//        readOffline = itemView.findViewById(R.id.readOfflineBtn);
    }
}
