package com.ias.gestioneventos.application.useCase;

import com.ias.gestioneventos.application.eventoDTO.EventoDTO;
import com.ias.gestioneventos.application.mappers.EventoMapper;
//import com.ias.gestioneventos.domain.gateways.EventoGateway;
import com.ias.gestioneventos.domain.model.EventosEntity;
import com.ias.gestioneventos.infraestructure.persistenceJPA.EventoRepositorio;
import com.ias.gestioneventos.infraestructure.persistenceJPA.entityJPA.EventoJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class EventoServicio {

  //  @Autowired
  //  EventoGateway eventoGateway;

    @Autowired
    EventoMapper eventoMapper;

    @Autowired
    EventoRepositorio eventoRepositorio;

    @Autowired
    public EventoServicio ( EventoMapper eventoMapper, EventoRepositorio eventoRepositorio) {

        this.eventoMapper = eventoMapper;
        this.eventoRepositorio = eventoRepositorio;
    }

   //public List<EventoDTO> obtenerEventos () {
   //    return EventoRepositorio.findAll ();
   //}

   //public EventoDTO guardarEvento (EventoDTO eventoDTO) {
   //    EventosEntity evento = eventoMapper.toDomain (eventoDTO);
   //    EventosEntity eventoGuardado = eventoRepositorio.save (evento);
   //    return eventoMapper.toDTO (eventoGuardado);
   //}

   //public EventoDTO actualizarEvento (Long id, EventoDTO eventoDTO) {
   //    EventosEntity evento = eventoMapper.toDomain (eventoDTO);
   //    evento.setId (id);
   //    EventosEntity eventoActualizado = eventoGateway.actualizarEvento (evento);
   //    return eventoMapper.toDTO (eventoActualizado);
   //}

    public EventoJPA crearEvento (EventoJPA evento) {
        return eventoRepositorio.save (evento);
    }

}