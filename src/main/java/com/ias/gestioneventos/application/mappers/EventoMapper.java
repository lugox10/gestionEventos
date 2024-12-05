package com.ias.gestioneventos.application.mappers;


import com.ias.gestioneventos.application.eventoDTO.EventoDTO;
import com.ias.gestioneventos.domain.model.EventosEntity;
import com.ias.gestioneventos.infraestructure.persistenceJPA.entityJPA.EventoJPA;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper (componentModel = "spring")
public interface EventoMapper {
    EventoMapper INSTANCE = Mappers.getMapper(EventoMapper.class);

    // JPA <-> Domino
    EventosEntity toDomain(EventoJPA eventoJPA);
    EventoJPA toJPA(EventosEntity eventosEntity);

    // Dominio <-> DTO
    EventoDTO toDTO(EventosEntity eventosEntity);
    EventosEntity toDomain(EventoDTO eventoDTO);
}