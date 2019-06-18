package com.example.myapplication.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.myapplication.model.ShowResultsList;
import com.example.myapplication.model.repository.ShowRepository;

public class SearchResultsViewModel extends AndroidViewModel {

    private ShowRepository showRepository;
    private LiveData<ShowResultsList> data = new MutableLiveData<>();;

    public SearchResultsViewModel(@NonNull Application application) {
        super(application);
        showRepository = new ShowRepository(application.getApplicationContext());
    }

    public LiveData<ShowResultsList> init() {
        return data;
    }

    public void getSearchResults(String query) {
        data = showRepository.getSearchResults(query);
    }
}
