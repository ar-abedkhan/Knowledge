package com.abedkhan.knowledge.Viewholders;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.abedkhan.knowledge.R;

public class QuestionListViewholder extends RecyclerView.ViewHolder {
    public TextView questionNo,mainQuestion,mainAns,ansDescription;

    public QuestionListViewholder(@NonNull View itemView) {
        super(itemView);

        questionNo=itemView.findViewById(R.id.questionNumber);
        mainQuestion=itemView.findViewById(R.id.mainQuestion);
        ansDescription=itemView.findViewById(R.id.answerDescription);
        mainAns=itemView.findViewById(R.id.mainAnsware);


    }
}
