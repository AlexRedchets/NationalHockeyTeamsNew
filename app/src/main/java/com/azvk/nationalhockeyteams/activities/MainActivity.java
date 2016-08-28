package com.azvk.nationalhockeyteams.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.azvk.nationalhockeyteams.NHTApplication;
import com.azvk.nationalhockeyteams.R;
import com.azvk.nationalhockeyteams.adapters.RostersAdapter;
import com.azvk.nationalhockeyteams.client.RostersClient;
import com.azvk.nationalhockeyteams.interfaces.RosterViewInterface;
import com.azvk.nationalhockeyteams.models.Roster;
import com.azvk.nationalhockeyteams.presenters.RosterPresenter;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import rx.Observable;

public class MainActivity extends AppCompatActivity implements RosterViewInterface {

    @Inject
    RostersClient rostersClient;
    @BindView(R.id.rosterts_recycle_view)
    RecyclerView recyclerView;

    private RosterPresenter rosterPresenter;
    private RostersAdapter rostersAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resolveDependencies();

        configView();

        rosterPresenter = new RosterPresenter(this);
        rosterPresenter.onCreate();
    }

    private void resolveDependencies() {
        ((NHTApplication)getApplication())
                .getApiComponent()
                .inject(this);
    }

    private void configView() {
        ButterKnife.bind(this);

        recyclerView.setRecycledViewPool(new RecyclerView.RecycledViewPool());
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recyclerView.setHasFixedSize(true);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        recyclerView.setAdapter(rostersAdapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        rosterPresenter.onResume();
        rosterPresenter.fetchRoster();
    }

    @Override
    public void onCompleted() {

    }

    @Override
    public void onError(String message) {

    }

    @Override
    public void onRoster(List<Roster> rosters) {

    }

    @Override
    public Observable<List<Roster>> getRosters() {
        return rostersClient.getRosters("Russia");
    }
}
