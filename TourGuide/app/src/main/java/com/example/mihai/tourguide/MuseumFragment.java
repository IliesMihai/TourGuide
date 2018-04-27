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
        museum.add(new Attraction("Ethnographic Museum of Transylvania",
                "The Transylvanian Museum of Ethnography is situated in Cluj-Napoca, Romania. With a history of more than 80 years," +
                        " the Ethnographic Museum of Transylvania is one of the first and greatest of its kind in Romania.",
                "10AM-6PM", "Memorandumului Street 21, Cluj-Napoca 400114",
                "0264 592 344",
                "https://www.muzeul-etnografic.ro/en",
                R.drawable.etnograph));

        museum.add(new Attraction("National Museum of Transylvanian History",
                "The National Museum of Transylvanian History is a history and archaeology museum in the city of Cluj-Napoca, Romania.",
                "10AM-4PM", "Strada Constantin Daicoviciu 2, Cluj-Napoca",
                "0264 595 677",
                "http://www.mnit.ro/en/",
                R.drawable.nationalm));

        museum.add(new Attraction("Zoological Museum",
                "Established in 1859 as a Department of the Transylvanian Museum Association, " +
                        "the Zoological Museum now has over 300,000 exhibits. As a scientific value and by" +
                        " the number of preserved copies, the Zoological Museum ranks second, after the \"Gr. Antipa '' Bucharest.",
                "10AM-6PM", "Clinicilor Street 5-7, Cluj-Napoca",
                "0264 595 739",
                "https://www.welcometoromania.ro/Cluj/Cluj_Muzeul_Zoologic_e.htm",
                R.drawable.zoo));

        museum.add(new Attraction("Museum of Speleology Emil Racoviţă",
                "The “Emil Racoviţă” Speleology Museum was established in 1998, and it is the only museum in Romania" +
                        " dedicated to the scientist Emil Racoviţă and to the cave science.Emil Racoviţă is the founder " +
                        "of biospeleology and of the first Speleology institute in the world, which was opened in Cluj-Napoca in 1920.",
                "12AM-4PM", "Strada Sextil Pușcariu 8, Cluj-Napoca 400111",
                "0264 430 601",
                "http://www.visitclujnapoca.ro/en/atractii-turistice/muzee/the-emil-racovita-speleology-museum.html",
                R.drawable.emilracovita));

        museum.add(new Attraction("Ethnographic Park Romulus Vuia",
                "Heritage museum featuring an indoor pavilion & an outdoor park with traditional houses & structures.",
                "10AM-5PM", "Aleea Muzeului Etnografic, Cluj-Napoca",
                "http://www.visitclujnapoca.ro/en/atractii-turistice/muzee/the-romulus-vuia-national-ethnographic-park.html",
                R.drawable.vuia));

        museum.add(new Attraction("Bánffy Palace",
                "Fine art museum in a baroque building featuring works by major Romanian & Hungarian artists.",
                "10AM-5PM", "Piața Unirii 30, Cluj-Napoca",
                "0264 596 952",
                "http://www.visitclujnapoca.ro/en/atractii-turistice/muzee/the-art-museum-of-clujnapoca.html",
                R.drawable.banffy));

        museum.add(new Attraction("Cluj-Napoca Botanical Garden and Museum",
                "The Cluj-Napoca Botanical Garden, officially Alexandru Borza Cluj-Napoca University Botanic Garden," +
                        " is a botanical garden located in the south part of Cluj-Napoca, Romania. It was founded in 1872 by Brassai Samuel.",
                "8AM-8PM", "Strada Republicii 42, Cluj-Napoca 400015",
                "0264 592 152",
                "http://www.ubbcluj.ro/ro/structura/sport/gradina_botanica",
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
