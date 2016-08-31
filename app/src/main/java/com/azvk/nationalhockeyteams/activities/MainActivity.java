/*
package com.azvk.nationalhockeyteams.activities;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import com.azvk.nationalhockeyteams.R;
import com.azvk.nationalhockeyteams.adapters.RostersAdapter;
import com.azvk.nationalhockeyteams.interfaces.RosterViewInterface;
import com.azvk.nationalhockeyteams.models.Roster;
import com.azvk.nationalhockeyteams.presenters.RosterPresenter;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import rx.Observable;

public class MainActivity extends AppCompatActivity implements RosterViewInterface {

    private static final String TAG = MainActivity.class.getSimpleName();

    @BindView(R.id.rosterts_recycle_view)
    RecyclerView recyclerView;
    @Inject
    RosterPresenter rosterPresenter;

    private RostersAdapter rostersAdapter;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //resolveDependencies();

        */
/*configView();

        rosterPresenter = new RosterPresenter(this);
        rosterPresenter.onCreate();*//*

    }

    */
/*private void resolveDependencies() {
        DaggerRosterComponent.builder()
                .netComponent(((App)getApplicationContext()).getNetComponent())
                .rosterModule(new RosterModule(this))
                .build().inject(this);
    }*//*


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
        return null;
    }

   */
/* private void configView() {
        ButterKnife.bind(this);

        recyclerView.setRecycledViewPool(new RecyclerView.RecycledViewPool());
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recyclerView.setHasFixedSize(true);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        rostersAdapter = new RostersAdapter(this, this) ;
        recyclerView.setAdapter(rostersAdapter);
    }

    @Override
    protected void onResume() {
        super.onResume();

        rosterPresenter.onResume();
        rosterPresenter.fetchRoster();

        progressDialog = new ProgressDialog(this);
        progressDialog.setIndeterminate(true);
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressDialog.setTitle("Downolading");
        progressDialog.setMessage("Please wait...");
        progressDialog.show();
    }

    @Override
    public void onCompleted() {
        Log.i(TAG, "onCompleted started");
        progressDialog.dismiss();
    }

    @Override
    public void onError(String message) {
        progressDialog.dismiss();
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onRoster(List<Roster> rosters) {
        rostersAdapter.updateAdapter(rosters);
    }

    @Override
    public Observable<List<Roster>> getRosters() {
        return rostersClient.getRosters("Russia");
    }

    @Override
    public void onClick(String name) {
        Toast.makeText(this, "You clicked on " + name, Toast.LENGTH_SHORT).show();
    }*//*

}
*/
