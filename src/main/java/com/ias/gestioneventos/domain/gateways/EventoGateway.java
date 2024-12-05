package com.ias.gestioneventos.domain.gateways;

import com.ias.gestioneventos.domain.model.EventosEntity;
import com.ias.gestioneventos.domain.model.TipoEvento;

import java.util.Collection;
import java.util.List;

public interface EventoGateway {
    List<EventosEntity> obtenerEventos();
    EventosEntity guardarEvento(EventosEntity evento);
    EventosEntity actualizarEvento(EventosEntity evento);

    List<Object> obtenerEventosPorTipo (TipoEvento tipoEvento);
}
