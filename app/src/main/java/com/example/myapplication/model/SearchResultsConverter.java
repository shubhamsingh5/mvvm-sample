package com.example.myapplication.model;

import androidx.room.TypeConverter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

public class SearchResultsConverter {
    @TypeConverter
    public static List<ShowResult> stringToShowResults(String json) {
        Gson gson = new Gson();
        Type type = new TypeToken<List<ShowResult>>() {}.getType();
        List<ShowResult> results = gson.fromJson(json, type);
        return results;
    }

    @TypeConverter
    public static String showResultsToString(List<ShowResult> results) {
        Gson gson = new Gson();
        Type type = new TypeToken<List<ShowResult>>() {}.getType();
        String json = gson.toJson(results, type);
        return json;
    }
}
