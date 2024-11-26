package com.example.Udea.Paseador.Servicios;

import com.example.Udea.Paseador.Entidades.Duenio;
import com.example.Udea.Paseador.Entidades.Perro;
import com.example.Udea.Paseador.Repositorios.PaseoRepositorio;
import com.example.Udea.Paseador.Repositorios.PerroRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PerroServicio {

    @Autowired
    private PerroRepositorio perroRepositorio;

    @Autowired
    private PaseoRepositorio paseoRepositorio;

    public List<Perro> getAllPerros() {
        return perroRepositorio.findAll();
    }

    public List<Perro> getAllPerrosWithDuenios() {
        return perroRepositorio.findAllWithDuenios();
    }

    public Perro crearPerro(Perro perro, Optional<Duenio> duenio) {
        duenio.ifPresent(perro::setDuenio);
        return perroRepositorio.save(perro);
    }
}