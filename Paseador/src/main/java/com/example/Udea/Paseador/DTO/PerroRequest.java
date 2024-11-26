package com.example.Udea.Paseador.DTO;
import com.example.Udea.Paseador.Entidades.Perro;

public class PerroRequest {
    private String duenioId;
    private com.example.Udea.Paseador.Entidades.Perro perro;

    public String getDuenioId() {
        return duenioId;
    }

    public void setDuenioId(String duenioId) {
        this.duenioId = duenioId;
    }

    public Perro getPerro() {
        return perro;
    }

    public void setPerro(Perro perro) {
        this.perro = perro;
    }
}