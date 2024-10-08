package com.ias.gestioneventos.repositorios;

import com.ias.gestioneventos.model.Eventos;
import com.ias.gestioneventos.model.TipoEvento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventoRepositorio extends JpaRepository<Eventos, Long> {
    List<Eventos> findAllByTipoEvento(TipoEvento tipoEvento);
}
