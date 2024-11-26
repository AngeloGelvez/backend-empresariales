package com.hoteles.hotelesBackend.controllers;

import com.hoteles.hotelesBackend.entidades.Resena;
import com.hoteles.hotelesBackend.repository.HotelRepository;
import com.hoteles.hotelesBackend.repository.ResenaRepository;
import com.hoteles.hotelesBackend.repository.UsuarioRepository;
import com.hoteles.hotelesBackend.utilidades.Respuesta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/resena")
public class ResenaController {

    @Autowired
    private ResenaRepository resenaRepository;

    @Autowired
    private HotelRepository hotelRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping("/todos")
    public Object todos() {
        //STATUS CODE 200
        try {
            return ResponseEntity.ok(resenaRepository.findAll());
        }catch (Error e) {
            //STATUS CODE 500
            return Respuesta.responseJson("Ocurrio un error, no se encontraron resenas", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public Object porId(@PathVariable String id) {
        try {
            //STATUS CODE 200
            Resena resena = resenaRepository.findById(id).get();
            return ResponseEntity.ok(resena);
        }catch (Error e) {
            //STATUS CODE 500
            return Respuesta.responseJson("Ocurrio un error, no se encontro ninguna resena", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/todas/usuario/{idUsuario}")
    public Object todosHotelesUsuarios(@PathVariable String idUsuario) {
        try {
            return resenaRepository.findByUsuario_Id(idUsuario);
        }catch(Error e) {
            return Respuesta.responseJson("Ocurrio un error", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //BUSCAR RESENAS POR ID DEL HOTEL
    @GetMapping("/todas/{idHotel}")
    public Object idHotel(@PathVariable String idHotel) {
        try {
            //STATUS CODE 200
            return resenaRepository.findByHotel_Id(idHotel);
        }catch (Error e) {
            //STATUS CODE 500
            return Respuesta.responseJson("Ocurrio un error", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/crear/{idHotel}/{idUsuario}")
    public Object crear(@RequestBody Resena resena, @PathVariable String idHotel, @PathVariable String idUsuario) {
        resena.setUsuario(usuarioRepository.findById(idUsuario).get());
        resena.setHotel(hotelRepository.findById(idHotel).get());

        try {
            //STATUS CODE 200
            resenaRepository.save(resena);
            return Respuesta.responseJson("La resena se creo correctamente", HttpStatus.OK);
        }catch (Error e) {
            //STATUS CODE 500
            return Respuesta.responseJson("Ocurrio un error, no se pudo crear la resena", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /*
    @PutMapping("/editar")
    //Pero el id debe de pasarse por el requestBody
    public Object editar(@RequestBody Resena resena) {
        try {
            //STATUS CODE 200
            resenaRepository.save(resena);
            return Respuesta.responseJson("La resena se edito correctamente", HttpStatus.OK);
        }catch (Error e) {
            //STATUS CODE 500
            return Respuesta.responseJson("Ocurrio un error, no se pudo editar la resena", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
     */

    @DeleteMapping("/eliminar/{id}")
    public Object eliminar(@PathVariable String id)  {
        try {
            //STATUS CODE 200
            resenaRepository.deleteById(id);
            return Respuesta.responseJson("La resena se elimino correctamente", HttpStatus.OK);
        }catch (Error e) {
            //STATUS CODE 500
            return Respuesta.responseJson("Ocurrio un error, no se pudo eliminar la resena", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
