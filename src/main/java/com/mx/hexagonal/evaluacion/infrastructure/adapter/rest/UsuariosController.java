package com.mx.hexagonal.evaluacion.infrastructure.adapter.rest;

import com.mx.hexagonal.evaluacion.application.service.UsuariosService;
import com.mx.hexagonal.evaluacion.domain.model.Usuarios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
public class UsuariosController {

    @Autowired
    private UsuariosService usuariosService;

    /**
     * Gets all usuarios.
     *
     * @param usuarioId       the usuario id
     * @param nombre          the nombre
     * @param email           the email
     * @param fechaNacimiento the fecha nacimiento
     * @return the all usuarios
     */
    @GetMapping
    public ResponseEntity<List<Usuarios>> getAllUsuarios(
            @RequestParam(name = "id", required = false)  Long usuarioId,
            @RequestParam(name = "nombre", required = false)  String nombre,
            @RequestParam(name = "email", required = false)  String email,
            @RequestParam(name = "fechaNac", required = false)
            @DateTimeFormat(pattern = "dd-MM-yyyy") Date fechaNacimiento) {
        List<Usuarios> usuarios = this.usuariosService.getAllUsuarios(usuarioId, nombre, email, fechaNacimiento);
        return new ResponseEntity<>(usuarios, HttpStatus.OK);
    }

}
