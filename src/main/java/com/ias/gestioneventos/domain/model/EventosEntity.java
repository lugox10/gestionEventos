package com.ias.gestioneventos.domain.model;

import lombok.*;

import java.time.LocalDateTime;



@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class EventosEntity {

    private Long id;
    private LocalDateTime fechaInicio;
    private LocalDateTime fechaFin;
    private String lugar;
    private TipoEvento tipoEvento;
    private String descripcion;




}
