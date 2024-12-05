package com.ias.gestioneventos.application.eventoDTO;

import com.ias.gestioneventos.domain.model.TipoEvento;
import lombok.*;
import java.time.LocalDateTime;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class EventoDTO {
    private Long id;
    private LocalDateTime fechaInicio;
    private LocalDateTime fechaFin;
    private String lugar;
    private TipoEvento tipoEvento;
    private String descripcion;
}