package com.ias.gestioneventos.infraestructure.adapter.out;

import com.ias.gestioneventos.applications.mapper.EventoAppMapper;
import com.ias.gestioneventos.domain.model.EventosEntity;
import com.ias.gestioneventos.domain.model.TipoEvento;
import com.ias.gestioneventos.infraestructure.persistenciaDatosJPA.EventoRepositorio;
import com.ias.gestioneventos.infraestructure.persistenciaDatosJPA.Eventos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class EventoServicioImpl {

    @Autowired
    private EventoRepositorio eventoRepositorio;

    // Mapa para las descripciones por tipo de evento
    private static final Map<TipoEvento, String> descripcionPorTipoEvento = new HashMap<>();

    static {
        descripcionPorTipoEvento.put(TipoEvento.Bautizo, "Descripción Bautizo");
        descripcionPorTipoEvento.put(TipoEvento.primeraComunion, "Descripción Primera Comunión");
        descripcionPorTipoEvento.put(TipoEvento.confirmacion, "Descripción Confirmación");
        descripcionPorTipoEvento.put(TipoEvento.matrimonio, "Descripción Matrimonio");
        descripcionPorTipoEvento.put(TipoEvento.fiesta_Infantil, "Descripción Fiesta Infantil");
        descripcionPorTipoEvento.put(TipoEvento.fiesta_Empresarial, "Descripción Fiesta Empresarial");
        descripcionPorTipoEvento.put(TipoEvento.fiesta_Familiar, "Descripción Fiesta Familiar");
        descripcionPorTipoEvento.put(TipoEvento.fiesta_DeQuince, "Descripción Fiesta de Quince");
        descripcionPorTipoEvento.put(TipoEvento.fiestaDe_Graduacion, "Descripción Fiesta de Graduación");
        descripcionPorTipoEvento.put(TipoEvento.fiesta_De_Aniversario, "Descripción Fiesta de Aniversario");
        descripcionPorTipoEvento.put(TipoEvento.fiesta_Despedida_Soltero, "Descripción Fiesta de Despedida Soltero");
    }

    // Obtener todos los eventos
    public List<EventosEntity> obtenerEventos() {
        List<Eventos> eventos = eventoRepositorio.findAll();
        return eventos.stream()
                .map(EventoAppMapper.INSTANCE::eventosToEventoEntity) // Usar el método correcto de conversión
                .collect(Collectors.toList());
    }

    // Guardar un evento
    public EventosEntity guardarEvento(EventosEntity eventoEntity) {
        String descripcion = obtenerDescripcionPorTipoEvento(eventoEntity.getTipoEvento());
        if (descripcion != null) {
            eventoEntity.setDescripcion(descripcion);
        }

        // Convertir de EventosEntity a Eventos (JPA)
        Eventos evento = EventoAppMapper.INSTANCE.eventoEntityToEventos(eventoEntity);
        Eventos eventoGuardado = eventoRepositorio.save(evento);

        // Convertir de nuevo a EventosEntity
        return EventoAppMapper.INSTANCE.eventosToEventoEntity(eventoGuardado);
    }

    // Obtener la descripción por tipo de evento
    private String obtenerDescripcionPorTipoEvento(TipoEvento tipoEvento) {
        return descripcionPorTipoEvento.get(tipoEvento);
    }




    // Excepción personalizada
    public static class EventoNoEncontradoException extends RuntimeException {
        public EventoNoEncontradoException(String message) {
            super(message);
        }
    }
}
