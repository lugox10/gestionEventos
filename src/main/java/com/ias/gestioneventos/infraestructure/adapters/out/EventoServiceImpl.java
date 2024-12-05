package com.ias.gestioneventos.infraestructure.adapters.out;


import com.ias.gestioneventos.application.mappers.EventoMapper;
import com.ias.gestioneventos.application.useCase.DescripEventoServicio;
import com.ias.gestioneventos.domain.gateways.EventoGateway;
import com.ias.gestioneventos.domain.model.EventosEntity;
import com.ias.gestioneventos.domain.model.TipoEvento;
import com.ias.gestioneventos.infraestructure.persistenceJPA.EventoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EventoServiceImpl implements EventoGateway {

    private final EventoRepositorio eventoRepository;
    private final EventoMapper eventoMapper;
    private final DescripEventoServicio descripEventoServicio;

    @Autowired
    public EventoServiceImpl(EventoRepositorio eventoRepository, EventoMapper eventoMapper, DescripEventoServicio descripEventoServicio) {
        this.eventoRepository = eventoRepository;
        this.eventoMapper = eventoMapper;
        this.descripEventoServicio = descripEventoServicio;
    }

    @Override
    public List<EventosEntity> obtenerEventos() {
        return eventoRepository.findAll().stream()
                .map(eventoMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public EventosEntity guardarEvento(EventosEntity evento) {
        String descripcion = obtenerDescripcionPorTipoEvento(evento.getTipoEvento());
        if (descripcion != null) {
            evento.setDescripcion(descripcion);
        }
        return eventoMapper.toDomain(eventoRepository.save(eventoMapper.toJPA(evento)));
    }

    @Override
    public EventosEntity actualizarEvento(EventosEntity evento) {
        // Validación para asegurar que el evento existe
        if (!eventoRepository.existsById(evento.getId())) {
            throw new IllegalArgumentException("El evento con ID " + evento.getId() + " no existe.");
        }

        String nuevaDescripcion = obtenerDescripcionPorTipoEvento(evento.getTipoEvento());
        if (nuevaDescripcion != null) {
            evento.setDescripcion(nuevaDescripcion);
        }
        return eventoMapper.toDomain(eventoRepository.save(eventoMapper.toJPA(evento)));
    }

    public List<Object> obtenerEventosPorTipo(TipoEvento tipoEvento) {
        return eventoRepository.findAllByTipoEvento(tipoEvento).stream()
                .map(eventoMapper::toDomain)
                .collect(Collectors.toList());
    }

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
}
