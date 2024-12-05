package com.ias.gestioneventos.domain.gateways;

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
