package com.example.roomexample.room;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface UserDao {
    @Query("SELECT * FROM User")
    List<User> getAll();

    @Query("SELECT * FROM User WHERE uid IN (:userIds)")
    List<User> getAllInUserIds(int userIds);

    @Query("SELECT * FROM user WHERE first_name LIKE :firstName AND " +
            "last_name LIKE :lastName LIMIT 1")
    User findByName(String firstName, String lastName);

    @Insert
    void insert(User user);

    @Delete
    void delete(User user);
}
