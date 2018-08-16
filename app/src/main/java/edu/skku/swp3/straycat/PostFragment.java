package edu.skku.swp3.straycat;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class PostFragment extends Fragment {

    ArrayList<PostItem> list = new ArrayList<>();
    ArrayList<PostItem> listItem = new ArrayList<>();
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    PostAdapter adapter;
    ImageView comment;

    Context context;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){
        return inflater.inflate(R.layout.feed_layout, container, false);
    }
    @Override
    public void onStart(){

        super.onStart();

        context = getActivity();
        comment = (ImageView) getView().findViewById(R.id.speech_bubble);

        recyclerView  = (RecyclerView) getView().findViewById(R.id.rv_list);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);


        listItem.add(new PostItem(false, 125, "khe49260", R.drawable.a,
                "심쿵...............<3","khe49260", R.drawable.aa));
        listItem.add(new PostItem(false, 273, "9967han", R.drawable.b,
                "뒤집기!!!!!","9967han", R.drawable.bb));
        listItem.add(new PostItem(false, 314, "hyewoni11", R.drawable.c,
                "길고양이에 대한 궁금증을 풀어드립니다!", "hyewoni11", R.drawable.cc));
        listItem.add(new PostItem(false, 352, "taegeunjjang", R.drawable.d,
                " 엉엉 귀여워", "taegeunjjang", R.drawable.dd));

        adapter = new PostAdapter(listItem, context);
        recyclerView.setAdapter(adapter);

        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            int idx = 0;

            @Override
            public void run() {
                if(idx == 0){
                    addData("성대에서 길냥이를 만났어요");
                    idx = idx + 1;
                }
            }
        }, 10000);

    }
    private void setData(){
        list.clear();
        for(PostItem postItem : listItem){
            list.add(postItem);
        }
        adapter.notifyDataSetChanged();
    }

    public void addData(String caption){
        listItem.add(0,new PostItem(false, 0, "hyewonnii", R.drawable.cat_image1_wide,
                caption, "hyewonnii", R.drawable.cc));
        adapter.notifyDataSetChanged();
    }

}
