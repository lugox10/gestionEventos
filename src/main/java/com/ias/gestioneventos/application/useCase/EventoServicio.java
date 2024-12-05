package com.ias.gestioneventos.application.useCase;

import com.ias.gestioneventos.domain.model.Eventos;
import com.ias.gestioneventos.infraestructure.persistenceJPA.repositorios.EventoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EventoServicio {

    @Autowired
    private EventoRepositorio eventoRepositorio;

    public List<Eventos> obtenerEventos() {
        return eventoRepositorio.findAll();
    }

    public Eventos guardarEvento(Eventos evento) {
        return eventoRepositorio.save(evento);
    }

    public Eventos actualizarEvento(Eventos evento) {
        return eventoRepositorio.save(evento);
    }

}







