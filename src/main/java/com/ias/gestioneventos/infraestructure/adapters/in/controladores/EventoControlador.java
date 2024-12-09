package com.ias.gestioneventos.infraestructure.adapters.in.controladores;

import com.ias.gestioneventos.application.eventoDTO.EventoDTO;
import com.ias.gestioneventos.application.mappers.EventoMapper;
import com.ias.gestioneventos.infraestructure.adapters.out.EventoServiceImpl;
import com.ias.gestioneventos.infraestructure.configuracionCors.ResponseWrapper;
import com.ias.gestioneventos.infraestructure.persistenceJPA.entityJPA.EventoJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/eventos")
public class EventoControlador {


    @Autowired
    private EventoMapper eventoMapper;

    @Autowired
    private EventoServiceImpl eventoServicioImpl;


    // Crear un nuevo evento
    @PostMapping
    public ResponseEntity<ResponseWrapper<EventoJPA>> crearEvento(@RequestBody EventoJPA evento) {
        try {
            EventoJPA eventoGuardado = eventoServicioImpl.crearEvento(evento);
            return ResponseEntity.ok(new ResponseWrapper<> (HttpStatus.OK.value(), "Evento creado exitosamente", eventoGuardado));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ResponseWrapper<> (HttpStatus.INTERNAL_SERVER_ERROR.value(), "Error al crear el evento", null));
        }
    }

    // Obtener todos los eventos

   //@GetMapping
   //public ResponseEntity<ResponseWrapper<List<EventoDTO>>> obtenerEventos() {
   //    try {
   //        List<EventoDTO> eventos = eventoServicioImpl.obtenerEventos().stream()
   //                .map(eventoMapper::toDTO)
   //                .collect(Collectors.toList());
   //        return ResponseEntity.ok(new ResponseWrapper<>(HttpStatus.OK.value(), "Eventos obtenidos exitosamente", eventos));
   //    } catch (Exception e) {
   //        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
   //                .body(new ResponseWrapper<>(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage(), null));
   //    }
   //}


   //// Crear un nuevo evento
   //@PostMapping
   //public ResponseEntity<ResponseWrapper<EventoDTO>> guardarEvento(@RequestBody EventoDTO eventoDTO) {
   //    try {
   //        EventoDTO eventoCreado = eventoMapper.toDTO(eventoServicioImpl.guardarEvento(eventoMapper.toDomain(eventoDTO)));
   //        return ResponseEntity.status(HttpStatus.CREATED)
   //                .body(new ResponseWrapper<>(HttpStatus.CREATED.value(), "Evento creado exitosamente", eventoCreado));
   //    } catch (Exception e) {
   //        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
   //                .body(new ResponseWrapper<>(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage(), null));
   //    }
   //}

   //// Actualizar un evento
   //@PutMapping("/{id}")
   //public ResponseEntity<ResponseWrapper<EventoDTO>> actualizarEvento(@PathVariable Long id, @RequestBody EventoDTO eventoDTO) {
   //    try {
   //        eventoDTO.setId(id);
   //        EventoDTO eventoActualizado = eventoMapper.toDTO(eventoServicioImpl.actualizarEvento(eventoMapper.toDomain(eventoDTO)));
   //        return ResponseEntity.ok(new ResponseWrapper<>(HttpStatus.OK.value(), "Evento actualizado exitosamente", eventoActualizado));
   //    } catch (IllegalArgumentException e) {
   //        return ResponseEntity.status(HttpStatus.NOT_FOUND)
   //                .body(new ResponseWrapper<>(HttpStatus.NOT_FOUND.value(), e.getMessage(), null));
   //    } catch (Exception e) {
   //        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
   //                .body(new ResponseWrapper<>(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage(), null));
   //    }
   //}
}
