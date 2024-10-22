package com.ias.gestioneventos.controladores;

import com.ias.gestioneventos.configuracionCors.ResponseWrapper;
import com.ias.gestioneventos.model.Eventos;
import com.ias.gestioneventos.model.TipoEvento;
import com.ias.gestioneventos.servicios.EventoServicioImpl;
import org.apache.catalina.filters.AddDefaultCharsetFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;


import java.util.List;
@ControllerAdvice
@RestController
@RequestMapping("/iasapi/eventos")
public class  EventoControlador {

    @Autowired
    private EventoServicioImpl eventoServicioImpl;

    // Obtener todos los eventos
    @GetMapping
    public ResponseEntity<ResponseWrapper<List<Eventos>>> obtenerTodosLosEventos() {
        try {
            List<Eventos> eventos = eventoServicioImpl.obtenerEventos();
            return ResponseEntity.ok(new ResponseWrapper<> (HttpStatus.OK.value(), "Eventos obtenidos exitosamente", eventos));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ResponseWrapper<> (HttpStatus.INTERNAL_SERVER_ERROR.value(), "Error al obtener eventos", null));
        } //ResponseWraper es una clase que se encarga de envolver la respuesta de la API
    }

    // Obtener eventos por tipo
    @GetMapping("/{tipoEvento}")
    public ResponseEntity<ResponseWrapper<List<Eventos>>> obtenerEventosPorTipo(@PathVariable TipoEvento tipoEvento) {
        try {
            List<Eventos> eventos = eventoServicioImpl.obtenerEventosPorTipo(tipoEvento);
            return ResponseEntity.ok(new ResponseWrapper<> (HttpStatus.OK.value(), "Eventos obtenidos por tipo", eventos));
        }catch (ResponseStatusException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new ResponseWrapper<> (HttpStatus.NOT_FOUND.value(), "No se encontraron eventos para el tipo especificado", null));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ResponseWrapper<> (HttpStatus.INTERNAL_SERVER_ERROR.value(), "Error al obtener eventos por tipo", null));
        }
    }

    // Crear un nuevo evento
    @PostMapping
    public ResponseEntity<ResponseWrapper<Eventos>> crearEvento(@RequestBody Eventos evento) {
        try {
            Eventos eventoGuardado = eventoServicioImpl.guardarEvento(evento);
            return ResponseEntity.ok(new ResponseWrapper<> (HttpStatus.OK.value(), "Evento creado exitosamente", eventoGuardado));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ResponseWrapper<> (HttpStatus.INTERNAL_SERVER_ERROR.value(), "Error al crear el evento", null));
        }
    }

    // Actualizar un evento
    @PutMapping("/{id}")
    public ResponseEntity<ResponseWrapper<Eventos>> actualizarEvento(@PathVariable Long id, @RequestBody Eventos evento) {
        try {
            Eventos eventoExistente = eventoServicioImpl.obtenerEventos().stream()
                    .filter(e -> e.getId().equals(id))
                    .findFirst()
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Evento no encontrado"));

            evento.setId(id);
            eventoServicioImpl.actualizarEvento(evento);
            return ResponseEntity.ok(new ResponseWrapper<> (HttpStatus.OK.value(), "Evento actualizado exitosamente", evento));
        } catch (ResponseStatusException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new ResponseWrapper<> (HttpStatus.NOT_FOUND.value(), "Evento no encontrado", null));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ResponseWrapper<> (HttpStatus.INTERNAL_SERVER_ERROR.value(), "Error al actualizar el evento", null));
        }
    }
}