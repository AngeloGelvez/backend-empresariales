package com.hoteles.hotelesBackend.controllers;

import com.hoteles.hotelesBackend.entidades.LoginEntity;
import com.hoteles.hotelesBackend.entidades.Usuario;
import com.hoteles.hotelesBackend.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
public class Login {

    @Autowired
    private UsuarioRepository usuarioRepository;


    @PostMapping()
    public Usuario validation(@RequestBody LoginEntity login) {
        try {
            Usuario usuario = usuarioRepository.findByCorreo(login.getEmail()).get();

            if(usuario.getContrasena().equals(login.getPassword()) && usuario.getTipoUsuario().equals(login.getTipoUsuario())) {
                return usuario;
            }else {
                throw new Error("No validado");
            }
        }catch (Error e) {
            return null;
        }
    }

}
