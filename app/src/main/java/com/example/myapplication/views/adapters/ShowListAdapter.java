package com.example.myapplication.views.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

//import because not in main package
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.model.ShowResult;
import java.util.List;

public class ShowListAdapter extends RecyclerView.Adapter<ShowListAdapter.MyViewHolder> {

    private final List<ShowResult> showList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title, year;

        public MyViewHolder(View view) {
            super(view);
            title = view.findViewById(R.id.name);
            year = view.findViewById(R.id.description);
        }
    }

    public ShowListAdapter(List<ShowResult> showList) {
        this.showList = showList;
    }

    //layoutinflater converts xml to java
    @Override
    public ShowListAdapter.MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.list_item, viewGroup, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ShowListAdapter.MyViewHolder myViewHolder, int i) {
        ShowResult show = showList.get(i);
        myViewHolder.title.setText(show.getTitle());
        // TODO use glide to do image stuff
        myViewHolder.year.setText(show.getYear());
    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
