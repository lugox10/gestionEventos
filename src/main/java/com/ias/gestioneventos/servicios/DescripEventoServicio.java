package com.ias.gestioneventos.servicios;

import org.springframework.stereotype.Service;

@Service
public class DescripEventoServicio implements EventoEspeciales, EventoInfantil, EventoEtiqueta, EventoJuvenil, EventoAdultos,EventoAdolecente {


    @Override
    public String descripEventoInfantil() {
        return "MUSICA INFANTIL, JUEGOS, DULCES, GLOBOS, DECORACION";
    }

    @Override
    public String descripEventoEmpresarial() {
        return "DJ EN VIVO, COMIDA, BEBIDA, DECORACION";
    }

    @Override
    public String descripfiestaDeQuince() {
        return "DJ EN VIVO, COMIDA, BEBIDA, DECORACION";
    }

    @Override
    public String descripFiestaDespedida() {
        return "MUSICA SEXY, COMIDA AFRODISIACA, BEBIDA ALICORADAS, DECORACION SEXUAL, JUEGOS EROTICOS, CHICAS SEXYS";
    }

    @Override
    public String descripFiestaFamiliar() {
        return "MUSICA, COMIDA, BEBIDA, DECORACION";
    }

    @Override
    public String descripFiestaGraduacion() {
        return "DJ EN VIVO, COMIDA, BEBIDA, DECORACION, FOTOGRAFIA, VIDEO";
    }

    @Override
    public String descripFiestaAniversario() {
        return "MUSICA, COMIDA, BEBIDA, DECORACION";
    }

    @Override
    public String descripMatrimonio() {
        return "MUSICA, COMIDA, BEBIDA, DECORACION, FOTOGRAFIA, VIDEO";
    }

    @Override
    public String descripBautizo() {
        return "MUSICA, COMIDA, BEBIDA, DECORACION, FOTOGRAFIA, VIDEO";
    }

    @Override
    public String descripPrimeraComunion() {
        return "MUSICA, COMIDA, BEBIDA, DECORACION, FOTOGRAFIA, VIDEO";
    }

    @Override
    public String descripConfirmacion() {
        return "MUSICA, COMIDA, BEBIDA, DECORACION, FOTOGRAFIA, VIDEO";
    }





}
