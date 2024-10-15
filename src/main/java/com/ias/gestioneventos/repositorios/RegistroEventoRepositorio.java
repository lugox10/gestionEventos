package com.ias.gestioneventos.repositorios;

import com.ias.gestioneventos.model.RegistroEvento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RegistroEventoRepositorio extends JpaRepository<RegistroEvento, Long> {

    // Método para obtener registros de eventos por usuario
    List<RegistroEvento> findByUsuarioId(Long Id);

    // Método para obtener registros de eventos por evento
    List<RegistroEvento> findByEventoId(Long Id);

}
