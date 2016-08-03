package com.azvk.nationalhockeyteams.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.azvk.nationalhockeyteams.R;
import com.azvk.nationalhockeyteams.interfaces.PresenterViewInterface;
import com.azvk.nationalhockeyteams.interfaces.ViewPresenterInterface;
import com.azvk.nationalhockeyteams.models.Rosters;
import com.azvk.nationalhockeyteams.presenters.RostersPresenter;

import java.util.List;

public class RostersFragment extends Fragment implements PresenterViewInterface{

    private static final String TAG = RostersFragment.class.getSimpleName();

    public RostersFragment() {
    }

    public static RostersFragment newInstance(){
        return new RostersFragment();
    }
    ViewPresenterInterface viewPresenterInterface;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.i(TAG, "onCreateView started");
        View view = inflater.inflate(R.layout.fragment_rosters, container, false);
        viewPresenterInterface = new RostersPresenter();
        viewPresenterInterface.getRoster();
        return view;
    }

    @Override
    public void returnRosters(List<Rosters> rosters) {
        Log.i(TAG, "returnRosters started");
    }
}
