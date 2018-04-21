package com.example.yadin.exercise6.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.example.yadin.exercise6.model.Note;

/**
 * Created by yadin on 18/04/2018.
 */

@Database(entities = {Note.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase{
    private static final String DATABASE_NAME = "notes";

    public abstract NoteDao noteDao();

    private static AppDatabase singleton;
//
    public static AppDatabase getAppDatabase(Context context) {

        if (singleton == null) {
            synchronized (AppDatabase.class) {
                if (singleton == null) {
                    singleton = Room.databaseBuilder(context.getApplicationContext(),
                            AppDatabase.class,
                            DATABASE_NAME)
                            .build();
                }
            }
        }
        return singleton;

    }

//    public static AppDatabase getAppDatabase(Context context) {
//        if (singleton == null) {
//            singleton = Room.databaseBuilder(context.getApplicationContext(),
//                    AppDatabase.class, DATABASE_NAME)
//                    .allowMainThreadQueries()
//                    .build();
//        }
//        return singleton;
//    }

    public static void destroyInstance() {
        singleton = null;
    }


}
