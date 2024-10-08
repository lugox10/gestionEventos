package com.ias.gestioneventos.repositorios;

import com.ias.gestioneventos.model.Eventos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventoRepositorio extends JpaRepository<Eventos, Long> {


}
