package com.example.myapplication.model;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import static androidx.room.OnConflictStrategy.REPLACE;

@Dao
public interface ShowDAO {

    @Insert(onConflict = REPLACE)
    void save(Show show);

    @Query("SELECT * FROM show WHERE id = :id")
    LiveData<Show> getShowById(String id);

}
