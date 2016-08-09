package com.azvk.nationalhockeyteams.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ViewFlipper;

import com.azvk.nationalhockeyteams.R;
import com.azvk.nationalhockeyteams.adapters.ViewPagerAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TeamDescriptionFragment extends Fragment{

    @BindView(R.id.view_pager)
    ViewPager viewPager;
    @BindView(R.id.view_flipper)
    ViewFlipper viewFlipper;
    FragmentPagerAdapter fragmentPagerAdapter;

    public TeamDescriptionFragment() {}

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_team_description, container, false);
        ButterKnife.bind(this, view);

        //Activate viewPager
        fragmentPagerAdapter = new ViewPagerAdapter(getActivity().getSupportFragmentManager());
        viewPager.setAdapter(fragmentPagerAdapter);

        return view;
    }
}
