package edu.skku.swp3.straycat.Feed;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;

import java.util.ArrayList;

import edu.skku.swp3.straycat.R;

public class CommentActivity extends AppCompatActivity {

    ArrayList<Comment> list = new ArrayList<>();
    ArrayList<Comment> listItem = new ArrayList<>();
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    CommentAdapter adapter;
    InputMethodManager imm;


    public ImageView input_comment_finished;

    EditText editText;
    String input_comment;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_view_comments);

        recyclerView  = (RecyclerView) findViewById(R.id.listView);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        editText = (EditText)findViewById(R.id.input_comment);
        input_comment_finished = (ImageView) findViewById(R.id.ivPostComment);
        imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);


        listItem.add(new Comment("진짜 저게 생명첸가......ㅠㅠ 졸귀", "khe49260", "4분 전", R.drawable.aa));
        listItem.add(new Comment("헐 이 주변에 이렇게 귀여운 고양이가 있어요?", "9967han", "16분 전", R.drawable.bb));
        listItem.add(new Comment("맞팔해요~!!! 냥이 맘입니다\n", "hyewoni11", "1일 전", R.drawable.cc));

        adapter = new CommentAdapter(listItem);
        recyclerView.setAdapter(adapter);

        setData();

        input_comment_finished.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addData();
            }
        });

    }

    private void setData(){
        list.clear();
        for(Comment comment : listItem){
            list.add(comment);
        }
        adapter.notifyDataSetChanged();
    }

    public void addData(){
        input_comment = editText.getText().toString();
        listItem.add(new Comment(input_comment, "hyewonnii","방금",R.drawable.dd));
        adapter.notifyDataSetChanged();
        editText.setText(null);
        hideKeyboard();
    }

    private void hideKeyboard()
    {
        imm.hideSoftInputFromWindow(editText.getWindowToken(), 0);
    }

}
