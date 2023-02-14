package com.example.roomexample.room;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;

@Database(entities = {User.class}, version = 1)
public abstract class AppDataBase extends RoomDatabase {
    static final String DB_NAME = "USER_DATEBASE.db";
    private static volatile AppDataBase instance = null;

    public static AppDataBase getInstance(Context context){
        synchronized (AppDataBase.class){
            if(instance == null){
                instance = create(context);
            }

            return instance;
        }
    }

    @Override
    public void clearAllTables() {

    }

    @NonNull
    @Override
    protected InvalidationTracker createInvalidationTracker() {
        return null;
    }

    @NonNull
    @Override
    protected SupportSQLiteOpenHelper createOpenHelper(@NonNull DatabaseConfiguration databaseConfiguration) {
        return null;
    }

    public abstract UserDao getDataUao();

    private static AppDataBase create(Context context){
        return Room.databaseBuilder(context, AppDataBase.class, DB_NAME).build();
    }
}
