package com.ias.gestioneventos.infraestructure.persistenceJPA;

import com.ias.gestioneventos.domain.model.RegistroEvento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface RegistroEventoRepositorio extends JpaRepository<RegistroEvento, Long> {

    // Método para obtener registros de eventos por usuario
    List<RegistroEvento> findByUsuarioId(Long Id);

    // Método para obtener registros de eventos por evento
    List<RegistroEvento> findByEventoId(Long Id);

}
