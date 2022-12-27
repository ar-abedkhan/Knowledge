package com.abedkhan.knowledge.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.abedkhan.knowledge.Modelclass.QuestionListModel;
import com.abedkhan.knowledge.R;
import com.abedkhan.knowledge.Viewholders.QuestionListViewholder;

import java.util.List;

public class QuestionListAdapter extends RecyclerView.Adapter<QuestionListViewholder>{
         List<QuestionListModel>questionListModelList;
         Context context;

    public QuestionListAdapter(List<QuestionListModel> questionListModelList, Context context) {
        this.questionListModelList = questionListModelList;
        this.context = context;
    }

    @NonNull
    @Override
    public QuestionListViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.read_recycler,parent,false);
        return new QuestionListViewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull QuestionListViewholder holder, int position) {

        QuestionListModel questionListModel=questionListModelList.get(position);

        holder.mainQuestion.setText(questionListModel.getMainQuestion());
        holder.questionNo.setText(questionListModel.getQuestionNo());
        holder.mainAns.setText(questionListModel.getMainAnsware());
        holder.ansDescription.setText(questionListModel.getAnsDescription());
    }

    @Override
    public int getItemCount() {
        return questionListModelList.size();
    }
}
