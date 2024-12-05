package com.ias.gestioneventos.application.useCase;

import com.ias.gestioneventos.infraestructure.persistenceJPA.entityJPA.EventoJPA;
import com.ias.gestioneventos.infraestructure.persistenceJPA.EventoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EventoServicio {

    @Autowired
    private EventoRepositorio eventoRepositorio;

    public List<EventoJPA> obtenerEventos() {
        return eventoRepositorio.findAll();
    }

    public EventoJPA guardarEvento(EventoJPA evento) {
        return eventoRepositorio.save(evento);
    }

    public EventoJPA actualizarEvento(EventoJPA evento) {
        return eventoRepositorio.save(evento);
    }

}







