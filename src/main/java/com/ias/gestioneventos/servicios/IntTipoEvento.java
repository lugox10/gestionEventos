package com.ias.gestioneventos.servicios;

import com.ias.gestioneventos.model.Eventos;
import com.ias.gestioneventos.model.TipoEvento;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface IntTipoEvento {


    List<Eventos> obtenerEventosPorTipo(TipoEvento tipoEvento);
}
