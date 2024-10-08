package com.ias.gestioneventos.servicios;

import com.ias.gestioneventos.model.Eventos;
import com.ias.gestioneventos.model.TipoEvento;
import com.ias.gestioneventos.repositorios.EventoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

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

    public void eliminarEvento(Long id) {
        eventoRepositorio.deleteById(id);
    }

    public Eventos actualizarEvento(Eventos evento) {
        return eventoRepositorio.save(evento);
    }

//falta metodo para obtener eventos por tipo



}
