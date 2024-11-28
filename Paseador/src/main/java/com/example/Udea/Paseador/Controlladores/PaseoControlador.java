package com.example.Udea.Paseador.Controlladores;

import com.example.Udea.Paseador.DTO.PaseoRequest;
import com.example.Udea.Paseador.Entidades.Paseo;
import com.example.Udea.Paseador.Servicios.PaseoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/paseos")
public class PaseoControlador {

    @Autowired
    private PaseoServicio paseoService;

    @PostMapping
    public ResponseEntity<Paseo> createPaseo(@RequestBody PaseoRequest paseoRequest) {

        Paseo savedPaseo = paseoService.createPaseo(paseoRequest);

        return new ResponseEntity<>(savedPaseo, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Paseo>> getAllPaseo() {
        List<Paseo> paseoList = paseoService.getAllPaseos();
        return new ResponseEntity<>(paseoList, HttpStatus.OK);
    }
}