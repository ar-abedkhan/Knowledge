package com.abedkhan.knowledge.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.abedkhan.knowledge.Modelclass.DepartmentModelClass;
import com.abedkhan.knowledge.R;
import com.abedkhan.knowledge.Viewholders.DepartmentViewholder;
import com.bumptech.glide.Glide;

import java.util.List;

import kotlin.jvm.internal.Lambda;

public class DepartmentAdapter extends RecyclerView.Adapter<DepartmentViewholder> {
    List<DepartmentModelClass>departmentModelClassList;
    Context contex;

    public DepartmentAdapter(List<DepartmentModelClass> departmentModelClassList, Context contex) {
        this.departmentModelClassList = departmentModelClassList;
        this.contex = contex;
    }

    @NonNull
    @Override
    public DepartmentViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(contex).inflate(R.layout.department_design,parent,false);
        return new DepartmentViewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DepartmentViewholder holder, int position) {

        DepartmentModelClass departmentModelClass=departmentModelClassList.get(position);

        holder.departmentName.setText(departmentModelClass.getDepartmentName());
        Glide.with(contex).load(departmentModelClass.getDepartmentIMG()).into(holder.departmentImg);



    }

    @Override
    public int getItemCount() {
        return departmentModelClassList.size();
    }
}
