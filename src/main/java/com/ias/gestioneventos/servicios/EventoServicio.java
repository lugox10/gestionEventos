package com.ias.gestioneventos.servicios;

import com.ias.gestioneventos.model.Eventos;
import com.ias.gestioneventos.repositorios.EventoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EventoServicio {

    @Autowired
    private EventoRepositorio eventoRepositorio;

    // @Autowired
    //  private IntTipoEvento i;


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
    // public List<Eventos> obtenerEventosPorTipoDes(Eventos tipoEvento) {
    //    return i.obtenerEventosPorTipoDes(tipoEvento);
    // }


}







