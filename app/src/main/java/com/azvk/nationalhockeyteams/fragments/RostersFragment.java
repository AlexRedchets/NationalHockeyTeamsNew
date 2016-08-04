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

import com.azvk.nationalhockeyteams.NetworkState;
import com.azvk.nationalhockeyteams.R;
import com.azvk.nationalhockeyteams.RealmState;
import com.azvk.nationalhockeyteams.adapters.RostersAdapter;
import com.azvk.nationalhockeyteams.interfaces.RostersInterface;
import com.azvk.nationalhockeyteams.models.Roster;
import com.azvk.nationalhockeyteams.presenters.RostersPresenter;

import java.util.List;

import io.realm.Realm;
import io.realm.RealmConfiguration;

public class RostersFragment extends Fragment implements RostersInterface.PresenterViewInterface {

    private static final String TAG = RostersFragment.class.getSimpleName();
    private RecyclerView recyclerView;
    private RostersAdapter rostersAdapter;
    RostersInterface.ViewPresenterInterface viewPresenterInterface;

    private Realm realm;
    List<Roster> rosterList;

    public static RostersFragment newInstance(){
        return new RostersFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.i(TAG, "onCreateView started");
        View view = inflater.inflate(R.layout.fragment_rosters, container, false);

        //Seting up RecycleView and Adapter
        recyclerView = (RecyclerView)view.findViewById(R.id.recycle_view);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        rostersAdapter = new RostersAdapter(getContext()) ;
        recyclerView.setAdapter(rostersAdapter);

        RealmState realmState = new RealmState(getContext());
        realm = realmState.getRealm();

        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        Log.i(TAG, "onViewCreated started");
        super.onViewCreated(view, savedInstanceState);

        rosterList = realm.where(Roster.class).findAll();

        if (savedInstanceState == null){
            Log.i(TAG, "savedInstanceState == null");
            NetworkState networkState = new NetworkState(getActivity());
            if (networkState.isNetworkAvailable()){
                Log.i(TAG, "Network Available");
                viewPresenterInterface = new RostersPresenter(this);
                viewPresenterInterface.getRoster();
            }
            else if (!rosterList.isEmpty()){
                Log.i(TAG, "realm != null");
                List<Roster> rosterList = realm.where(Roster.class).findAll();
                rostersAdapter.updateAdapter(rosterList);
            }
            else{
                Toast.makeText(getContext(), R.string.network_error, Toast.LENGTH_SHORT).show();
            }
        }
        else{
            List<Roster> rosterList = realm.where(Roster.class).findAll();
            rostersAdapter.updateAdapter(rosterList);
        }
    }

    @Override
    public void returnRosters(List<Roster> rosters) {
        Log.i(TAG, "returnRosters started");

        realm.beginTransaction();
        if (realm != null){
            realm.deleteAll();
        }
        realm.copyToRealmOrUpdate(rosters);
        realm.commitTransaction();

        rostersAdapter.updateAdapter(rosters);
    }
}