package com.mx.hexagonal.evaluacion.domain.port.out;

import com.mx.hexagonal.evaluacion.domain.model.Usuarios;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface UsuariosRepository {

    /**
     * Save usuarios.
     *
     * @param usuarios the usuarios
     * @return the usuarios
     */
    Usuarios save(Usuarios usuarios);

    /**
     * Find by id optional.
     *
     * @param id the id
     * @return the optional
     */
    Optional<Usuarios> findById(Long id);

    /**
     * Find all list.
     *
     * @param usuarioId       the usuario id
     * @param nombre          the nombre
     * @param email           the email
     * @param fechaNacimiento the fecha nacimiento
     * @return the list
     */
    List<Usuarios> findAll(Long usuarioId, String nombre, String email, Date fechaNacimiento);

    /**
     * Update optional.
     *
     * @param usuarios the usuarios
     * @return the optional
     */
    Optional<Usuarios> update(Usuarios usuarios);

    /**
     * Delete by id boolean.
     *
     * @param id the id
     * @return the boolean
     */
    boolean deleteById(Long id);


}
