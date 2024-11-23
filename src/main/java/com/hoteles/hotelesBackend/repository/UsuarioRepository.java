package com.hoteles.hotelesBackend.repository;

import com.hoteles.hotelesBackend.entidades.Usuario;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends MongoRepository<Usuario, String> {

    // Método para buscar un usuario por su correo
    Optional<Usuario> findByCorreo(String correo);
}
