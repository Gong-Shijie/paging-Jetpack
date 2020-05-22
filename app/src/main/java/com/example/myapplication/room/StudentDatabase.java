package com.example.myapplication.room;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Student.class}, version = 1, exportSchema = false)
public abstract class StudentDatabase extends RoomDatabase {
    public abstract StudentDao getStudentDao();

    private static StudentDatabase INSTANCE;
    //双重检查  创建单例  支持并发   懒加载
    public static StudentDatabase getInstance(Context context) {
        if (INSTANCE == null) {
            synchronized (StudentDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(), StudentDatabase.class, "student_db").
                            build();
                }

            }
        }
        return INSTANCE;
    }
}
