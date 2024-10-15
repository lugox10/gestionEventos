package com.ias.gestioneventos.servicios;

import com.ias.gestioneventos.model.Eventos;
import com.ias.gestioneventos.model.Usuario;
import com.ias.gestioneventos.repositorios.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public Usuario regisrarEnEvento(Usuario id){
        return usuarioRepositorio.findAllById(id);
    }



}
