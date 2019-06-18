package com.example.myapplication.model.repository;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.LiveData;

import com.example.myapplication.model.ShowResultsDatabase;
import com.example.myapplication.model.ShowResultsList;
import com.example.myapplication.model.ShowResultsListDAO;
import com.example.myapplication.model.api.ApiConfiguration;
import com.example.myapplication.model.api.ShowWebService;

import java.util.concurrent.Executor;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ShowRepository {

    Context context;
    Executor executor;
    private static ShowRepository showRepository;
    private final ShowWebService webService;
    private final ShowResultsList resultsList;
    private final ShowResultsListDAO resultsDAO;

    public ShowRepository(@NonNull Context context) {
        this.context = context;
        this.webService = ApiConfiguration.getRetrofitClient(ShowWebService.class);
        this.resultsList = new ShowResultsList();
        ShowResultsDatabase db = ShowResultsDatabase.getInstance(context);
        resultsDAO = db.resultsDAO();
    }

    public LiveData<ShowResultsList> getSearchResults(final String query) {
        //create new thread for retrofit operation
        //volley creates its own thread and retries
        Call<ShowResultsList> call = webService.getSearchResults(query);
        call.enqueue(new Callback<ShowResultsList>() {
            @Override
            public void onResponse(Call<ShowResultsList> call, Response<ShowResultsList> response) {
                Toast.makeText(context, "Data refreshed from network !", Toast.LENGTH_LONG).show();
                ShowResultsList results = response.body();
                results.setSearchQuery(query);
                resultsDAO.save(results);
            }

            @Override
            public void onFailure(Call<ShowResultsList> call, Throwable t) {
                Toast.makeText(context, "Something went wrong.", Toast.LENGTH_LONG).show();
            }
        });
        LiveData<ShowResultsList> temp = resultsDAO.load(query);
        return temp;
    }
}
