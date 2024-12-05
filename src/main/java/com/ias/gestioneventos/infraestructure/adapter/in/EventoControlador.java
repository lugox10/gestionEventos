package com.ias.gestioneventos.infraestructure.adapter.in;

import com.ias.gestioneventos.applications.eventoDTO.EventoDTO;
import com.ias.gestioneventos.applications.mapper.EventoAppMapper;
import com.ias.gestioneventos.domain.model.EventosEntity;
import com.ias.gestioneventos.infraestructure.adapter.out.EventoServicioImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/eventos")
public class EventoControlador {

    @Autowired
    private EventoServicioImpl eventoServicio;

    @Autowired
    private EventoAppMapper eventoMapper;

    // Obtener todos los eventos
    @GetMapping
    public ResponseEntity<List<EventoDTO>> obtenerEventos() {
        // Obtener la lista de eventos en la entidad de dominio
        List<EventosEntity> eventos = eventoServicio.obtenerEventos();

        // Convertir la lista de eventos a DTO
        List<EventoDTO> eventoDTOs = eventos.stream()
                .map(eventoMapper::eventoEntityToEventoDTO)
                .collect(Collectors.toList());

        // Retornar la lista de DTOs
        return ResponseEntity.ok(eventoDTOs);
    }

    // Crear un nuevo evento
    @PostMapping
    public ResponseEntity<EventoDTO> crearEvento(@RequestBody EventoDTO eventoDTO) {
        // Convertir el DTO a entidad de dominio
        EventosEntity eventoEntity = eventoMapper.eventoDTOToEventosEntity(eventoDTO);

        // Guardar el evento
        EventosEntity eventoGuardado = eventoServicio.guardarEvento(eventoEntity);

        // Convertir la entidad guardada a DTO
        EventoDTO eventoGuardadoDTO = eventoMapper.eventoEntityToEventoDTO (eventoGuardado);

        // Retornar el DTO del evento guardado
        return ResponseEntity.status(201).body(eventoGuardadoDTO);
    }


}
