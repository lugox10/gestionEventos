package com.ias.gestioneventos.servicios;

import com.ias.gestioneventos.model.Eventos;
import com.ias.gestioneventos.model.TipoEvento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TipoEventoService {

    @Autowired
    private IntTipoEvento interfaceTipoEvento;



    public List<Eventos> obtenerEventosPorTipo(TipoEvento tipoEvento) {
        return interfaceTipoEvento.obtenerEventosPorTipo(tipoEvento);
    }
}
