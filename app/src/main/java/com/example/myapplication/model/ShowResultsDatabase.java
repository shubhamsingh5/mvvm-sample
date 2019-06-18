package com.example.myapplication.model;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

@Database(entities = {ShowResultsList.class}, version = 1)
@TypeConverters(value = SearchResultsConverter.class)
public abstract class ShowResultsDatabase extends RoomDatabase {

    private static final String DATABASE_NAME = "showresultslist";
    private static ShowResultsDatabase sInstance;


    public static ShowResultsDatabase getInstance(Context context) {
        if (sInstance == null) {
            sInstance = Room.databaseBuilder(context.getApplicationContext(), ShowResultsDatabase.class, ShowResultsDatabase.DATABASE_NAME).allowMainThreadQueries().build();
        }
        return sInstance;
    }

    public abstract ShowResultsListDAO resultsDAO();

}
