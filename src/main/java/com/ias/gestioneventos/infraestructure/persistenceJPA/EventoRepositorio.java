package com.ias.gestioneventos.infraestructure.persistenceJPA;

import com.ias.gestioneventos.infraestructure.persistenceJPA.entityJPA.EventoJPA;
import com.ias.gestioneventos.domain.model.TipoEvento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventoRepositorio extends JpaRepository<EventoJPA, Long> {
    List<EventoJPA> findAllByTipoEvento(TipoEvento tipoEvento);
}
