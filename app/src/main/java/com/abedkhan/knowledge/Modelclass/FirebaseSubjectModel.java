package com.abedkhan.knowledge.Modelclass;

public class FirebaseSubjectModel {
    String ID, subjectName, chapterNumber, chapterName, writerName, question, rightAnswer, option1, option2, option3, answerDescription;

    public FirebaseSubjectModel(String firebaseStorageID, String subjectName, String chapterNumber, String chapterName, String writerName, String question, String rightAnswer, String option1, String option2, String option3, String answerDescription) {
        this.ID = firebaseStorageID;
        this.subjectName = subjectName;
        this.chapterNumber = chapterNumber;
        this.chapterName = chapterName;
        this.writerName = writerName;
        this.question = question;
        this.rightAnswer = rightAnswer;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
    }

    public FirebaseSubjectModel() {
    }

    public String getID() {
        return ID;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public String getChapterNumber() {
        return chapterNumber;
    }

    public String getChapterName() {
        return chapterName;
    }

    public String getWriterName() {
        return writerName;
    }

    public String getQuestion() {
        return question;
    }

    public String getRightAnswer() {
        return rightAnswer;
    }

    public String getOption1() {
        return option1;
    }

    public String getOption2() {
        return option2;
    }

    public String getOption3() {
        return option3;
    }

    public String getAnswerDescription() {
        return answerDescription;
    }
}
