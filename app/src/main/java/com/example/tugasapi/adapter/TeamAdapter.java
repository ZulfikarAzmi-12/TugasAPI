package com.example.tugasapi.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.example.tugasapi.R;
import com.example.tugasapi.model.Team;
import java.util.List;

public class TeamAdapter extends RecyclerView.Adapter<TeamAdapter.TeamViewHolder> {
    private final Context context;
    private List<Team> teamList;

    public TeamAdapter(Context context, List<Team> teamList) {
        this.context = context;
        this.teamList = teamList;
    }

    public void setTeamList(List<Team> teamList) {
        this.teamList = teamList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public TeamViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_team, parent, false);
        return new TeamViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull TeamViewHolder holder, int position) {
        Team currentTeam = teamList.get(position);
        holder.textViewTeamName.setText(currentTeam.getStrTeam());

        if (currentTeam.getStrTeamBadge() != null && !currentTeam.getStrTeamBadge().isEmpty()) {
            Glide.with(context)
                    .load(currentTeam.getStrTeamBadge())
                    .placeholder(R.drawable.ic_launcher_foreground) // Placeholder sementara loading
                    .error(R.drawable.ic_launcher_background) // Gambar jika error loading
                    .into(holder.imageViewTeamBadge);
        } else {
            holder.imageViewTeamBadge.setImageResource(R.drawable.ic_launcher_foreground); // Gambar default jika URL kosong
        }
    }

    @Override
    public int getItemCount() {
        return teamList.size();
    }

    static class TeamViewHolder extends RecyclerView.ViewHolder {
        ImageView imageViewTeamBadge;
        TextView textViewTeamName;

        public TeamViewHolder(@NonNull View itemView) {
            super(itemView);
            imageViewTeamBadge = itemView.findViewById(R.id.imageViewTeamBadge);
            textViewTeamName = itemView.findViewById(R.id.textViewTeamName);
        }
    }
}