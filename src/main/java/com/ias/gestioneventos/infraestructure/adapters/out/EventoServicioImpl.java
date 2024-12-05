package com.ias.gestioneventos.infraestructure.adapters.out;

import com.ias.gestioneventos.application.useCase.DescripEventoServicio;
import com.ias.gestioneventos.application.useCase.EventoServicio;
import com.ias.gestioneventos.infraestructure.persistenceJPA.entityJPA.EventoJPA;
import com.ias.gestioneventos.domain.model.TipoEvento;
import com.ias.gestioneventos.infraestructure.persistenceJPA.EventoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventoServicioImpl {

    @Autowired
    private EventoServicio eventoServicio;

    @Autowired
    private DescripEventoServicio descripEventoServicio;

    @Autowired
    private EventoRepositorio eventoRepositorio;


    // Método para obtener todos los eventos
    public List<EventoJPA> obtenerEventos() {
        return eventoServicio.obtenerEventos();
    }

    // Refactorizando el método guardarEvento para asociar la descripción
    public EventoJPA guardarEvento(EventoJPA evento) {
        String descripcion = obtenerDescripcionPorTipoEvento(evento.getTipoEvento());// llamamos el metodo obtenerDescripcionPorTipoEvento para obtener la descripción y anexarla al event
        if (descripcion != null) {
            evento.setDescripcion(descripcion);
        }
        return eventoServicio.guardarEvento(evento);
    }

    // Método privado para obtener la descripción
    private String obtenerDescripcionPorTipoEvento(TipoEvento tipoEvento) {
        switch (tipoEvento) {
            case Bautizo:
                return descripEventoServicio.descripBautizo();
            case primeraComunion:
                return descripEventoServicio.descripPrimeraComunion();
            case confirmacion:
                return descripEventoServicio.descripConfirmacion();
            case matrimonio:
                return descripEventoServicio.descripMatrimonio();
            case fiesta_Infantil:
                return descripEventoServicio.descripEventoInfantil();
            case fiesta_Empresarial:
                return descripEventoServicio.descripEventoEmpresarial();
            case fiesta_Familiar:
                return descripEventoServicio.descripFiestaFamiliar();
            case fiesta_DeQuince:
                return descripEventoServicio.descripfiestaDeQuince();
            case fiestaDe_Graduacion:
                return descripEventoServicio.descripFiestaGraduacion();
            case fiesta_De_Aniversario:
                return descripEventoServicio.descripFiestaAniversario();
            case fiesta_Despedida_Soltero:
                return descripEventoServicio.descripFiestaDespedida();
            default:
                return null;
        }
    }

    public EventoJPA actualizarEvento(EventoJPA eventoActualizado) {
        EventoJPA eventoExistente = eventoServicio.actualizarEvento(eventoActualizado);
        if (eventoExistente != null) {
            eventoExistente.setFechaInicio(eventoActualizado.getFechaInicio());
            eventoExistente.setFechaFin(eventoActualizado.getFechaFin());
            eventoExistente.setLugar(eventoActualizado.getLugar());
            eventoExistente.setTipoEvento(eventoActualizado.getTipoEvento());

            String nuevaDescripcion = obtenerDescripcionPorTipoEvento(eventoActualizado.getTipoEvento());
            eventoExistente.setDescripcion(nuevaDescripcion);
            return eventoServicio.actualizarEvento(eventoExistente);
        }
        return null; // Devuelve null si no se encuentra el evento
    }

    public List<EventoJPA> obtenerEventosPorTipo(TipoEvento tipoEvento) {
        return eventoRepositorio.findAllByTipoEvento(tipoEvento);
    }



}




