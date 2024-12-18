package com.example.Udea.Paseador.Servicios;

import com.example.Udea.Paseador.Entidades.Paseador;
import com.example.Udea.Paseador.Repositorios.PaseadorRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PaseadorServicio {

    @Autowired
    public PaseadorRepositorio paseadorRepositorio;

    public Paseador savePaseador(Paseador paseador){
        return paseadorRepositorio.save(paseador);
    }

    public List<Paseador> getAll(){
        return paseadorRepositorio.findAll();
    }

    public void deletePaseadorById(String documento){
        paseadorRepositorio.deleteById(documento);
    }

    public Optional<Paseador> getPaseadorById(String documento){
        return paseadorRepositorio.findById(documento);
    }
}