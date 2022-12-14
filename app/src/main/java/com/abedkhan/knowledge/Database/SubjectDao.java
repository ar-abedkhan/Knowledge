package com.abedkhan.knowledge.Database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;


import java.util.List;

@Dao
public interface SubjectDao {
    @Insert
    void insert(SubjectModel subjectModel);

    @Update
    void update(SubjectModel subjectModel);

    @Delete
    void delete(SubjectModel subjectModel);

    @Query(value = "SELECT * FROM SubjectModel WHERE id ==:myID")
    List<SubjectModel> getDataById(int myID);

    @Query("SELECT * FROM SubjectModel WHERE firebaseStorageID ==:storageID")
    List<SubjectModel> getFirebaseStorageID(String storageID);

    @Query("SELECT * FROM SubjectModel WHERE subjectName ==:subjectName")
    List<SubjectModel> getDataBySubjectName(String subjectName);

    @Query("SELECT * FROM SubjectModel WHERE chapterName ==:chapterName")
    List<SubjectModel> getDataByChapterName(String chapterName);

    @Query("SELECT * FROM SubjectModel WHERE chapterNumber ==:chapterNumber")
    List<SubjectModel> getDataByChapterNumber(String chapterNumber);

    @Query("SELECT * FROM SubjectModel WHERE writerName ==:writerName")
    List<SubjectModel> getDataByWriterName(String writerName);

    @Query("SELECT * FROM SubjectModel WHERE question ==:question")
    List<SubjectModel> getDataByQuestion(String question);

}
