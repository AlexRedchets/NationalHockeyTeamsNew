package com.azvk.nationalhockeyteams.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.azvk.nationalhockeyteams.R;
import com.azvk.nationalhockeyteams.adapters.RostersAdapter;
import com.azvk.nationalhockeyteams.interfaces.RostersInterface;
import com.azvk.nationalhockeyteams.models.Rosters;
import com.azvk.nationalhockeyteams.presenters.RostersPresenter;

import java.util.List;

public class RostersFragment extends Fragment implements RostersInterface.PresenterViewInterface {

    private static final String TAG = RostersFragment.class.getSimpleName();
    private RecyclerView recyclerView;
    private RostersAdapter rostersAdapter;
    RostersInterface.ViewPresenterInterface viewPresenterInterface;

    public static RostersFragment newInstance(){
        return new RostersFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.i(TAG, "onCreateView started");
        return inflater.inflate(R.layout.fragment_rosters, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        Log.i(TAG, "onViewCreated started");
        super.onViewCreated(view, savedInstanceState);

        recyclerView = (RecyclerView)view.findViewById(R.id.recycle_view);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        rostersAdapter = new RostersAdapter(getActivity()) ;
        recyclerView.setAdapter(rostersAdapter);

        viewPresenterInterface = new RostersPresenter();
        viewPresenterInterface.getRoster();
    }

    @Override
    public void returnRosters(List<Rosters> rosters) {
        Log.i(TAG, "returnRosters started");
        rostersAdapter.updateAdapter(rosters);
    }
}
