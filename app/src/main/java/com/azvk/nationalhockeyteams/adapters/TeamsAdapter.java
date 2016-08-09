package com.azvk.nationalhockeyteams.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.azvk.nationalhockeyteams.R;
import com.azvk.nationalhockeyteams.models.Team;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TeamsAdapter extends RecyclerView.Adapter<TeamsAdapter.ViewHolder> {

    private List<Team> listTeam;
    private Context context;
    private String TAG = TeamsAdapter.class.getSimpleName();

    public TeamsAdapter(Context context) {
        this.context = context;
    }

    public void updateAdapter(List<Team> lists){
        listTeam = lists;
        notifyDataSetChanged();
        Log.i(TAG, "Adapter is updated");
    }

    public Context getContext(){
        return context;
    }

    public void clearAll(){
        listTeam.clear();
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return listTeam != null ? listTeam.size() : 0;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View view = inflater.inflate(R.layout.team_list_custom_row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        Team currentTeamData = listTeam.get(position);

        holder.teamName.setText(currentTeamData.getName());
        Picasso.with(context).load(currentTeamData.getFlag()).into(holder.teamImage);
    }


    protected static class ViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.team_name)
        TextView teamName;
        @BindView(R.id.team_image)
        ImageView teamImage;

        private ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}