package com.ias.gestioneventos.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Table(name = "eventos")
@Entity
public class Eventos {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    @NotNull(message = "la fecha de inicio es obligatoria")
    private LocalDateTime fechaInicio = LocalDateTime.now();
    @NotNull(message = "la fecha de fin es obligatoria")
    private LocalDateTime fechaFin;
    @Enumerated(EnumType.STRING)
    private TipoDeLugaresParaEventos lugar;
    @Enumerated(EnumType.STRING)
    private TipoEvento tipoEvento;
    private String descripcion;


}
