package com.azvk.nationalhockeyteams.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.azvk.nationalhockeyteams.Navigator;
import com.azvk.nationalhockeyteams.R;
import com.azvk.nationalhockeyteams.adapters.RostersAdapter;
import com.azvk.nationalhockeyteams.interfaces.RostersInterface;
import com.azvk.nationalhockeyteams.models.Roster;
import com.azvk.nationalhockeyteams.presenters.RostersPresenter;

import java.util.List;

import io.realm.Realm;

public class RostersFragment extends Fragment implements RostersInterface.PresenterView {

    private static final String TAG = RostersFragment.class.getSimpleName();
    private RecyclerView recyclerView;
    private RostersAdapter rostersAdapter;
    private List<Roster> rosterList;

    private Realm realm;

    private Navigator navigator;

    private RostersInterface.ViewPresenter viewPresenter;


    public static RostersFragment newInstance(){
        return new RostersFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.i(TAG, "onCreateView started");
        View view = inflater.inflate(R.layout.fragment_rosters, container, false);

        //check the connection to the Internet
        navigator = new Navigator(getActivity());

        //Seting up RecycleView and Adapter
        recyclerView = (RecyclerView)view.findViewById(R.id.rosterts_recycle_view);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        rostersAdapter = new RostersAdapter(getContext()) ;
        recyclerView.setAdapter(rostersAdapter);

        //get info from database
        viewPresenter = new RostersPresenter(this);
        viewPresenter.getRosterDB();


        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        Log.i(TAG, "onViewCreated started");
        super.onViewCreated(view, savedInstanceState);

        //if app launching at first time
        if (savedInstanceState == null) {
            Log.i(TAG, "savedInstanceState == null");
            if (navigator.isNetworkAvailable()){
                Log.i(TAG, "Network Available");
                viewPresenter = new RostersPresenter(this);
                viewPresenter.getRoster();
            }
            else if (rosterList.isEmpty()) {
                Log.i(TAG, "No connection to the Intenet and no info in DB");
                Snackbar.make(view, R.string.network_error,
                        Snackbar.LENGTH_LONG)
                        .show();
            }
            else{
                Log.i(TAG, "No connection to the Intenet, get info from DB");
                rostersAdapter.updateAdapter(rosterList);
            }
        } else {
            Log.i(TAG, "savedInstanceState NOT null");
            if (rosterList.isEmpty()){
                Log.i(TAG, "No connection to the Intenet and no info in DB");
                Snackbar.make(view, R.string.network_error,
                        Snackbar.LENGTH_LONG)
                        .show();
            }
            else{
                Log.i(TAG, "No connection to the Intenet, get info from DB");
                rostersAdapter.updateAdapter(rosterList);
            }
        }
    }

    @Override
    public void returnRosters(List<Roster> rosters) {
        Log.i(TAG, "returnRosters started");

        rostersAdapter.updateAdapter(rosters);

        rosterList = rosters;
    }

    @Override
    public void returnRostersDB(List<Roster> rosters) {
        Log.i(TAG, "returnRostersDB started");

        if (rosters.isEmpty()) {
            Log.i(TAG, "Database is empty");
        } else {
            Log.i(TAG, "Database is NOT empty");
        }

        rosterList = rosters;
    }

    @Override
    public void errorServer(String errorMessage) {
        Toast.makeText(getContext(), "Enable to connect server. Try later", Toast.LENGTH_LONG).show();
    }
}