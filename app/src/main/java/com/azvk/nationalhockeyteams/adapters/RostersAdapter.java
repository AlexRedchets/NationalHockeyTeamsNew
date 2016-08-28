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
import com.azvk.nationalhockeyteams.models.Roster;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RostersAdapter extends RecyclerView.Adapter<RostersAdapter.ViewHolder>{

    private List<Roster> listRosters;
    private Context context;
    private String TAG = RostersAdapter.class.getSimpleName();
    private RosterClickListener rosterClickListener;

    public RostersAdapter(Context context, RosterClickListener rosterClickListener) {
        this.context = context;
        this.rosterClickListener = rosterClickListener;
    }

    public void updateAdapter(List<Roster> lists){
        listRosters = lists;
        notifyDataSetChanged();
        Log.i(TAG, "Adapter is updated");
    }

    public Context getContext(){
        return context;
    }

    public void clearAll(){
        listRosters.clear();
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return listRosters != null ? listRosters.size() : 0;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View view = inflater.inflate(R.layout.roster_list_custom_row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        Roster currentRosterData = listRosters.get(position);

        holder.playerName.setText(currentRosterData.getName());
        Picasso.with(context).load(currentRosterData.getImageUrl()).into(holder.playerImage);
    }


    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        @BindView(R.id.player_name)
        TextView playerName;
        @BindView(R.id.player_image)
        ImageView playerImage;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            rosterClickListener.onClick(listRosters.get(getAdapterPosition()).getName());
        }
    }

    public interface RosterClickListener {

        void onClick(String name);
    }

}