package com.example.myapplication.model;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

@Dao
public interface ShowResultsListDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void save(ShowResultsList list);

    @Query("SELECT * FROM showresultslist WHERE searchQuery = :query")
    LiveData<ShowResultsList> load(String query);
}
