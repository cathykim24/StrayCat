package edu.skku.swp3.straycat.Feed;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;

import edu.skku.swp3.straycat.R;

public class PostFragment extends Fragment {

    ArrayList<PostItem> list = new ArrayList<>();
    ArrayList<PostItem> listItem = new ArrayList<>();
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    PostAdapter adapter;
    ImageView comment;
    int idx = 0;

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

        event();

    }
    private void event(){
        this.idx = this.idx +1;
        Log.d("여기",String.valueOf(this.idx));
        if(this.idx == 1){
            final Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    do {
                        addData("성대에서 길냥이를 만났어요");
                        Log.d("postfragment","들어왔다");
                        break;
                    }while (true);
                }
            }, 20000);
        }

    }
    private void setData(){
        list.clear();
        for(PostItem postItem : listItem){
            list.add(postItem);
        }
        adapter.notifyDataSetChanged();
    }

    public void addData(String caption){
        listItem.add(0,new PostItem(false, 0, "hyewonnii", R.drawable.cat_image111,
                caption, "hyewonnii", R.drawable.cc));
        adapter.notifyDataSetChanged();
    }

}
