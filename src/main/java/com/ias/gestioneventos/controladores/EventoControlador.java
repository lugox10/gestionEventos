package com.ias.gestioneventos.controladores;

import com.ias.gestioneventos.model.Eventos;
import com.ias.gestioneventos.model.TipoEvento;
import com.ias.gestioneventos.servicios.EventoServicioImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/eventos")
public class EventoControlador {

    @Autowired
    private EventoServicioImpl eventoServicioImpl;

    // Obtener todos los eventos
    @GetMapping
    public ResponseEntity<List<Eventos>> obtenerTodosLosEventos() {
        List<Eventos> eventos = eventoServicioImpl.obtenerEventos();
        return ResponseEntity.ok(eventos);
    }

    // Obtener eventos por tipo
    @GetMapping("/tipo/{tipoEvento}")
    public ResponseEntity<List<Eventos>> obtenerEventosPorTipo(@PathVariable TipoEvento tipoEvento) {
        List<Eventos> eventos = eventoServicioImpl.obtenerEventosPorTipo(tipoEvento).stream().toList();
        return ResponseEntity.ok(eventos);
    }

    // Crear un nuevo evento
    @PostMapping
    public ResponseEntity<Eventos> crearEvento(@RequestBody Eventos evento) {
        Eventos eventoGuardado = eventoServicioImpl.guardarEvento(evento);
        return ResponseEntity.ok(eventoGuardado);
    }

    // Actualizar un evento
    @PutMapping("/{id}")
    public ResponseEntity<Eventos> actualizarEvento(@PathVariable Long id, @RequestBody Eventos evento) {
        Eventos eventoExistente = eventoServicioImpl.obtenerEventos().stream().filter(e -> e.getId().equals(id)).findFirst().orElse(null);//utilize un poco de programacion funcional y el metodo filter para filtrar el evento por id
        if (eventoExistente == null) {
            return ResponseEntity.notFound().build();
        }
        evento.setId(id);
        eventoServicioImpl.actualizarEvento(evento);
        return ResponseEntity.ok(evento);





    }
}