package com.example.mihai.tourguide;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class SimpleFragmentPageAdapter extends FragmentPagerAdapter {

    private String tabTitle[] = {"Restaurant", "Gym", "Coffee Shop", "Museum"};
    private Context context;

    public SimpleFragmentPageAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
        this.context = context;
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new RestaurantFragment();
        } else if (position == 1) {
            return new GymFragment();
        } else if (position == 2) {
            return new CoffeeShopFragment();
        } else {
            return new MuseumFragment();
        }
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return tabTitle[position];
    }
}
