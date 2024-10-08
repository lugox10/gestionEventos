    package com.ias.gestioneventos.model;

    import jakarta.persistence.*;
    import lombok.Data;

    import java.util.List;

    @Data
    @Entity
    @Table(name = "usuarios")
    public class Usuario {

        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Id
        private Long id;

        private String nombreUsuario;
        private String password;

        @ManyToMany
        @JoinTable(
                name = "usuario_evento",
                joinColumns = @JoinColumn(name = "usuario_id"),
                inverseJoinColumns = @JoinColumn(name = "evento_id")
        )
        private List<Eventos> eventos; // lista de eventos a los que el usuario se ha registrado
    }
