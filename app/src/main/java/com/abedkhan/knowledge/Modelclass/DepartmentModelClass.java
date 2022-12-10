package com.abedkhan.knowledge.Modelclass;

public class DepartmentModelClass {

    public String departmentName;
    public int departmentIMG;

    public DepartmentModelClass(String departmentName, int departmentIMG) {
        this.departmentName = departmentName;
        this.departmentIMG = departmentIMG;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public int getDepartmentIMG() {
        return departmentIMG;
    }

    public void setDepartmentIMG(int departmentIMG) {
        this.departmentIMG = departmentIMG;
    }
}
