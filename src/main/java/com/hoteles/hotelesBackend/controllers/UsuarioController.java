package com.hoteles.hotelesBackend.controllers;

import com.hoteles.hotelesBackend.entidades.Usuario;
import com.hoteles.hotelesBackend.repository.UsuarioRepository;
import com.hoteles.hotelesBackend.utilidades.Respuesta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping("/todos")
    public Object todos() {
        //STATUS CODE 200
        try {
            return ResponseEntity.ok(usuarioRepository.findAll());
        }catch (Error e) {
            //STATUS CODE 500
            return Respuesta.responseJson("Ocurrio un error, no se encontraron usuarios", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public Object porId(@PathVariable String id) {
        try {
            //STATUS CODE 200
            Usuario usuario = usuarioRepository.findById(id).get();
            return ResponseEntity.ok(usuario);
        }catch (Error e) {
            //STATUS CODE 500
            return Respuesta.responseJson("Ocurrio un error, no se encontro ningun usuario", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/crear")
    public Object crear(@RequestBody Usuario usuario) {
        try {
            //STATUS CODE 200
            usuarioRepository.save(usuario);
            return Respuesta.responseJson("El usuario se creo correctamente", HttpStatus.OK);
        }catch (Error e) {
            //STATUS CODE 500
            return Respuesta.responseJson("Ocurrio un error, no se pudo crear el usuario", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/editar")
    //Pero el id debe de pasarse por el requestBody
    public Object editar(@RequestBody Usuario usuario) {
        try {
            //STATUS CODE 200
            usuarioRepository.save(usuario);
            return Respuesta.responseJson("El usuario se edito correctamente", HttpStatus.OK);
        }catch (Error e) {
            //STATUS CODE 500
            return Respuesta.responseJson("Ocurrio un error, no se pudo editar el usuario", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/eliminar/{id}")
    public Object eliminar(@PathVariable String id)  {
        try {
            //STATUS CODE 200
            usuarioRepository.deleteById(id);
            return Respuesta.responseJson("El usuario se elimino correctamente", HttpStatus.OK);
        }catch (Error e) {
            //STATUS CODE 500
            return Respuesta.responseJson("Ocurrio un error, no se pudo eliminar el usuario", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
