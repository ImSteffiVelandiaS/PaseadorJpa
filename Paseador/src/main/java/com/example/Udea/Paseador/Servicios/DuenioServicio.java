package com.example.Udea.Paseador.Servicios;

import com.example.Udea.Paseador.Entidades.Duenio;
import com.example.Udea.Paseador.Repositorios.DuenioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DuenioServicio {

    //inyeccion del Repositorio - llama a la interfaz
    @Autowired
    private DuenioRepositorio duenioRepositorio;

    //insertar
    public Duenio guardarDuenio(Duenio duenio){
        return  duenioRepositorio.save(duenio);
    }

    //Consultar x id
    public Optional<Duenio> buscarById(Integer id) {
        return duenioRepositorio.findById(id);
    }
    //consultar Todos
    public List<Duenio> consultarTodos(){
        return  duenioRepositorio.findAll();
    }
}
