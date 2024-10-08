package com.ias.gestioneventos.repositorios;

import com.ias.gestioneventos.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UsuarioRepositorio extends JpaRepository<Usuario, Long> {
    Usuario findByNombreUsuario(Usuario nombreUsuario);
}
