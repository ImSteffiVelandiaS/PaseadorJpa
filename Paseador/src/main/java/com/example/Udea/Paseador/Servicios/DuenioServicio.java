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
    // Method to update a Duenio by ID
    public Duenio updateDuenioById(Integer documento, Duenio updatedDuenio) {
        // Check if the Duenio exists
        return duenioRepositorio.findById(documento).map(existingDuenio -> {
            // Update fields
            if (updatedDuenio.getNombre() != null) {
                existingDuenio.setNombre(updatedDuenio.getNombre());
            }
            if (updatedDuenio.getApellido() != null) {
                existingDuenio.setApellido(updatedDuenio.getApellido());
            }
            if (updatedDuenio.getTelefono() != null) {
                existingDuenio.setTelefono(updatedDuenio.getTelefono());
            }
            if (updatedDuenio.getDireccion() != null) {
                existingDuenio.setDireccion(updatedDuenio.getDireccion());
            }
            if (updatedDuenio.getCiudad() != null) {
                existingDuenio.setCiudad(updatedDuenio.getCiudad());
            }
            if (updatedDuenio.getGenero() != null) {
                existingDuenio.setGenero(updatedDuenio.getGenero());
            }
            if (updatedDuenio.getEmail() != null) {
                existingDuenio.setEmail(updatedDuenio.getEmail());
            }

            // Save the updated Duenio
            return duenioRepositorio.save(existingDuenio);
        }).orElseThrow(() -> new RuntimeException("Duenio with ID " + documento + " not found"));
    }
}
