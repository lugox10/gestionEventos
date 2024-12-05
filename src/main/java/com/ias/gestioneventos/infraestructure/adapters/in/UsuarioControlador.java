package com.ias.gestioneventos.infraestructure.adapters.in;

import com.ias.gestioneventos.infraestructure.configuracionCors.ResponseWrapper;
import com.ias.gestioneventos.infraestructure.persistenceJPA.entityJPA.EventoJPA;
import com.ias.gestioneventos.domain.model.Usuario;
import com.ias.gestioneventos.infraestructure.adapters.out.RegistroEventoServicioImpl;
import com.ias.gestioneventos.infraestructure.adapters.out.UsuarioServicio;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
@Validated  // Para permitir validaciones en este controlador
public class UsuarioControlador {

    @Autowired
    private UsuarioServicio usuarioServicio;

    @Autowired
    private RegistroEventoServicioImpl registroEventoServicioImpl;

    @PostMapping("/registrar")
    public ResponseEntity<ResponseWrapper<Usuario>> registrarUsuario(@Valid @RequestBody Usuario usuario) {
        try {
            Usuario nuevoUsuario = usuarioServicio.registrarUsuario(usuario);
            ResponseWrapper<Usuario> response = new ResponseWrapper<>(HttpStatus.OK.value (),
                    "Usuario registrado con éxito", nuevoUsuario);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            ResponseWrapper<Usuario> response = new ResponseWrapper<>(HttpStatus.INTERNAL_SERVER_ERROR.value (),
                    "Error al registrar el usuario: " + e.getMessage(), null);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    @GetMapping
    public ResponseEntity<ResponseWrapper<List<Usuario>>> obtenerUsuarios() {
        try {
            List<Usuario> usuarios = usuarioServicio.obtenerUsuarios();
            ResponseWrapper<List<Usuario>> response = new ResponseWrapper<>(HttpStatus.OK.value (),
                    "Lista de usuarios obtenida", usuarios);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            ResponseWrapper<List<Usuario>> response = new ResponseWrapper<>(HttpStatus.INTERNAL_SERVER_ERROR.value (),
                    "Error al obtener la lista de usuarios: " + e.getMessage(), null);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    @GetMapping("/{id}/eventos")
    public ResponseEntity<ResponseWrapper<List<EventoJPA>>> obtenerEventosPorUsuario(@PathVariable Long id) {
        try {
            List<EventoJPA> eventos = usuarioServicio.obtenerEventosPorUsuario(id);
            ResponseWrapper<List<EventoJPA>> response = new ResponseWrapper<>(HttpStatus.OK.value (),
                    "Eventos obtenidos para el usuario", eventos);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            ResponseWrapper<List<EventoJPA>> response = new ResponseWrapper<>(HttpStatus.INTERNAL_SERVER_ERROR.value (),
                    "Error al obtener los eventos: " + e.getMessage(), null);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }
}
