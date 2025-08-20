package com.mx.hexagonal.evaluacion.infrastructure.adapter.persistence.jpa.repository;

import com.mx.hexagonal.evaluacion.infrastructure.adapter.persistence.jpa.entity.UsuariosEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * The interface Jpa usuarios repository.
 */
@Repository
public interface SpringDataUsuariosRepository extends JpaRepository<UsuariosEntity, Long> {
}