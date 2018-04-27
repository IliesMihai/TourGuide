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
        coffeeShop.add(new Attraction("Fuel Coffee Shop",
                "We are committed to perfectly caffeinating each customer with the highest quality coffee and" +
                        " to redefine the standards of customer service in a unique, friendly, and comfortable atmosphere.",
                "7AM-4PM", "Calea Moților 37, Cluj-Napoca 400000",
                "http://www.fuelcoffeeseattle.com/",
                R.drawable.fuel));

        coffeeShop.add(new Attraction("ROOTS",
                "Being such a small place, it’s comfortable and cozy, yet on crowded mornings you might" +
                        " feel you’ve overstayed and it’s time for you to let others enjoy the place." +
                        " Mornings are sprinkled with coffee and pastry smells, while during evenings Roots becomes a genuine wine bar." +
                        " It’s a pity to stretch your brains on a such relaxing time of the day, so don’t even attempt to do so.",
                "7:30AM-10PM", "Bulevardul Eroilor 4, Cluj-Napoca 400000",
                "https://www.facebook.com/roots.tastery/",
                R.drawable.roots));

        coffeeShop.add(new Attraction("Let's Coffee",
                "Good coffee for good people",
                "7:30AM-6PM", "Strada Constantin Daicoviciu, Cluj-Napoca 400020",
                "https://www.facebook.com/letscoffeecluj/",
                R.drawable.letscoffee));

        coffeeShop.add(new Attraction("Tucano Coffee Puerto Rico",
                "The delicacy of roses, smoothly combined with a flavorous espresso and the softness of milk for an unforgettable love feeling.",
                "8AM-10PM", "Bulevardul Eroilor 19, Cluj-Napoca 400000",
                "https://tucanocoffee.com/en/",
                R.drawable.tucano));

        coffeeShop.add(new Attraction("Meron",
                "Welcome to our home of coffee!",
                "8AM-9PM", "Strada Napoca 3, Cluj-Napoca 900329",
                "http://meron.coffee/",
                R.drawable.meron));

        coffeeShop.add(new Attraction("Coffee Addicts",
                "'cause nothing else truly matters when you wake up",
                "7:30AM-6:30PM", "Strada Regele Ferdinand 9, Cluj-Napoca 400000",
                "https://www.facebook.com/CoffeeAddictsToGo/",
                R.drawable.coffeeaddicts));

        coffeeShop.add(new Attraction("Cafe Mozart",
                "The taste of coffee as you never tasted it before",
                "9AM-10PM", "Strada Cardinal Iuliu Hossu, Cluj Napoca 400029",
                "https://www.facebook.com/mozartdelicatesse/",
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
