package com.example.Udea.Paseador.Controlladores;

import com.example.Udea.Paseador.Entidades.Duenio;
import com.example.Udea.Paseador.Servicios.DuenioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/duenio")
@CrossOrigin(origins = "http://localhost:4200")
public class DuenioControlador {

    @Autowired
    private DuenioServicio duenioServicio;

    //insertar

    @PostMapping
    public ResponseEntity<Duenio> crearDuenio(@RequestBody Duenio duenio){
        Duenio duenioGuardar = duenioServicio.guardarDuenio(duenio);
        return  new ResponseEntity<>(duenioGuardar, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public  ResponseEntity<Duenio> buscarDuenioId(@PathVariable int id){
        Optional<Duenio> duenio = duenioServicio.buscarById(id);
        return duenio.map(ResponseEntity::ok).orElseGet(()->ResponseEntity.notFound().build());
    }

    @GetMapping
    public  ResponseEntity<List<Duenio>> obtenerTodos(){

        List<Duenio> duenio = duenioServicio.consultarTodos();
        System.out.println(duenio);
        return  new ResponseEntity<>(duenio, HttpStatus.OK);
    }


}
