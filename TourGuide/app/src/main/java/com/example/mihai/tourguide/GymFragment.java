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

        gym.add(new Attraction("Evolve Fitness Club",
                "Visit our website for more details",
                "7AM-10PM", "Strada Plopilor 72, Cluj-Napoca 400000",
                "0364 407 227",
                "https://evolve-fitness.ro/?gclid=CjwKCAjwlIvXBRBjEiwATWAQInS4oVctM4vJJ1sjoC5OFUb1FBIThZ1h3B8E8HKspuugWKrbkei0ghoCxk0QAvD_BwE",
                R.drawable.evolve));

        gym.add(new Attraction("Gimmy Gym",
                "Visit our website for more details",
                "7AM-11PM", "Strada Nicolae Pascaly, Cluj-Napoca",
                "0734 417 777",
                "http://www.gimmy.ro/",
                R.drawable.gimmy));

        gym.add(new Attraction("T Gym",
                "Visit our website for more details",
                "8AM-11PM", "Strada Mikó Imre 13, Cluj-Napoca 400499",
                "0752 925 031",
                "http://tgym.ro/",
                R.drawable.tgym));

        gym.add(new Attraction("Olympus Center",
                "Visit our website for more details",
                "7AM-10PM", "Strada Victor Babeș 33, Cluj-Napoca 400012",
                "0364 116 039",
                "http://www.olympuscenter.ro/",
                R.drawable.olympus));

        gym.add(new Attraction("Big Fitness",
                "Visit our website for more details",
                "6AM-11PM", "Bucegi St, Cluj-Napoca",
                "0735 890 000",
                "http://www.bigfitness.ro/",
                R.drawable.bigfitness));

        gym.add(new Attraction("Express Fitness",
                "Visit our website for more details",
                "8AM-10PM", "Strada Baba Novac 26A, Cluj-Napoca 400080",
                "0753 513 560",
                "http://www.express-fitness.ro/",
                R.drawable.expressfitness));

        gym.add(new Attraction("18 Gym",
                "Visit our website for more details",
                "7AM-10PM", "Bulevardul Nicolae Titulescu 2, Cluj-Napoca 400000",
                "0753 609 943",
                "http://cluj.18gym.ro/",
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
                bundle.putString("NAME", attraction.getName());
                bundle.putString("DESCRIPTION", attraction.getDescription());
                bundle.putString("WORKHOURS", attraction.getWorkingHours());
                bundle.putString("LOCATION", attraction.getLocation());
                bundle.putString("WEBSITE", attraction.getWebsite());
                bundle.putString("CONTACT", attraction.getContact());
                bundle.putInt("IMAGE", attraction.getImageResourceId());
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });

        return rootView;
    }
}

