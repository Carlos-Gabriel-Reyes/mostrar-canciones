package com.carlosreyes.canciones.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carlosreyes.canciones.modelos.Cancion;
import com.carlosreyes.canciones.repositorios.RepositorioCanciones;

@Service
public class ServicioCanciones {

    @Autowired
    private RepositorioCanciones repo;

    public List<Cancion> obtenerTodasLasCanciones() {
        return repo.findAll();
    }

    public Cancion obtenerCancionPorId(Long id) {
        Optional<Cancion> op = repo.findById(id);
        return op.orElse(null);
    }
}
