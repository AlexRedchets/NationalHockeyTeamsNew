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
import android.widget.Toast;

import com.azvk.nationalhockeyteams.R;
import com.azvk.nationalhockeyteams.SQLite.DBHandler;
import com.azvk.nationalhockeyteams.adapters.TeamsAdapter;
import com.azvk.nationalhockeyteams.interfaces.TeamInterface;
import com.azvk.nationalhockeyteams.models.Team;
import com.azvk.nationalhockeyteams.presenters.TeamPresenter;

import java.util.List;

public class TeamListFragment extends Fragment implements TeamInterface.TeamListPresenterView{

    private static final String TAG = TeamListFragment.class.getSimpleName();
    private TeamInterface.TeamListViewPresenter teamListViewPresenter;
    private TeamsAdapter teamsAdapter;

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

        //get team list
        teamListViewPresenter = new TeamPresenter(this, getContext());
        teamListViewPresenter.getTeam();

        return view;
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
}
