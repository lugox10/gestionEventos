package com.ias.gestioneventos.servicios;

import org.springframework.stereotype.Repository;

@Repository
public interface DescripcionEventos {

    String descripEventoInfantil();
    String descripEventoEmpresarial();
    String descripfiestaDeQuince();
    String descripFiestaDespedida();
    String descripFiestaFamiliar();
    String descripFiestaGraduacion();
    String descripFiestaAniversario();
    String descripMatrimonio();
    String descripBautizo();
    String descripPrimeraComunion();
    String descripConfirmacion();


}
