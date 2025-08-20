package com.mx.hexagonal.evaluacion.infrastructure.adapter.persistence.adapter;

import com.mx.hexagonal.evaluacion.domain.model.Usuarios;
import com.mx.hexagonal.evaluacion.domain.port.out.UsuariosRepository;
import com.mx.hexagonal.evaluacion.infrastructure.adapter.persistence.jpa.entity.UsuariosEntity;
import com.mx.hexagonal.evaluacion.infrastructure.adapter.persistence.jpa.repository.SpringDataUsuariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.ObjectUtils;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * The type Jpa usuarios repository adapter.
 */
@Repository
public class JpaUsuariosRepositoryAdapter implements UsuariosRepository {

    @Autowired
    private SpringDataUsuariosRepository springDataUsuariosRepository;

    @Override
    public Usuarios save(Usuarios usuarios) {
        UsuariosEntity usuariosEntity = UsuariosEntity.fromDomainModel(usuarios);
        UsuariosEntity savedUsuariosEntity = this.springDataUsuariosRepository.save(usuariosEntity);
        return savedUsuariosEntity.toDomainModel();
    }

    @Override
    public Optional<Usuarios> findById(Long id) {
        return this.springDataUsuariosRepository.findById(id).map(UsuariosEntity::toDomainModel);
    }

    @Override
    public List<Usuarios> findAll(Long usuarioId, String nombre, String email, Date fechaNacimiento) {
        if (ObjectUtils.isEmpty(usuarioId)
                && ObjectUtils.isEmpty(nombre)
                && ObjectUtils.isEmpty(email)
                && ObjectUtils.isEmpty(fechaNacimiento)) {
            return this.springDataUsuariosRepository.findAll().stream()
                    .map(UsuariosEntity::toDomainModel)
                    .collect(Collectors.toList());
        } else {
            return this.springDataUsuariosRepository.findAll().stream()
                    .filter(obj -> {
                        boolean conditionA = ((usuarioId != null) && obj.getId().equals(usuarioId));
                        boolean conditionB = (nombre != null && obj.getNombre().equals(nombre));
                        boolean conditionC = (email != null && obj.getEmail().equals(email));
                        boolean conditionD = (fechaNacimiento != null && obj.getFechaNacimiento().equals(fechaNacimiento));
                        return conditionA && conditionB && conditionC && conditionD;
                    })
                    .map(UsuariosEntity::toDomainModel)
                    .collect(Collectors.toList());
        }
    }

    @Override
    public Optional<Usuarios> update(Usuarios usuarios) {
        if (this.springDataUsuariosRepository.existsById(usuarios.getId())) {
            UsuariosEntity usuariosEntity = UsuariosEntity.fromDomainModel(usuarios);
            UsuariosEntity updatedUsuariosEntity = this.springDataUsuariosRepository.save(usuariosEntity);
            return Optional.of(updatedUsuariosEntity.toDomainModel());
        }
        return Optional.empty();
    }

    @Override
    public boolean deleteById(Long id) {
        if (this.springDataUsuariosRepository.existsById(id)) {
            this.springDataUsuariosRepository.deleteById(id);
            return true;
        }
        return false;
    }

}
