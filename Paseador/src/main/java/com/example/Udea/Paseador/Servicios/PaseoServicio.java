package com.example.Udea.Paseador.Servicios;

import com.example.Udea.Paseador.DTO.PaseoRequest;
import com.example.Udea.Paseador.Entidades.Paseador;
import com.example.Udea.Paseador.Entidades.Paseo;
import com.example.Udea.Paseador.Entidades.Perro;
import com.example.Udea.Paseador.Repositorios.PaseadorRepositorio;
import com.example.Udea.Paseador.Repositorios.PaseoRepositorio;
import com.example.Udea.Paseador.Repositorios.PerroRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PaseoServicio {
    @Autowired
    private PaseoRepositorio paseoRepository;

    @Autowired
    private PerroRepositorio perroRepository;

    @Autowired
    private PaseadorRepositorio paseadorRepositorio;

    public Paseo createPaseo(PaseoRequest paseoRequest) {
        Paseo paseo = paseoRequest.getPaseo();
        Paseador paseador = paseadorRepositorio.findById(paseoRequest.getPaseadorId()).orElseThrow(() -> new RuntimeException("Paseador not found"));;

        List<Perro> perros = perroRepository.findAllById(paseoRequest.getPerroIds());
        if (perros.isEmpty()) {
            throw new RuntimeException("No se encontraron perros con los IDs proporcionados");
        }
        paseo.setPerro(perros);
        paseo.setPaseador(paseador);

        return paseoRepository.save(paseo);
    }

    public List<Paseo> getAllPaseos() {
        return paseoRepository.findAll();
    }
}