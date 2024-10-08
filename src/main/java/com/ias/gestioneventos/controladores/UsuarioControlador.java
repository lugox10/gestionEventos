package com.ias.gestioneventos.controladores;

import com.ias.gestioneventos.model.Eventos;
import com.ias.gestioneventos.model.Usuario;
import com.ias.gestioneventos.servicios.UsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioControlador {

    @Autowired
    private UsuarioServicio usuarioServicio;

    @PostMapping("/registrar")
    public ResponseEntity<Usuario> registrarUsuario(@RequestBody Usuario usuario) {
        Usuario nuevoUsuario = usuarioServicio.registrarUsuario(usuario);
        return ResponseEntity.ok(nuevoUsuario);
    }

    @GetMapping
    public ResponseEntity<List<Usuario>> obtenerUsuarios() {
        List<Usuario> usuarios = usuarioServicio.obtenerUsuarios();
        return ResponseEntity.ok(usuarios);
    }

    @GetMapping("/{id}/eventos")
    public ResponseEntity<List<Eventos>> obtenerEventosPorUsuario(@PathVariable Long id) {
        List<Eventos> eventos = usuarioServicio.obtenerEventosPorUsuario(id);
        return ResponseEntity.ok(eventos);
    }


}
