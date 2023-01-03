package com.abedkhan.knowledge.Modelclass;

public class FirebaseChapterNoModel {
        String chapterId, subjectName, chapterNumber, chapterName, writerName;

    public FirebaseChapterNoModel(String chapterId, String subjectName, String chapterNumber, String chapterName, String writerName) {
        this.chapterId = chapterId;
        this.subjectName = subjectName;
        this.chapterNumber = chapterNumber;
        this.chapterName = chapterName;
        this.writerName = writerName;
    }

    public FirebaseChapterNoModel() {
    }

    public String getChapterId() {
        return chapterId;
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
}
