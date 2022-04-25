package com.dhawal.petetite.Database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.dhawal.petetite.Database.Dao.UsersDao;
import com.dhawal.petetite.Database.Entity.User;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {User.class},version = 1)
public abstract class UserDatabase extends RoomDatabase {
    public abstract UsersDao usersDao;

    private static final int NUMBER_OF_THREADS = 2;
    public static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    private static volatile UserDatabase instance;

    public static UserDatabase getDatabaseInstance(final Context context){
        if (instance == null) {
            synchronized (UserDatabase.class) {
                //we are locking this class
                if (instance == null) {
                    instance = Room.databaseBuilder(
                            context.getApplicationContext(),
                            UserDatabase.class,//which class you want to build
                            "user_database")//Name of the sql database in sql
                            .fallbackToDestructiveMigration()//if the version changes , Destroy everything and re-create
                            .build();

                }
            }
        }
        return instance;

    }
}
