package com.ias.gestioneventos.servicios;

import com.ias.gestioneventos.model.TipoEvento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DescripcionEventoServicioImpl extends DescripEventoServicio {


    @Autowired
    private DescripEventoServicio descripEventoServicio;


    // Método privado para obtener la descripción
    private String obtenerDescripcionPorTipoEvento(TipoEvento tipoEvento) {
        switch (tipoEvento) {
            case Bautizo:
                return descripEventoServicio.descripBautizo();
            case primeraComunion:
                return descripEventoServicio.descripPrimeraComunion();
            case confirmacion:
                return descripEventoServicio.descripConfirmacion();
            case matrimonio:
                return descripEventoServicio.descripMatrimonio();
            case fiesta_Infantil:
                return descripEventoServicio.descripEventoInfantil();
            case fiesta_Empresarial:
                return descripEventoServicio.descripEventoEmpresarial();
            case fiesta_Familiar:
                return descripEventoServicio.descripFiestaFamiliar();
            case fiesta_DeQuince:
                return descripEventoServicio.descripfiestaDeQuince();
            case fiestaDe_Graduacion:
                return descripEventoServicio.descripFiestaGraduacion();
            case fiesta_De_Aniversario:
                return descripEventoServicio.descripFiestaAniversario();
            case fiesta_Despedida_Soltero:
                return descripEventoServicio.descripFiestaDespedida();
            default:
                return null;
        }
    }
}
