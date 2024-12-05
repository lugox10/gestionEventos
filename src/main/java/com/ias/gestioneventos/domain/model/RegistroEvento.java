package com.ias.gestioneventos.domain.model;

import com.ias.gestioneventos.infraestructure.persistenceJPA.entityJPA.EventoJPA;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "registro_evento")
public class RegistroEvento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "evento_id")
    private EventoJPA evento;

}
