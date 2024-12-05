package com.ias.gestioneventos.applications.mapper;

import com.ias.gestioneventos.applications.eventoDTO.EventoDTO;
import com.ias.gestioneventos.domain.model.EventosEntity;
import com.ias.gestioneventos.infraestructure.persistenciaDatosJPA.Eventos;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface EventoAppMapper {
    EventoAppMapper INSTANCE = Mappers.getMapper(EventoAppMapper.class);

    // Conversión entre la entidad de dominio (EventosEntity) y el DTO (EventoDTO)
    EventoDTO eventoEntityToEventoDTO(EventosEntity eventosEntity);
    EventosEntity eventoDTOToEventosEntity(EventoDTO eventoDTO);

    // Conversión entre la entidad JPA (Eventos) y la entidad de dominio (EventosEntity)
    Eventos eventoEntityToEventos(EventosEntity eventosEntity); // Convierte EventosEntity a Eventos (JPA)
    EventosEntity eventosToEventoEntity(Eventos eventos); // Convierte Eventos (JPA) a EventosEntity

}
