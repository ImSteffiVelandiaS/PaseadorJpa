package com.example.Udea.Paseador.Repositorios;

import com.example.Udea.Paseador.Entidades.Paseador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaseadorRepositorio extends JpaRepository<Paseador, String> {
}