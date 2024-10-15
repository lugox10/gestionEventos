package com.ias.gestioneventos.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Table(name = "eventos")
@Entity
public class Eventos {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    private LocalDateTime fechaInicio = LocalDateTime.now();
    private LocalDateTime fechaFin;
    @Enumerated(EnumType.STRING)
    private TipoDeLugaresParaEventos lugar;
    @Enumerated(EnumType.STRING)
    private TipoEvento tipoEvento;
    private String descripcion;


}
