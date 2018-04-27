package com.example.mihai.tourguide;

import android.app.Activity;
import android.content.Context;
import android.media.Image;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class AttractionAdapter extends ArrayAdapter<Attraction> {

    public AttractionAdapter(Activity context, ArrayList<Attraction> attractions) {
        super(context, 0, attractions);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;

        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }

        final Attraction currentAttraction = getItem(position);

        TextView itemName = listItemView.findViewById(R.id.list_item_name);
        itemName.setText(currentAttraction.getName());

        ImageView image = listItemView.findViewById(R.id.list_image);
        image.setImageResource(currentAttraction.getImageResourceId());

        return listItemView;
    }
}
