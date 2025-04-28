package com.example.tugasapi.model;

import com.google.gson.annotations.SerializedName;

public class Team {
    @SerializedName("idTeam")
    private String idTeam;
    @SerializedName("strTeam")
    private String strTeam;
    @SerializedName("strBadge")
    private String strBadge;
    // Tambahkan field lain yang relevan dari respons API jika diperlukan

    public String getIdTeam() {
        return idTeam;
    }

    public String getStrTeam() {
        return strTeam;
    }

    public String getStrTeamBadge() {
        return strBadge;
    }

    public void setIdTeam(String idTeam) {
        this.idTeam = idTeam;
    }

    public void setStrTeam(String strTeam) {
        this.strTeam = strTeam;
    }

    public void setStrTeamBadge(String strTeamBadge) {
        this.strBadge = strTeamBadge;
    }
}