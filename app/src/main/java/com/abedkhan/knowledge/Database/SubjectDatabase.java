package com.abedkhan.knowledge.Database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {SubjectModel.class}, version = 1)
public abstract class SubjectDatabase extends RoomDatabase {
    public abstract SubjectDao getSubjectDao();

    static SubjectDatabase subjectDatabase = null;

    public static SubjectDatabase getInstance(Context context) {
        if (subjectDatabase == null){
            subjectDatabase = Room.databaseBuilder(context,
                    SubjectDatabase.class,
                    "SubjectDatabase")
                    .allowMainThreadQueries()
                    .build();
        }
        return subjectDatabase;
    }
}
