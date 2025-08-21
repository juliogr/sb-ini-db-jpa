package com.mx.hexagonal.evaluacion.domain.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import java.util.Date;

/**
 * The type Usuarios.
 */
@Getter
@Setter
@Builder
public class Usuarios {

    private Long id;

    private String nombre;

    //@Email(message = "Formato de correo electrónico no válido")
    private String email;

    private Date fechaNacimiento;

    /**
     * Instantiates a new Usuarios.
     *
     * @param id              the id
     * @param nombre          the nombre
     * @param email           the email
     * @param fechaNacimiento the fecha nacimiento
     */
    public Usuarios(Long id, String nombre, String email, Date fechaNacimiento) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.fechaNacimiento = fechaNacimiento;
    }

}
