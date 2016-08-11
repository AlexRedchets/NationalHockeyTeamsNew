package com.azvk.nationalhockeyteams.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.azvk.nationalhockeyteams.R;
import com.azvk.nationalhockeyteams.adapters.RostersAdapter;
import com.azvk.nationalhockeyteams.adapters.TeamsAdapter;
import com.azvk.nationalhockeyteams.interfaces.TeamInterface;
import com.azvk.nationalhockeyteams.models.Roster;
import com.azvk.nationalhockeyteams.models.Team;
import com.azvk.nationalhockeyteams.presenters.RostersPresenter;
import com.azvk.nationalhockeyteams.presenters.TeamPresenter;

import java.util.List;

public class TeamListFragment extends Fragment implements TeamInterface.PresenterView{

    private RecyclerView recyclerView;
    private TeamsAdapter teamsAdapter;
    private List<Team> teamList;
    private TeamInterface.ViewPresenter viewPresenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_team_list, container, false);

        //Seting up RecycleView and Adapter
        recyclerView = (RecyclerView)view.findViewById(R.id.team_recycle_view);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        teamsAdapter = new TeamsAdapter(getContext(), new TeamsAdapter.OnItemClickListener(){
            @Override
            public void onItemClick(Team team) {
                Toast.makeText(getContext(), team.getName(), Toast.LENGTH_SHORT).show();
            }
        });
        recyclerView.setAdapter(teamsAdapter);

        //get info from database
        viewPresenter = new TeamPresenter(this, getContext());
        viewPresenter.getTeam();

        return view;
    }

    @Override
    public void returnTeam(List<Team> teamsList) {
        this.teamList = teamsList;
        teamsAdapter.updateAdapter(teamList);
    }

    @Override
    public void errorServer(String error) {
        Toast.makeText(getContext(), "Enable to connect server. Try later", Toast.LENGTH_LONG).show();
    }
}
