package com.example.myapplication.views;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.model.ShowResult;
import com.example.myapplication.model.ShowResultsList;
import com.example.myapplication.viewmodel.SearchResultsViewModel;
import com.example.myapplication.views.adapters.ShowListAdapter;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private EditText searchBox;
    private Button searchButton;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private SearchResultsViewModel vm;
    private LiveData<ShowResultsList> resultsLiveData;
    private List<ShowResult> results;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        if (ContextCompat.checkSelfPermission(this, Manifest.permission.INTERNET)
                != PackageManager.PERMISSION_GRANTED) {
            // Permission is not granted
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.INTERNET}, 1);
        }

        vm = ViewModelProviders.of(MainActivity.this).get(SearchResultsViewModel.class);
        searchBox = findViewById(R.id.search_et);
        recyclerView = findViewById(R.id.list_rv);
        searchButton = findViewById(R.id.search_button);
        resultsLiveData = vm.init();

        resultsLiveData.observe(this, res -> {
            results = res.getSearch();
            setData();
        });


        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String query = searchBox.getText().toString();
                vm.getSearchResults(query);

            }
        });
    }

    private void setData() {
        if (results != null) {
            mAdapter.notifyDataSetChanged();
        }
         else {
            ShowListAdapter mAdapter = new ShowListAdapter(results);
            recyclerView.setAdapter(mAdapter);
        }
    }
}
