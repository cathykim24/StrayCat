package edu.skku.swp3.straycat;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.view.View;

import java.util.ArrayList;

public class TagCatActivity extends AppCompatActivity {

    private ListView listView;
    private TabActivity tabActivity;

    public ArrayList<CatListItem> catList = new ArrayList<CatListItem>();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tag_cat);

        listView = (ListView) findViewById(R.id.lv_tag_cat);

        catList.add(new CatListItem(R.drawable.cat_image1,"성균관대 신관 A동 앞","러시안 블루","나비"));
        catList.add(new CatListItem(R.drawable.cat_image2,"호매실도서관 앞","터키쉬 앙고라","디도냥이"));

        CatDataAdapter adapter = new CatDataAdapter(getLayoutInflater(), catList);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent returnIntent = new Intent();
                returnIntent.putExtra("result", catList.get(position).getCatName().toString());
                setResult(Activity.RESULT_OK,returnIntent);
                finish();
            }
        });




    }

}