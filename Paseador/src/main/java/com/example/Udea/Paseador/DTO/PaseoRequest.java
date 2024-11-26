package com.example.Udea.Paseador.DTO;



import com.example.Udea.Paseador.Entidades.Paseo;

import java.util.List;

public class PaseoRequest {
    private String paseadorId;
    private Paseo paseo; // Example field
    private List<Integer> perroIds;

    public List<Integer> getPerroIds() {
        return perroIds;
    }

    public void setPerroIds(List<Integer> perroIds) {
        this.perroIds = perroIds;
    }

    public Paseo getPaseo() {
        return paseo;
    }

    public void setPaseo(Paseo paseo) {
        this.paseo = paseo;
    }

    public String getPaseadorId() {
        return paseadorId;
    }

    public void setPaseadorId(String paseadorId) {
        this.paseadorId = paseadorId;
    }
}