package com.example.mihai.tourguide;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailView extends AppCompatActivity {

    ImageView imageView;
    TextView descriptionTxt, workHoursTxt, locationTxt, contactTxt, nameTxt;
    int name, description, workHour, location, contact, website, imageResource;

    @SuppressLint("RestrictedApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_view);

        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);

        Bundle bundle = getIntent().getExtras();

        if (bundle != null) {
            name = bundle.getInt("NAME");
            description = bundle.getInt("DESCRIPTION");
            workHour = bundle.getInt("WORKHOURS");
            location = bundle.getInt("LOCATION");
            contact = bundle.getInt("CONTACT");
            website = bundle.getInt("WEBSITE");
            imageResource = bundle.getInt("IMAGE");
        }

        nameTxt = findViewById(R.id.list_item_name);
        nameTxt.setText(name);

        imageView = findViewById(R.id.attraction_image);
        imageView.setImageResource(imageResource);

        descriptionTxt = findViewById(R.id.attraction_description);
        descriptionTxt.setText(description);

        workHoursTxt = findViewById(R.id.attraction_workHours);
        workHoursTxt.setText(workHour);

        locationTxt = findViewById(R.id.attraction_locationa);
        locationTxt.setText(location);

        contactTxt = findViewById(R.id.attraction_contact);
        if (contact != 0) {
            contactTxt.setText(contact);
        } else {
            contactTxt.setVisibility(View.GONE);
        }

    }

    public void goToAddress(View view) {

        TextView textView = findViewById(R.id.attraction_locationa);
        String address = "geo:0,0?q=" + textView.getText().toString();

        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(address));
        intent.setPackage("com.google.android.apps.maps");
        startActivity(intent);
        finish();
    }

    public void makeCall(View view) {

        TextView textView = findViewById(R.id.attraction_contact);
        String phoneNumber = "tel:" + textView.getText().toString();

        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse(phoneNumber));
        startActivity(intent);
        finish();

    }

    public void accessWebSite(View view) {

        String url = getString(website);

        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(url));
        startActivity(intent);
        finish();
    }
}
