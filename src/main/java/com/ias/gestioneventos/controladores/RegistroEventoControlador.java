package com.ias.gestioneventos.controladores;

import com.ias.gestioneventos.model.RegistroEvento;
import com.ias.gestioneventos.servicios.RegistroEventoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/registro-evento")
public class RegistroEventoControlador {

    @Autowired
    private RegistroEventoServicio registroEventoServicio;

    // Endpoint para registrar un usuario en un evento
    @PostMapping("/registrar")
    public ResponseEntity<RegistroEvento> registrarUsuarioEnEvento(@RequestParam Long usuarioId, @RequestParam Long eventoId) {
        RegistroEvento registroEvento = registroEventoServicio.registrarUsuarioEnEvento(usuarioId, eventoId);
        return ResponseEntity.ok(registroEvento);
    }

    // Endpoint para obtener los eventos de un usuario
    @GetMapping("/usuario/{usuarioId}")
    public ResponseEntity<List<RegistroEvento>> obtenerEventosPorUsuario(@PathVariable Long usuarioId) {
        List<RegistroEvento> eventos = registroEventoServicio.obtenerEventosPorUsuario(usuarioId);
        return ResponseEntity.ok(eventos);
    }

    // Endpoint para obtener los usuarios registrados en un evento
    @GetMapping("/evento/{eventoId}")
    public ResponseEntity<List<RegistroEvento>> obtenerUsuariosPorEvento(@PathVariable Long eventoId) {
        List<RegistroEvento> usuarios = registroEventoServicio.obtenerUsuariosPorEvento(eventoId);
        return ResponseEntity.ok(usuarios);
    }


}
