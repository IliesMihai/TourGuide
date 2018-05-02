package com.example.mihai.tourguide;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;


public class RestaurantFragment extends Fragment {

    public RestaurantFragment(){}

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.attraction_list, container, false);

        final ArrayList<Attraction> restaurants = new ArrayList<>();
        restaurants.add(new Attraction(R.string.bujole_restaurant_name,
                R.string.bujole_restaurant_description,
                R.string.bujole_restaurant_WH, R.string.bujole_restaurant_address,
                R.string.bujole_restaurant_website, R.drawable.bujole));

        restaurants.add(new Attraction(R.string.bricks_restaurant_name,
                R.string.bricks_restaurant_description,
                R.string.bricks_restaurant_WH, R.string.bricks_restaurant_address,
                R.string.bricks_restaurant_contact,
                R.string.bricks_restaurant_website, R.drawable.bricks));

        restaurants.add(new Attraction(R.string.roata_restaurant_name,
                R.string.roata_restaurant_description,
                R.string.roata_restaurant_WH, R.string.roata_restaurant_address,
                R.string.roata_restaurant_contact,
                R.string.roata_restaurant_website, R.drawable.roata));

        restaurants.add(new Attraction(R.string.klausen_restaurant_name,
                R.string.klausen_restaurant_description,
                R.string.klausen_restaurant_WH, R.string.klausen_restaurant_address,
                R.string.klausen_restaurant_contact,
                R.string.klausen_restaurant_website, R.drawable.klausen));

        restaurants.add(new Attraction(R.string.euphoria_restaurant_name,
                R.string.euphoria_restaurant_description,
                R.string.euphoria_restaurant_WH, R.string.euphoria_restaurant_address,
                R.string.euphoria_restaurant_website, R.drawable.euphoria));

        restaurants.add(new Attraction(R.string.via_restaurant_name,
                R.string.via_restaurant_description,
                R.string.via_restaurant_WH, R.string.via_restaurant_address,
                R.string.via_restaurant_contact,
                R.string.via_restaurant_website, R.drawable.via));

        restaurants.add(new Attraction(R.string.casamaramureseana_restaurant_name,
                R.string.casamaramureseana_restaurant_description,
                R.string.casamaramureseana_restaurant_WH,R.string.casamaramureseana_restaurant_address,
                R.string.casamaramureseana_restaurant_contact,
                R.string.casamaramureseana_restaurant_website, R.drawable.casam));


        AttractionAdapter adapter = new AttractionAdapter(getActivity(), restaurants);
        ListView listView = rootView.findViewById(R.id.list);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Attraction attraction = restaurants.get(position);
                Intent intent = new Intent(getActivity(), DetailView.class);
                Bundle bundle = new Bundle();
                bundle.putInt("NAME", attraction.getName());
                bundle.putInt("DESCRIPTION", attraction.getDescription());
                bundle.putInt("WORKHOURS", attraction.getWorkingHours());
                bundle.putInt("LOCATION", attraction.getLocation());
                bundle.putInt("WEBSITE", attraction.getWebsite());
                bundle.putInt("CONTACT", attraction.getContact());
                bundle.putInt("IMAGE", attraction.getImageResourceId());
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });

        return rootView;
    }
}
