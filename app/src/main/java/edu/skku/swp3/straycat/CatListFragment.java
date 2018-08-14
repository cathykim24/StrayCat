package edu.skku.swp3.straycat;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


public class CatListFragment extends Fragment {
    private RecyclerView recyclerViewCatList;
    private CatListAdapter adapter;


    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View catListView = inflater.inflate(R.layout.cat_list, container, false);
        recyclerViewCatList = catListView.findViewById(R.id.recycler_view_catlist);

        ArrayList<CatList> CatList = (ArrayList<CatList>) getArguments().getSerializable("catList");
        this.adapter = new CatListAdapter(CatList);



        recyclerViewCatList.setAdapter(adapter);
        recyclerViewCatList.setLayoutManager(new LinearLayoutManager(container.getContext()));
        CatList.add(new CatList(getResources().getIdentifier("cat_image1","drawable", getContext().getPackageName()),"성균관대 신관 A동 앞","러시안 블루"));


        return catListView;

    }
}