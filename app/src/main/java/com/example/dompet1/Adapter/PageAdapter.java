package com.example.dompet1.Adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.dompet1.ArtikelTablayout;
import com.example.dompet1.BeritaTablayout;
import com.example.dompet1.DonaturTablayout;

public class PageAdapter extends FragmentPagerAdapter {

    int numoftabs;


    public PageAdapter(FragmentManager fm, int numOfTabs) {
        super(fm);
        this.numoftabs = numOfTabs;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position){
            case 0:
            return new ArtikelTablayout();

            case 1:
                return new BeritaTablayout();

            case 2:
                return new DonaturTablayout();

                default:
                    return null;
        }

    }

    @Override
    public int getCount() {
        return numoftabs;
    }

    @Override
    public int getItemPosition(@NonNull Object object) {
        return POSITION_NONE;
    }
}
