package edu.skku.swp3.straycat.Map;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import edu.skku.swp3.straycat.Map.CatListItem;
import edu.skku.swp3.straycat.R;

public class CatDataAdapter extends BaseAdapter{
    ArrayList<CatListItem> data;
    LayoutInflater inflater;

    public CatDataAdapter(LayoutInflater inflater, ArrayList<CatListItem> datas) {
        this.data= datas;
        this.inflater= inflater;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
       if(convertView == null){
           convertView = inflater.inflate(R.layout.layout_list_row, null);
           TextView text_name = (TextView) convertView.findViewById(R.id.text_name);
           TextView text_nation = (TextView) convertView.findViewById(R.id.text_place);
           ImageView img_cat = (ImageView) convertView.findViewById(R.id.img_flag);
           TextView text_species = (TextView) convertView.findViewById(R.id.text_species);

           text_name.setText(data.get(position).getCatName());
           text_nation.setText(data.get(position).getCatAddress());
           text_species.setText(data.get(position).getCatSpecies());
           img_cat.setImageResource(data.get(position).getImageResId());

       }
        return convertView;
    }


}
