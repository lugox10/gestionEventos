package com.ias.gestioneventos.servicios;

import com.ias.gestioneventos.model.Eventos;
import com.ias.gestioneventos.model.Usuario;
import com.ias.gestioneventos.repositorios.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.time.LocalDateTime;
import java.util.List;

@Service
public class UsuarioServicio {

    @Autowired
    private UsuarioRepositorio usuarioRepositorio;


    public Usuario registrarUsuario(Usuario usuario) {
        return usuarioRepositorio.save(usuario);
    }

    public List<Usuario> obtenerUsuarios() {
        return usuarioRepositorio.findAll();
    }

    public List<Eventos> obtenerEventosPorUsuario(Long usuarioId) {
        return usuarioRepositorio.findById(usuarioId).map(Usuario::getEventos).orElse(null);
    }


    public Usuario registrarEnEvento(Usuario usuario, Eventos evento) throws Exception {
        // Verificar si el usuario o evento son nulos
        if (usuario == null || evento == null) {
            throw new IllegalArgumentException("El usuario o el evento no pueden ser nulos");
        }

        // Obtener la lista de eventos actuales del usuario
        List<Eventos> eventosUsuario = usuario.getEventos();

        // Validar si el usuario ya está registrado en el evento
        if (eventosUsuario.contains(evento)) {
            throw new Exception("El usuario ya está registrado en este evento");
        }

        // Validar si el evento está dentro del rango de fechas válidas
        LocalDateTime fechaActual = LocalDateTime.now();
        if (fechaActual.isBefore(evento.getFechaInicio()) || fechaActual.isAfter(evento.getFechaFin())) {
            throw new Exception("El evento no está disponible para el registro en estas fechas");
        }

        // Añadir el evento a la lista de eventos del usuario
        eventosUsuario.add(evento);
        usuario.setEventos(eventosUsuario);

        // Guardar el usuario actualizado en el repositorio
        return usuarioRepositorio.save(usuario);
    }






}
