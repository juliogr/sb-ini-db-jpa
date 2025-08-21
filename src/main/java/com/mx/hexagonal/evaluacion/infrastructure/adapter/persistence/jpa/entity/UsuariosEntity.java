package com.mx.hexagonal.evaluacion.infrastructure.adapter.persistence.jpa.entity;

import com.mx.hexagonal.evaluacion.domain.model.Usuarios;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import jakarta.persistence.Table;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;

import lombok.*;

import java.util.Date;

/**
 * The type Usuarios.
 */
@Getter
@Setter
@Builder
@Entity
@Table(name = "USUARIOS", schema = "evaluacion")
public class UsuariosEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "email")
    private String email;

    @Column(name = "fecha_nacimiento")
    private Date fechaNacimiento;

    /**
     * Instantiates a new Usuarios entity.
     */
    public UsuariosEntity() {}

    /**
     * To domain model usuarios.
     *
     * @return the usuarios
     */
    public Usuarios toDomainModel() {
        return new Usuarios(id, nombre, email, fechaNacimiento);
    }

    /**
     * Instantiates a new Usuarios entity.
     *
     * @param id              the id
     * @param nombre          the nombre
     * @param email           the email
     * @param fechaNacimiento the fecha nacimiento
     */
    public UsuariosEntity(Long id, String nombre, String email, Date fechaNacimiento) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.fechaNacimiento = fechaNacimiento;
    }

    /**
     * From domain model usuarios entity.
     *
     * @param usuarios the usuarios
     * @return the usuarios entity
     */
    public static UsuariosEntity fromDomainModel(Usuarios usuarios) {
        return new UsuariosEntity(
                usuarios.getId(),
                usuarios.getNombre(),
                usuarios.getEmail(),
                usuarios.getFechaNacimiento());
    }

}
