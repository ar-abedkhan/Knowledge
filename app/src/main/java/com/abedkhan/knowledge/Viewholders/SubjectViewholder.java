package com.abedkhan.knowledge.Viewholders;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.abedkhan.knowledge.R;

public class SubjectViewholder extends RecyclerView.ViewHolder {

   public ImageView subjectImg;
   public TextView subjectName;
   public CardView cardView;

    public SubjectViewholder(@NonNull View itemView) {
        super(itemView);

        subjectImg=itemView.findViewById(R.id.ssubjectImg);
        subjectName=itemView.findViewById(R.id.subjectName);
        cardView=itemView.findViewById(R.id.Card);
    }
}
