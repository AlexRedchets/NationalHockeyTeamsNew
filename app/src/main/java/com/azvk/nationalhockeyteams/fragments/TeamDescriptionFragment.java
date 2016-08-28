/*
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
import com.azvk.nationalhockeyteams.interfaces.TeamInterface;
import com.azvk.nationalhockeyteams.models.Team;
import com.azvk.nationalhockeyteams.presenters.TeamPresenter;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TeamDescriptionFragment extends Fragment implements TeamInterface.SendDB{

    @BindView(R.id.view_pager)
    ViewPager viewPager;
    @BindView(R.id.view_flipper)
    ViewFlipper viewFlipper;
    FragmentPagerAdapter fragmentPagerAdapter;
    private Team team;
    String[] resources;

    public TeamDescriptionFragment() {}

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_team_description, container, false);
        ButterKnife.bind(this, view);

        //Activate viewPager
        fragmentPagerAdapter = new ViewPagerAdapter(getActivity().getSupportFragmentManager());
        viewPager.setAdapter(fragmentPagerAdapter);

        TeamInterface.RequestDB requestDB = new TeamPresenter(this, getContext());
        requestDB.getDB();

        if (team != null){
            resources = new String[]{
                    team.getHeader_pic_1(),
                    team.getHeader_pic_2(),
                    team.getHeader_pic_3(),
                    team.getHeader_pic_3(),
                    team.getHeader_pic_5()
            };
        }

         //Add all images to the ViewFlipper

        for (String resource : resources) {
            ImageView imageView = new ImageView(getContext());
            Picasso.with(getContext()).load(resource).fit().into(imageView);
            viewFlipper.addView(imageView);
        }

        // Set in/out flipping animations
        viewFlipper.setInAnimation(getContext(), android.R.anim.fade_in);
        viewFlipper.setOutAnimation(getContext(), android.R.anim.fade_out);

        viewFlipper.setAutoStart(true);
        viewFlipper.setFlipInterval(5000); // flip every 3 seconds (3000ms)

        return view;
    }

    @Override
    public void sendDB(Team team) {
        this.team = team;
    }
}
*/
