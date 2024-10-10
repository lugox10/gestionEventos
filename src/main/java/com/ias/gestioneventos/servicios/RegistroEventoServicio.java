package com.ias.gestioneventos.servicios;

import com.ias.gestioneventos.model.RegistroEvento;
import com.ias.gestioneventos.model.Usuario;
import com.ias.gestioneventos.model.Eventos;
import com.ias.gestioneventos.repositorios.EventoRepositorio;
import com.ias.gestioneventos.repositorios.RegistroEventoRepositorio;
import com.ias.gestioneventos.repositorios.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegistroEventoServicio {

    @Autowired
    private RegistroEventoRepositorio registroEventoRepository;

    @Autowired
    private UsuarioRepositorio usuarioRepository;

    @Autowired
    private EventoRepositorio eventosRepository;

    // Método para registrar un usuario en un evento
    public RegistroEvento registrarUsuarioEnEvento(Long usuarioId, Long eventoId) {
        Usuario usuario = usuarioRepository.findById(usuarioId).orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        Eventos evento = eventosRepository.findById(eventoId).orElseThrow(() -> new RuntimeException("Evento no encontrado"));

        RegistroEvento registroEvento = new RegistroEvento();
        registroEvento.setUsuario(usuario);
        registroEvento.setEvento(evento);

        return registroEventoRepository.save(registroEvento);
    }

    // Método para obtener eventos por usuario
    public List<RegistroEvento> obtenerEventosPorUsuario(Long usuarioId) {
        return registroEventoRepository.findByUsuarioId(usuarioId);
    }

    // Método para obtener usuarios por evento
    public List<RegistroEvento> obtenerUsuariosPorEvento(Long eventoId) {
        return registroEventoRepository.findByEventoId(eventoId);
    }
}
