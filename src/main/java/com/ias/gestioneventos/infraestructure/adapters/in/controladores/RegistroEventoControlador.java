package com.ias.gestioneventos.infraestructure.adapters.in.controladores;

import com.ias.gestioneventos.domain.model.RegistroEvento;
import com.ias.gestioneventos.infraestructure.adapters.out.RegistroEventoServicioImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/registro-evento")
public class RegistroEventoControlador {

    @Autowired
    private RegistroEventoServicioImpl registroEventoServicioImpl;

    // Endpoint para registrar un usuario en un evento
    @PostMapping("/registrar")
    public ResponseEntity<RegistroEvento> registrarUsuarioEnEvento(@RequestParam Long usuarioId, @RequestParam Long eventoId) {
        RegistroEvento registroEvento = registroEventoServicioImpl.registrarUsuarioEnEvento(usuarioId, eventoId);
        return ResponseEntity.ok(registroEvento);
    }

    // Endpoint para obtener los usuarios registrados en un evento
    @GetMapping("/evento/{eventoId}")
    public ResponseEntity<List<RegistroEvento>> obtenerUsuariosPorEvento(@PathVariable Long eventoId) {
        List<RegistroEvento> usuarios = registroEventoServicioImpl.obtenerUsuariosPorEvento(eventoId);
        return ResponseEntity.ok(usuarios);
    }


}
