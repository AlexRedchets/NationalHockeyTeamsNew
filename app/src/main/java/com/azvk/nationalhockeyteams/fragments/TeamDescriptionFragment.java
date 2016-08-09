package com.azvk.nationalhockeyteams.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
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
    int[] resources = {
            R.drawable.be57e01fce6719,
            R.drawable.malkin,
            R.drawable.tarasenko,
    };

    public TeamDescriptionFragment() {}

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_team_description, container, false);
        ButterKnife.bind(this, view);

        //Activate viewPager
        fragmentPagerAdapter = new ViewPagerAdapter(getActivity().getSupportFragmentManager());
        viewPager.setAdapter(fragmentPagerAdapter);

         //Add all images to the ViewFlipper
        for (int i = 0; i < resources.length; i++) {
                  ImageView imageView = new ImageView(getContext());
                imageView.setImageResource(resources[i]);
              viewFlipper.addView(imageView);
        }



        // Set in/out flipping animations
        viewFlipper.setInAnimation(getContext(), android.R.anim.fade_in);
        viewFlipper.setOutAnimation(getContext(), android.R.anim.fade_out);

        viewFlipper.setAutoStart(true);
        viewFlipper.setFlipInterval(5000); // flip every 3 seconds (3000ms)

        return view;
    }
}
