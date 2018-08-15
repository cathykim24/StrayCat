package edu.skku.swp3.straycat;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class PostActivity extends AppCompatActivity {
    ArrayList<PostItem> list = new ArrayList<>();
    ArrayList<PostItem> listItem = new ArrayList<>();
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    PostAdapter adapter;


    @Override
    protected void onCreate(Bundle bundle){
        super.onCreate(bundle);
        setContentView(R.layout.feed_layout);

        recyclerView  = (RecyclerView) findViewById(R.id.rv_list);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);


        listItem.add(new PostItem(false, 125, "khe49260", R.drawable.a,
                        "심쿵...............<3","khe49260", R.drawable.aa));
        listItem.add(new PostItem(false, 273, "9967han", R.drawable.b,
                "뒤집기!!!!!","9967han", R.drawable.bb));
        listItem.add(new PostItem(false, 314, "hyewoni11", R.drawable.c,
                "길고양이에 대한 궁금증을 풀어드립니다!", "hyewoni11", R.drawable.cc));
        listItem.add(new PostItem(false, 352, "taegeunjjang", R.drawable.d,
                " 엉엉 귀여워", "taegeunjjang", R.drawable.dd));

        adapter = new PostAdapter(listItem);
        recyclerView.setAdapter(adapter);

        //        for(PostItem item4 : listItem){
//            View view = View.inflate(this, R.layout.post_item, null);
//            TextView tvUserName = (TextView) view.findViewById(R.id.username);
//            TextView tvPostText = view.findViewById(R.id.posttext);
//
//            tvUserName.setText(item4.getUsername());
//            tvPostText.setText(item4.getPostText());
//        }

//        View.inflate(this, R.layout.post_item, null);
            setData();
    }

    private void setData(){
        list.clear();
        for(PostItem postItem : listItem){
            list.add(postItem);
        }
        adapter.notifyDataSetChanged();
    }
}
