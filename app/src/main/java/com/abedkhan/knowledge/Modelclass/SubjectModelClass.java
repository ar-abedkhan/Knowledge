package com.abedkhan.knowledge.Modelclass;

public class SubjectModelClass {

    public String subjectName;
    public int subjectIMG;

    public SubjectModelClass(String subjectName, int subjectIMG) {
        this.subjectName = subjectName;
        this.subjectIMG = subjectIMG;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public int getSubjectIMG() {
        return subjectIMG;
    }

    public void setSubjectIMG(int subjectIMG) {
        this.subjectIMG = subjectIMG;
    }
}
