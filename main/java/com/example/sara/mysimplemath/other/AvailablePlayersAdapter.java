package com.example.sara.mysimplemath.other;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.sara.mysimplemath.R;

import java.util.List;

/**
 * Created by Sara on 13.4.2017..
 */

public class AvailablePlayersAdapter extends RecyclerView.Adapter<AvailablePlayersAdapter.MyViewHolder> {
    private List<AvailablePlayers> availablePlayersList;

    public class MyViewHolder extends RecyclerView.ViewHolder{
        public TextView username;

        public MyViewHolder(View itemView) {
            super(itemView);
            username = (TextView) itemView.findViewById(R.id.username);
        }
    }

    public AvailablePlayersAdapter(List<AvailablePlayers> availablePlayersList){
        this.availablePlayersList = availablePlayersList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.available_players_list_row, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        AvailablePlayers availablePlayers = availablePlayersList.get(position);
        holder.username.setText(availablePlayers.getUsername());
    }

    @Override
    public int getItemCount() {
        return availablePlayersList.size();
    }

}
