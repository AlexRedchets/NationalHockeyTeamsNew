package com.azvk.nationalhockeyteams.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.azvk.nationalhockeyteams.fragments.RostersFragment;
import com.azvk.nationalhockeyteams.fragments.TeamInfoFragment;

public class ViewPagerAdapter extends FragmentPagerAdapter {

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){

            case 0:
                return TeamInfoFragment.newInstance();
            case 1:
                return RostersFragment.newInstance();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 2;
    }

    // Returns the page title for the top indicator
    @Override
    public CharSequence getPageTitle(int position) {
        if (position==0)
            return "INFORMATION";
        else
            return "PLAYERS";
    }
}
