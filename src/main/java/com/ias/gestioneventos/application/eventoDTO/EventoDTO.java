package com.ias.gestioneventos.application.eventoDTO;

import com.ias.gestioneventos.domain.model.TipoEvento;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import java.time.LocalDateTime;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class EventoDTO {
    private Long id;

    @NotNull (message = "La fecha de inicio es obligatoria")
    private LocalDateTime fechaInicio;

    @NotNull(message = "La fecha de fin es obligatoria")
    private LocalDateTime fechaFin;

    @NotNull(message = "El lugar es obligatorio")
    @Size (min = 3, max = 50, message = "El lugar debe tener entre 3 y 50 caracteres")
    private String lugar;

    @NotNull(message = "El tipo de evento es obligatorio")
    private TipoEvento tipoEvento;

    private String descripcion;
}