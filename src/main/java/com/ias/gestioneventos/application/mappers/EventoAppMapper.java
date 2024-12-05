package com.ias.gestioneventos.application.mappers;

import com.ias.gestioneventos.application.eventoDTO.EventoDTO;
import com.ias.gestioneventos.domain.model.EventosEntity;
import com.ias.gestioneventos.infraestructure.persistenceJPA.entityJPA.EventoJPA;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper (componentModel = "spring")
public interface EventoAppMapper {
    EventoAppMapper INSTANCE = Mappers.getMapper(EventoAppMapper.class);
    // Conversión entre la entidad de dominio (EventosEntity) y el DTO (EventoDTO)
    EventoDTO eventoJPAToEventoDTO (EventosEntity eventosEntity);
    EventosEntity eventoDTOToEventosEntity(EventoDTO eventoDTO);
    // Conversión entre la entidad JPA (Eventos) y la entidad de dominio (EventosEntity)
    EventoJPA eventoEntityToEventos(EventosEntity eventosEntity); // Convierte EventosEntity a Eventos (JPA)
    EventosEntity eventosToEventoEntity(EventoJPA eventos); // Convierte Eventos (JPA) a EventosEntity
}