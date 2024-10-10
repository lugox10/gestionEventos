package com.ias.gestioneventos.servicios;

import com.ias.gestioneventos.model.Eventos;
import com.ias.gestioneventos.model.TipoEvento;
import com.ias.gestioneventos.model.Usuario;
import com.ias.gestioneventos.repositorios.EventoRepositorio;
import com.ias.gestioneventos.repositorios.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventoServicioImpl {

    @Autowired
    private EventoServicio eventoServicio;

    @Autowired
    private DescripEventoServicio descripEventoServicio;

    @Autowired
    private EventoRepositorio eventoRepositorio;

    @Autowired
    UsuarioRepositorio usuarioRepositorio;


    // Método para obtener todos los eventos
    public List<Eventos> obtenerEventos() {
        return eventoServicio.obtenerEventos();
    }

    // Refactorizando el método guardarEvento para asociar la descripción
    public Eventos guardarEvento(Eventos evento) {
        // llamamos el metodo obtenerDescripcionPorTipoEvento para obtener la descripción y anexarla al evento
        String descripcion = obtenerDescripcionPorTipoEvento(evento.getTipoEvento());
        if (descripcion != null) {
            evento.setDescripcion(descripcion);
        }
        return eventoServicio.guardarEvento(evento);
    }

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

    public Eventos actualizarEvento(Eventos eventoActualizado) {
        Eventos eventoExistente = eventoServicio.actualizarEvento(eventoActualizado);
        if (eventoExistente != null) {
            eventoExistente.setFechaInicio(eventoActualizado.getFechaInicio());
            eventoExistente.setFechaFin(eventoActualizado.getFechaFin());
            eventoExistente.setLugar(eventoActualizado.getLugar());
            eventoExistente.setTipoEvento(eventoActualizado.getTipoEvento());
            // Reasignamos la descripción con base en el nuevo tipo de evento, si ha cambiado
            String nuevaDescripcion = obtenerDescripcionPorTipoEvento(eventoActualizado.getTipoEvento());
            eventoExistente.setDescripcion(nuevaDescripcion);
            return eventoServicio.actualizarEvento(eventoExistente);
        }
        return null; // Devuelve null si no se encuentra el evento
    }

    public List<Eventos> obtenerEventosPorTipo( TipoEvento tipoEvento) {
        return eventoRepositorio.findAllByTipoEvento(tipoEvento);
    }


    // Registrar un usuario en un evento
    public void registrarEnEvento(Long idUsuario, Long idEvento) {
        Usuario usuario = usuarioRepositorio.findById(idUsuario).orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        Eventos evento = eventoRepositorio.findById(idEvento).orElseThrow(() -> new RuntimeException("Evento no encontrado"));
        usuario.getEventos().add(evento);
        usuarioRepositorio.save(usuario);
    }



}




