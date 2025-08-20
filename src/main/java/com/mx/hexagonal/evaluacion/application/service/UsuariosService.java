package com.mx.hexagonal.evaluacion.application.service;

import com.mx.hexagonal.evaluacion.domain.model.Usuarios;
import com.mx.hexagonal.evaluacion.domain.port.in.RetrieveUsuariosUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * The type Usuarios service.
 */
@Service
public class UsuariosService implements RetrieveUsuariosUseCase {

    @Autowired
    private RetrieveUsuariosUseCase retrieveUsuariosUseCase;

    @Override
    public Optional<Usuarios> getUsuariosById(Long id) {
        return this.retrieveUsuariosUseCase.getUsuariosById(id);
    }

    @Override
    public List<Usuarios> getAllUsuarios(Long usuarioId, String nombre, String email, Date fechaNacimiento) {
        return this.retrieveUsuariosUseCase.getAllUsuarios(usuarioId, nombre, email, fechaNacimiento);
    }
}