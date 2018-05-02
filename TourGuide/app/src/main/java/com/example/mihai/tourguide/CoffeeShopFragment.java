package com.example.mihai.tourguide;


import android.content.Intent;
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


public class CoffeeShopFragment extends Fragment {

    public CoffeeShopFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.attraction_list, container, false);

        final ArrayList<Attraction> coffeeShop = new ArrayList<>();
        coffeeShop.add(new Attraction(R.string.fuel_coffee_name,
                R.string.fuel_coffee_description,
                R.string.fuel_coffee_WH, R.string.fuel_coffee_address,
                R.string.fuel_coffee_website,
                R.drawable.fuel));

        coffeeShop.add(new Attraction(R.string.roots_coffee_name,
                R.string.roots_coffee_description,
                R.string.roots_coffee_WH, R.string.roots_coffee_address,
                R.string.roots_coffee_website,
                R.drawable.roots));

        coffeeShop.add(new Attraction(R.string.lets_coffee_name,
                R.string.lets_coffee_description,
                R.string.lets_coffee_WH, R.string.lets_coffee_address,
                R.string.lets_coffee_website,
                R.drawable.letscoffee));

        coffeeShop.add(new Attraction(R.string.tucaon_coffee_name,
                R.string.tucaon_coffee_description,
                R.string.tucaon_coffee_WH, R.string.tucaon_coffee_address,
                R.string.tucaon_coffee_website,
                R.drawable.tucano));

        coffeeShop.add(new Attraction(R.string.meron_coffee_name,
                R.string.meron_coffee_description,
                R.string.meron_coffee_WH, R.string.meron_coffee_address,
                R.string.meron_coffee_website,
                R.drawable.meron));

        coffeeShop.add(new Attraction(R.string.addicts_coffee_name,
                R.string.addicts_coffee_description,
                R.string.addicts_coffee_WH, R.string.addicts_coffee_address,
                R.string.addicts_coffee_website,
                R.drawable.coffeeaddicts));

        coffeeShop.add(new Attraction(R.string.mozart_coffee_name,
                R.string.mozart_coffee_description,
                R.string.mozart_coffee_WH, R.string.mozart_coffee_address,
                R.string.mozart_coffee_website,
                R.drawable.cafemozart));

        AttractionAdapter adapter = new AttractionAdapter(getActivity(), coffeeShop);
        ListView listView = rootView.findViewById(R.id.list);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Attraction attraction = coffeeShop.get(position);
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
