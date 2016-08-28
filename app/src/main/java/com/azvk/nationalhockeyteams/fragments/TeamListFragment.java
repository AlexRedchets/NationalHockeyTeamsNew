/*
package com.azvk.nationalhockeyteams.fragments;

import android.content.Intent;
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
import com.azvk.nationalhockeyteams.SQLite.DBHandler;
import com.azvk.nationalhockeyteams.activities.TeamInfoActivity;
import com.azvk.nationalhockeyteams.adapters.TeamsAdapter;
import com.azvk.nationalhockeyteams.interfaces.TeamInterface;
import com.azvk.nationalhockeyteams.models.Team;
import com.azvk.nationalhockeyteams.presenters.RostersPresenter;
import com.azvk.nationalhockeyteams.presenters.TeamPresenter;

import java.util.List;

public class TeamListFragment extends Fragment implements TeamInterface.TeamListPresenterView{

    private static final String TAG = TeamListFragment.class.getSimpleName();
    private TeamInterface.TeamListViewPresenter teamListViewPresenter;
    private TeamsAdapter teamsAdapter;
    private List<Team> teamList;
    private Navigator navigator;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.i(TAG, "onCreateView started");
        View view = inflater.inflate(R.layout.fragment_team_list, container, false);

        //Seting up RecycleView and Adapter
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.team_recycle_view);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        teamsAdapter = new TeamsAdapter(getContext(), team -> teamListViewPresenter.saveTeamDB(team));
        recyclerView.setAdapter(teamsAdapter);

        //check the connection to the Internet
        navigator = new Navigator(getActivity());

        //get team list
        teamListViewPresenter = new TeamPresenter(this, getContext());
        teamListViewPresenter.getTeamListDB();

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
                teamListViewPresenter = new TeamPresenter(this, getContext());
                teamListViewPresenter.getTeamList();
            }
            else if (teamList.isEmpty()) {
                Log.i(TAG, "No connection to the Intenet and no info in DB");
                Snackbar.make(view, R.string.network_error,
                        Snackbar.LENGTH_LONG)
                        .show();
            }
            else{
                Log.i(TAG, "No connection to the Intenet, get info from DB");
                teamsAdapter.updateAdapter(teamList);
            }
        } else {
            Log.i(TAG, "savedInstanceState NOT null");
            if (teamList.isEmpty()){
                Log.i(TAG, "No connection to the Intenet and no info in DB");
                Snackbar.make(view, R.string.network_error,
                        Snackbar.LENGTH_LONG)
                        .show();
            }
            else{
                Log.i(TAG, "No connection to the Intenet, get info from DB");
                teamsAdapter.updateAdapter(teamList);
            }
        }
    }

    @Override
    public void returnTeam(List<Team> teamsList) {
        Log.i(TAG, "Team list was got successfully");
        teamsAdapter.updateAdapter(teamsList);
    }

    @Override
    public void errorServer(String error) {
        Log.i(TAG, "Team list: server ERROR");
        Toast.makeText(getContext(), "Enable to connect server. Try later", Toast.LENGTH_LONG).show();
    }

    @Override
    public void returnTeamListDB(List<Team> teamsList) {
        if (teamsList.isEmpty()){
            Log.i(TAG, "Database is empty");
        } else {
            Log.i(TAG, "Database is NOT empty");
        }
        this.teamList = teamsList;
    }

    @Override
    public void runTeamInfo() {
        Intent intent = new Intent(getActivity(), TeamInfoActivity.class);
        startActivity(intent);
        getActivity().finish();
    }
}*/
