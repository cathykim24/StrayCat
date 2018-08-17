package edu.skku.swp3.straycat.Map;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

import edu.skku.swp3.straycat.R;

public class CatListActivity extends AppCompatActivity {
    private RecyclerView recyclerViewCatList;
    private CatListAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cat_list);
        recyclerViewCatList = findViewById(R.id.recycler_view_catlist);
        ArrayList<CatListItem> catListItem = (ArrayList<CatListItem>) getIntent().getSerializableExtra("catList");
        this.adapter = new CatListAdapter(catListItem);
        recyclerViewCatList.setAdapter(adapter);
        recyclerViewCatList.setLayoutManager(new LinearLayoutManager(this));
    }
}