package com.ias.gestioneventos.infraestructure.persistenceJPA;

import com.ias.gestioneventos.domain.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UsuarioRepositorio extends JpaRepository<Usuario, Long> {


    Usuario findByNombreUsuario(Usuario nombreUsuario);

    Usuario findAllById(Usuario id);
}
