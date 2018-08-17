package edu.skku.swp3.straycat.Map;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.Marker;

import edu.skku.swp3.straycat.R;

public class CustomInfoWindowAdapter implements GoogleMap.InfoWindowAdapter {

    private Activity context;

    public CustomInfoWindowAdapter(Activity context){
        this.context = context;
    }

    @Override
    public View getInfoWindow(Marker marker) {
        return null;
    }

    @Override
    public View getInfoContents(Marker marker) {
        View view = context.getLayoutInflater().inflate(R.layout.item_infowindow, null);


        TextView tvcatNumber = (TextView) view.findViewById(R.id.tv_cat_number);
        TextView tvcatPicture = (TextView) view.findViewById(R.id.tv_cat_picture);

        tvcatNumber.setText(marker.getTitle());
        tvcatPicture.setText(marker.getSnippet());

        return view;
    }

}
