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
import com.azvk.nationalhockeyteams.models.Rosters;
import com.squareup.picasso.Picasso;

import java.util.List;

public class RostersAdapter extends RecyclerView.Adapter<RostersAdapter.ViewHolder>{

    private List<Rosters> listRosters;
    private Context context;
    private String TAG = RostersAdapter.class.getSimpleName();

    public RostersAdapter(Context context) {
        this.context = context;
    }

    public void updateAdapter(List<Rosters> lists){
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
        View view = inflater.inflate(R.layout.recycle_view_custom_row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        Rosters currentRostersData = listRosters.get(position);

        holder.playerName.setText(currentRostersData.getName());
        Picasso.with(context).load(currentRostersData.getImageUrl()).into(holder.playerImage);
    }


    protected static class ViewHolder extends RecyclerView.ViewHolder{

        TextView playerName;
        ImageView playerImage;

        private ViewHolder(View itemView) {
            super(itemView);

            playerImage = (ImageView)itemView.findViewById(R.id.player_image);
            playerName = (TextView)itemView.findViewById(R.id.player_name);
        }
    }

}