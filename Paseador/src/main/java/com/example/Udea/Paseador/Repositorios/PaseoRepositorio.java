package com.example.Udea.Paseador.Repositorios;

import com.example.Udea.Paseador.Entidades.Paseo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaseoRepositorio extends JpaRepository<Paseo, Integer> {
}
