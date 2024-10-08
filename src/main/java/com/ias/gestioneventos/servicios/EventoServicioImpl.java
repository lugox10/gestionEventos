package com.ias.gestioneventos.servicios;

import com.ias.gestioneventos.model.Eventos;
import com.ias.gestioneventos.model.TipoEvento;
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
    private TipoEventoService tipoEventoService;



    // Método para obtener todos los eventos
    public List<Eventos> obtenerEventos(){
        return eventoServicio.obtenerEventos();
    }

    // Refactorizando el método guardarEvento para asociar la descripción
    public Eventos guardarEvento(Eventos evento){
        // llamamos el metodo obtenerDescripcionPorTipoEvento para obtener la descripción y anexarla al evento
        String descripcion = obtenerDescripcionPorTipoEvento(evento.getTipoEvento());
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
            case fiestaInfantil:
                return descripEventoServicio.descripEventoInfantil();
            case fiestaEmpresarial:
                return descripEventoServicio.descripEventoEmpresarial();
            case fiestaFamiliar:
                return descripEventoServicio.descripFiestaFamiliar();
            case fiestaDeQuince:
                return descripEventoServicio.descripfiestaDeQuince();
            case fiestaDeGraduacion:
                return descripEventoServicio.descripFiestaGraduacion();
            case fiestaDeAniversario:
                return descripEventoServicio.descripFiestaAniversario();
            case fiestaDeDespedidaSoltero:
                return descripEventoServicio.descripFiestaDespedida();
            default:
                return null;
        }
    }

    public Eventos actualizarEvento(Eventos eventoActualizado) {
        Eventos eventoExistente = eventoServicio.actualizarEvento(eventoActualizado);
        if (eventoExistente != null) {
            eventoExistente.setFechaInicio(eventoActualizado.getFechaInicio());
            eventoExistente.setFechaFin(eventoActualizado.getFechaFin());
            eventoExistente.setLugar(eventoActualizado.getLugar());
            eventoExistente.setTipoEvento(eventoActualizado.getTipoEvento());
            // Reasignamos la descripción con base en el nuevo tipo de evento, si ha cambiado
            String nuevaDescripcion = obtenerDescripcionPorTipoEvento(eventoActualizado.getTipoEvento());
            eventoExistente.setDescripcion(nuevaDescripcion);
            return eventoServicio.actualizarEvento(eventoExistente);
        }
        return null; // Devuelve null si no se encuentra el evento
    }

    public List<Eventos> obtenerEventosPorTipo(TipoEvento tipoEvento) {
        return tipoEventoService.obtenerEventosPorTipo(tipoEvento);
    }




}




