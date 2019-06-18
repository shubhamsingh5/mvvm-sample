package com.example.myapplication.model;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

@Entity
public class ShowResultsList {

    @PrimaryKey (autoGenerate = true)
    @NonNull
    private int id;

    @SerializedName("Search")
    @Expose
    @TypeConverters(SearchResultsConverter.class)
    private List<ShowResult> search = null;

    @Ignore
    @SerializedName("totalResults")
    @Expose
    private String totalResults;

    @Ignore
    @SerializedName("Response")
    @Expose
    private String response;

    private String searchQuery;

    public List<ShowResult> getSearch() {
        return search;
    }

    public void setSearch(List<ShowResult> search) {
        this.search = search;
    }

    public String getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(String totalResults) {
        this.totalResults = totalResults;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    @NonNull
    public int getId() {
        return id;
    }

    public void setId(@NonNull int id) {
        this.id = id;
    }

    public String getSearchQuery() {
        return searchQuery;
    }

    public void setSearchQuery(String searchQuery) {
        this.searchQuery = searchQuery;
    }
}
