package com.mx.hexagonal.evaluacion.application.usecases;

import com.mx.hexagonal.evaluacion.domain.model.Usuarios;
import com.mx.hexagonal.evaluacion.domain.port.in.RetrieveUsuariosUseCase;
import com.mx.hexagonal.evaluacion.domain.port.out.UsuariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * The type Retrieve usuarios use case.
 */
@Service
public class RetrieveUsuariosUseCaseImpl implements RetrieveUsuariosUseCase {

    @Autowired
    private UsuariosRepository usuariosRepository;

    @Override
    public Optional<Usuarios> getUsuariosById(Long id) {
        return this.usuariosRepository.findById(id);
    }

    @Override
    public List<Usuarios> getAllUsuarios(Long usuarioId, String nombre, String email, Date fechaNacimiento) {
        return this.usuariosRepository.findAll(usuarioId, nombre, email, fechaNacimiento);
    }

}