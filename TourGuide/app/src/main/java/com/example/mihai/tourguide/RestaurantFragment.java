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
        restaurants.add(new Attraction("BUJOLE",
                "Bujole is the place where you can eat great food in a comfortable home-like environment. " +
                        "Located in the very heart of the city, Bujole is a cosy French restaurant with a unique design and a friendly staff. " +
                        "The menu features onion soup, truffles and artichoke pasta, beef bourgignon, chicken with caramelised " +
                        "vegetables and desserts such as coffee cake and raspberry risotto. Whether you choose to have a great-quality " +
                        "coffee in the morning to start your day, enjoy a French meal for lunch or get together with friends for cocktails " +
                        "and homemade beer in the evening, you won’t go wrong.",
                "8AM-11PM", "Piața Unirii 15, Cluj-Napoca 400000",
                "http://www.bujole.com/", R.drawable.bujole));

        restaurants.add(new Attraction("BRICKS (M)EATING POINT",
                "How about eating your meal on a suspended terrace? Bricks (M)eating Point is the only terrace in Cluj " +
                        "where you can eat above the Somes River. The venue features a restaurant, terrace and a ‘Wine & Jazz Lounge’." +
                        " Bricks’ dishes are made with fresh ingredients and are completed by a wide selection of wines. " +
                        "Moreover, in the Wine & Jazz Lounge, you can enjoy live music too. During the week, there is a daily menu " +
                        "for lunch at a reasonable price.",
                "11AM-12PM", "Strada Horea 2, Cluj-Napoca 400038",
                "0364 730 615",
                "http://www.bricksrestaurant.ro/en", R.drawable.bricks));

        restaurants.add(new Attraction("ROATA",
                "Roata is a traditional restaurant serving Romanian dishes, designed like a traditional house. " +
                        "At Roata, every meal starts with a small glass of plum brandy tuica, the traditional Romanian drink. " +
                        "Drink it just before you start eating and make sure you have a glass of water nearby, as it’s pretty potent!" +
                        " Then, taste the authentic local cuisine: cabbage rolls stuffed with meat (sarmale), polenta with cheese," +
                        " goulash or cabbage à la Cluj. Leave some space for dessert, as the papanasi (fried pastry filled with cheese and jam) " +
                        "are a must.",
                "10AM-11PM", "Strada Alexandru Ciurea 6, Cluj-Napoca",
                "0264 592 022",
                "http://restaurant-roata.ro/", R.drawable.roata));

        restaurants.add(new Attraction("KLAUSEN BURGER",
                "A great meal is always better when it comes with a beautiful view. Klausen Burger terrace has them both. " +
                        "Found on the rooftop of Central Commercial Center, Klausen Burger has both an inside restaurant and an outdoor " +
                        "terrace on top of it. If you are a gourmand, then this restaurant is made for you, as the portions are abundant. " +
                        "From soups to burgers, the restaurant includes both traditional, Italian and American cuisine, and there are options for" +
                        " vegetarians too. For a good meal or if you just want to have a drink while enjoying the panoramic view over Cluj, " +
                        "Klausen Burger is an ",
                "10AM-2PM", "Strada Ferdinand 22, Cluj-Napoca 400000",
                "Contact",
                "http://klausenburger.ro/", R.drawable.klausen));

        restaurants.add(new Attraction("EUPHORIA BIERGARTEN",
                "One of the most popular terraces in the city during summer, Euphoria Biergarten offers a broad range of" +
                        " dishes influenced by international and Transylvanian cuisine. Perhaps you’d like to try a fancy dish such " +
                        "as duck duo with Porto sauce, or a more traditional one like barbeque pork ribs, you will love the food from" +
                        " the second you see it. And if you have a sweet tooth, try the delicious chocolate soufflé for dessert and" +
                        " order their fresh rose lemonade.",
                "8AM-2PM", "Strada Cardinal Iuliu Hossu 25, Cluj-Napoca 400000",
                "http://euphoria.ro/index.php/biergarten-cluj", R.drawable.euphoria));

        restaurants.add(new Attraction("VIA RESTAURANT",
                "Hidden in one of the pedestrian streets of Cluj and surrounded by the old walls of the medieval citadel, " +
                        "VIA Restaurant has an exceptional location in a baroque palace. As the restaurant is highly appreciated" +
                        " for its exquisite dishes, reservations are advisable. Some of the plates that you can choose from include" +
                        " foie gras and tandoori prawns for starters, shrimp soup, braised ox cheek or duck breast for the main dish" +
                        " and crème brûlée or mojito mousse for dessert.",
                "12PM-12AM", "Strada Inocențiu Micu Klein 6, Cluj-Napoca 400087",
                "033 060 666",
                "http://www.viarestaurant.ro/", R.drawable.via));

        restaurants.add(new Attraction("CASA MARAMURESEANA",
                "If there is a word that defines the Casa Maramureseana, that is traditional: traditional meals," +
                        " traditional decorations and waiters wearing traditional clothing. It’s the perfect place to" +
                        " experience the cuisine from Maramures, one of the few regions of the country where modern technology" +
                        " hasn’t taken over old customs. If you want to follow the maramuresean way of eating, serve a soup before" +
                        " the main dish. Luckily, there are plenty of options, so you will find one that fits your taste. " +
                        "If you’re not sure what to try, just let yourself be surprised by Romanian cuisine!",
                "9AM-12PM","Bulevardul 21 Decembrie 1989 82, Cluj-Napoca 400124",
                "0725 578 508",
                "http://casa-maramureseana.ro/", R.drawable.casam));


        AttractionAdapter adapter = new AttractionAdapter(getActivity(), restaurants);
        ListView listView = rootView.findViewById(R.id.list);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Attraction attraction = restaurants.get(position);
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
