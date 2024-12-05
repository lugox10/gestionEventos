package com.ias.gestioneventos.application.useCase;

import com.ias.gestioneventos.application.eventoDTO.EventoDTO;

import com.ias.gestioneventos.application.mappers.EventoMapper;
import com.ias.gestioneventos.domain.gateways.EventoGateway;
import com.ias.gestioneventos.domain.model.EventosEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class EventoServicio {


    private final EventoGateway eventoGateway;
    private final EventoMapper eventoMapper;

    public EventoServicio (EventoGateway eventoGateway, EventoMapper eventoMapper) {
        this.eventoGateway = eventoGateway;
        this.eventoMapper = eventoMapper;
    }

    public List<EventoDTO> obtenerEventos() {
        return eventoGateway.obtenerEventos().stream()
                .map(eventoMapper::toDTO)
                .collect(Collectors.toList());
    }

    public EventoDTO crearEvento(EventoDTO eventoDTO) {
        EventosEntity evento = eventoMapper.toDomain(eventoDTO);
        EventosEntity eventoGuardado = eventoGateway.guardarEvento(evento);
        return eventoMapper.toDTO(eventoGuardado);
    }

    public EventoDTO actualizarEvento(Long id, EventoDTO eventoDTO) {
        EventosEntity evento = eventoMapper.toDomain(eventoDTO);
        evento.setId(id);
        EventosEntity eventoActualizado = eventoGateway.actualizarEvento(evento);
        return eventoMapper.toDTO(eventoActualizado);
    }
}