package com.abedkhan.knowledge.Modelclass;

public class QuestionListModel {
    String questionNo,mainQuestion,mainAnsware,ansDescription;

    public QuestionListModel(String questionNo, String mainQuestion, String mainAnsware, String ansDescription) {
        this.questionNo = questionNo;
        this.mainQuestion = mainQuestion;
        this.mainAnsware = mainAnsware;
        this.ansDescription = ansDescription;
    }

    public String getQuestionNo() {
        return questionNo;
    }

    public void setQuestionNo(String questionNo) {
        this.questionNo = questionNo;
    }

    public String getMainQuestion() {
        return mainQuestion;
    }

    public void setMainQuestion(String mainQuestion) {
        this.mainQuestion = mainQuestion;
    }

    public String getMainAnsware() {
        return mainAnsware;
    }

    public void setMainAnsware(String mainAnsware) {
        this.mainAnsware = mainAnsware;
    }

    public String getAnsDescription() {
        return ansDescription;
    }

    public void setAnsDescription(String ansDescription) {
        this.ansDescription = ansDescription;
    }
}
