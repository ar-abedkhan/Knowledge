package com.abedkhan.knowledge.Viewholders;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.abedkhan.knowledge.R;

public class DepartmentViewholder extends RecyclerView.ViewHolder {

   public ImageView departmentImg;
   public TextView departmentName;

    public DepartmentViewholder(@NonNull View itemView) {
        super(itemView);

        departmentImg=itemView.findViewById(R.id.departnameImg);
        departmentName=itemView.findViewById(R.id.departmentName);
    }
}
