package com.example.mihai.tourguide;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ViewPager viewPager = findViewById(R.id.view_pager);
        SimpleFragmentPageAdapter adapter = new SimpleFragmentPageAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);
        TabLayout tabLayout = findViewById(R.id.sliding_tabs);
        tabLayout.setupWithViewPager(viewPager);
    }
}
