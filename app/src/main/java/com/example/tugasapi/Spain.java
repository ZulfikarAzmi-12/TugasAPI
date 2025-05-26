package com.example.tugasapi;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tugasapi.adapter.TeamAdapter;
import com.example.tugasapi.api.RetrofitClient;
import com.example.tugasapi.model.Team;
import com.example.tugasapi.model.TeamsResponse;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Spain extends AppCompatActivity {

    private RecyclerView recyclerViewTeams;
    private TeamAdapter teamAdapter;
    private List<Team> teamList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spain);

        // Inisialisasi RecyclerView
        recyclerViewTeams = findViewById(R.id.recyclerViewTeams);
        recyclerViewTeams.setLayoutManager(new LinearLayoutManager(this));
        teamAdapter = new TeamAdapter(this, teamList);
        recyclerViewTeams.setAdapter(teamAdapter);

        // Ambil data tim dari liga Spanyol
        getSpainLeagueTeams();
    }

    private void getSpainLeagueTeams() {
        // Misal Liga Spanyol = "Spanish La Liga"
        Call<TeamsResponse> call = RetrofitClient.getInstance().getSportDBApi().getAllSpain("Spanish La Liga");
        call.enqueue(new Callback<TeamsResponse>() {
            @Override
            public void onResponse(Call<TeamsResponse> call, Response<TeamsResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    List<Team> teams = response.body().getTeams();
                    if (teams != null && !teams.isEmpty()) {
                        teamAdapter.setTeamList(teams);
                    } else {
                        Toast.makeText(Spain.this, "Tidak ada tim ditemukan di Liga Spanyol.", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(Spain.this, "Gagal mendapatkan data tim.", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<TeamsResponse> call, Throwable t) {
                Toast.makeText(Spain.this, "Kesalahan jaringan: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
