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


public class GymFragment extends Fragment {

    public GymFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.attraction_list, container, false);

        final ArrayList<Attraction> gym = new ArrayList<>();

        gym.add(new Attraction(R.string.evolve_gym_name,
                R.string.evolve_gym_description,
                R.string.evolve_gym_WH, R.string.evolve_gym_address,
                R.string.evolve_gym_contact,
                R.string.evolve_gym_website,
                R.drawable.evolve));

        gym.add(new Attraction(R.string.gimmy_gym_name,
                R.string.gimmy_gym_description,
                R.string.gimmy_gym_WH, R.string.gimmy_gym_address,
                R.string.gimmy_gym_contact,
                R.string.gimmy_gym_website,
                R.drawable.gimmy));

        gym.add(new Attraction(R.string.t_gym_name,
                R.string.t_gym_description,
                R.string.t_gym_WH, R.string.t_gym_address,
                R.string.t_gym_contact,
                R.string.t_gym_website,
                R.drawable.tgym));

        gym.add(new Attraction(R.string.olympus_gym_name,
                R.string.olympus_gym_description,
                R.string.olympus_gym_WH, R.string.olympus_gym_address,
                R.string.olympus_gym_contact,
                R.string.olympus_gym_website,
                R.drawable.olympus));

        gym.add(new Attraction(R.string.bigfitness_gym_name,
                R.string.bigfitness_gym_descritpion,
                R.string.bigfitness_gym_WH, R.string.bigfitness_gym_address,
                R.string.bigfitness_gym_contact,
                R.string.bigfitness_gym_website,
                R.drawable.bigfitness));

        gym.add(new Attraction(R.string.expressfitness_gym_name,
                R.string.expressfitness_gym_description,
                R.string.expressfitness_gym_WH, R.string.expressfitness_gym_address,
                R.string.expressfitness_gym_contact,
                R.string.expressfitness_gym_website,
                R.drawable.expressfitness));

        gym.add(new Attraction(R.string.eighteengym_gym_name,
                R.string.eighteengym_gym_description,
                R.string.eighteengym_gym_WH, R.string.eighteengym_gym_address,
                R.string.eighteengym_gym_contact,
                R.string.eighteengym_gym_webiste,
                R.drawable.eigthteengym));

        AttractionAdapter adapter = new AttractionAdapter(getActivity(), gym);
        ListView listView = rootView.findViewById(R.id.list);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Attraction attraction = gym.get(position);
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

