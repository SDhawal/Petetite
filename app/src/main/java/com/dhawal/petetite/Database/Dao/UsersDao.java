package com.dhawal.petetite.Database.Dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.dhawal.petetite.Database.Entity.User;

import java.util.List;

@Dao
public interface UsersDao {

    @Query("Select * from User where id = :id")
    User getUser(int id);

    @Query("select exists(select * from User where user_name = :username)")
    boolean exist(String username);

    @Query("select * from User where user_name = :username and password = :password")
    User validate(String username, String password);


    @Insert
    void insert(User... users);

    //updating the data

    @Update
    void update (User... users); // doubleCheck if it works with spread
    //Deleting the data

    @Delete
    void delete (User... users);
}
