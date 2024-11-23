package com.hoteles.hotelesBackend.controllers;

import com.hoteles.hotelesBackend.entidades.Hotel;
import com.hoteles.hotelesBackend.repository.HotelRepository;
import com.hoteles.hotelesBackend.repository.ResenaRepository;
import com.hoteles.hotelesBackend.utilidades.Respuesta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/hotel")
public class HotelController {

    @Autowired
    private HotelRepository hotelRepository;

    @Autowired
    private ResenaRepository resenaRepository;

    @GetMapping("/todos")
    public Object todos() {
        //STATUS CODE 200
        try {
            return ResponseEntity.ok(hotelRepository.findAll());
        }catch (Error e) {
            //STATUS CODE 500
            return Respuesta.responseJson("Ocurrio un error, no se encontraron hoteles", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public Object porId(@PathVariable String id) {
        try {
            //STATUS CODE 200
            Hotel hotel = hotelRepository.findById(id).get();
            return ResponseEntity.ok(hotel);
        }catch (Error e) {
            //STATUS CODE 500
            return Respuesta.responseJson("Ocurrio un error, no se encontro ningun hotel", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/crear")
    public Object crear(@RequestBody Hotel hotel) {
        try {
            //STATUS CODE 200
            hotelRepository.save(hotel);
            return Respuesta.responseJson("El hotel se creo correctamente", HttpStatus.OK);
        }catch (Error e) {
            //STATUS CODE 500
            return Respuesta.responseJson("Ocurrio un error, no se pudo crear el hotel", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/editar")
    //Pero el id debe de pasarse por el requestBody
    public Object editar(@RequestBody Hotel hotel) {
        try {
            //STATUS CODE 200
            hotelRepository.save(hotel);
            return Respuesta.responseJson("El hotel se edito correctamente", HttpStatus.OK);
        }catch (Error e) {
            //STATUS CODE 500
            return Respuesta.responseJson("Ocurrio un error, no se pudo editar el hotel", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/eliminar/{id}")
    public Object eliminar(@PathVariable String id)  {
        try {
            //STATUS CODE 200
            hotelRepository.deleteById(id);
            return Respuesta.responseJson("El hotel se elimino correctamente", HttpStatus.OK);
        }catch (Error e) {
            //STATUS CODE 500
            return Respuesta.responseJson("Ocurrio un error, no se pudo eliminar el hotel", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
