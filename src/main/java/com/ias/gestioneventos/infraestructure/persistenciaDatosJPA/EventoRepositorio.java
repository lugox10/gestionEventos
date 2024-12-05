package com.ias.gestioneventos.infraestructure.persistenciaDatosJPA;

import com.ias.gestioneventos.domain.model.TipoEvento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventoRepositorio extends JpaRepository<Eventos, Long> {
    List<Eventos> findAllByTipoEvento(TipoEvento tipoEvento);
}
