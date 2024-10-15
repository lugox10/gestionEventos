package com.ias.gestioneventos.model;

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
    private Eventos evento;

    // Otros atributos si son necesarios
}
