package com.example.mihai.tourguide;

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

public class MuseumFragment extends Fragment {

    public MuseumFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.attraction_list, container, false);

        final ArrayList<Attraction> museum = new ArrayList<>();
        museum.add(new Attraction(R.string.etnographic_museum_name,
                R.string.etnographic_museum_description,
                R.string.etnographic_museum_WH, R.string.etnographic_museum_address,
                R.string.etnographic_museum_contact,
                R.string.etnographic_museum_website,
                R.drawable.etnograph));

        museum.add(new Attraction(R.string.national_museum_name,
                R.string.national_museum_description,
                R.string.national_museum_WH, R.string.national_museum_address,
                R.string.national_museum_contact,
                R.string.national_museum_website,
                R.drawable.nationalm));

        museum.add(new Attraction(R.string.zoological_museum_name,
                R.string.zoological_museum_description,
                R.string.zoological_museum_WH, R.string.zoological_museum_address,
                R.string.zoological_museum_contact,
                R.string.zoological_museum_website,
                R.drawable.zoo));

        museum.add(new Attraction(R.string.speleology_museum_name,
                R.string.speleology_museum_description,
                R.string.speleology_museum_WH, R.string.speleology_museum_address,
                R.string.speleology_museum_contact,
                R.string.speleology_museum_website,
                R.drawable.emilracovita));

        museum.add(new Attraction(R.string.etnographicpark_museum_name,
                R.string.etnographicpark_museum_description,
                R.string.etnographicpark_museum_WH, R.string.etnographicpark_museum_address,
                R.string.etnographicpark_museum_website,
                R.drawable.vuia));

        museum.add(new Attraction(R.string.banffy_palace_name,
                R.string.banffy_palace_description,
                R.string.banffy_palace_WH, R.string.banffy_palace_address,
                R.string.banffy_palace_contact,
                R.string.banffy_palace_website,
                R.drawable.banffy));

        museum.add(new Attraction(R.string.botanical_garden_name,
                R.string.botanical_garden_description,
                R.string.botanical_garden_WH, R.string.botanical_garden_address,
                R.string.botanical_garden_contact,
                R.string.botanical_garden_website,
                R.drawable.botanical));


        AttractionAdapter adapter = new AttractionAdapter(getActivity(), museum);
        ListView listView = rootView.findViewById(R.id.list);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Attraction attraction = museum.get(position);
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
