package com.abedkhan.knowledge.Modelclass;

public class ChapterModelClass {
    public String chapter, chapterName, chapterWriter = "";
    int chapterNumber;

    public ChapterModelClass(String chapter, String chapterName, String chapterWriter, int chapterNumber) {
        this.chapter = chapter;
        this.chapterName = chapterName;
        this.chapterWriter = chapterWriter;
        this.chapterNumber = chapterNumber;
    }

    public String getChapter() {
        return chapter;
    }

    public void setChapter(String chapter) {
        this.chapter = chapter;
    }

    public String getChapterName() {
        return chapterName;
    }

    public void setChapterName(String chapterName) {
        this.chapterName = chapterName;
    }

    public String getChapterWriter() {
        return chapterWriter;
    }

    public void setChapterWriter(String chapterWriter) {
        this.chapterWriter = chapterWriter;
    }

    public int getChapterNumber() {
        return chapterNumber;
    }

    public void setChapterNumber(int chapterNumber) {
        this.chapterNumber = chapterNumber;
    }
}
