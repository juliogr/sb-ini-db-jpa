package com.mx.hexagonal.evaluacion.domain.port.in;

import com.mx.hexagonal.evaluacion.domain.model.Usuarios;

import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * The interface Retrieve usuarios use case.
 */
public interface RetrieveUsuariosUseCase {

    /**
     * Gets usuarios by id.
     *
     * @param id the id
     * @return the usuarios by id
     */
    Optional<Usuarios> getUsuariosById(Long id);

    /**
     * Gets all usuarios.
     *
     * @param usuarioId       the usuario id
     * @param nombre          the nombre
     * @param email           the email
     * @param fechaNacimiento the fecha nacimiento
     * @return the all usuarios
     */
    List<Usuarios> getAllUsuarios(Long usuarioId, String nombre, String email, Date fechaNacimiento);

}
