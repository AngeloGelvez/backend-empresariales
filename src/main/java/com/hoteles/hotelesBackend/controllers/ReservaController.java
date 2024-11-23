package com.hoteles.hotelesBackend.controllers;

import com.hoteles.hotelesBackend.entidades.Reserva;
import com.hoteles.hotelesBackend.repository.HotelRepository;
import com.hoteles.hotelesBackend.repository.ReservaRepository;
import com.hoteles.hotelesBackend.repository.UsuarioRepository;
import com.hoteles.hotelesBackend.utilidades.Respuesta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/reserva")
public class ReservaController {

    @Autowired
    private ReservaRepository reservaRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private HotelRepository hotelRepository;

    @GetMapping("/todos")
    public Object todos() {
        //STATUS CODE 200
        try {
            return ResponseEntity.ok(reservaRepository.findAll());
        }catch (Error e) {
            //STATUS CODE 500
            return Respuesta.responseJson("Ocurrio un error, no se encontraron reservas", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public Object porId(@PathVariable String id) {
        try {
            //STATUS CODE 200
            Reserva reserva = reservaRepository.findById(id).get();
            return ResponseEntity.ok(reserva);
        }catch (Error e) {
            //STATUS CODE 500
            return Respuesta.responseJson("Ocurrio un error, no se encontro ninguna reserva", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/crear/{idHotel}/{idUsuario}")
    public Object crear(@RequestBody Reserva reserva, @PathVariable String idHotel, @PathVariable String idUsuario) {
        try {
            reserva.setUsuario(usuarioRepository.findById(idUsuario).get());
            reserva.setHotel(hotelRepository.findById(idHotel).get());

            //STATUS CODE 200
            reservaRepository.save(reserva);
            return Respuesta.responseJson("La reserva se creo correctamente", HttpStatus.OK);
        }catch (Error e) {
            //STATUS CODE 500
            return Respuesta.responseJson("Ocurrio un error, no se pudo crear", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /*
    @PutMapping("/editar")
    //Pero el id debe de pasarse por el requestBody
    public Object editar(@RequestBody Reserva reserva) {
        try {
            //STATUS CODE 200
            reservaRepository.save(reserva);
            return Respuesta.responseJson("La reserva se edito correctamente", HttpStatus.OK);
        }catch (Error e) {
            //STATUS CODE 500
            return Respuesta.responseJson("Ocurrio un error, no se pudo editar la reserva", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
     */

    @DeleteMapping("/eliminar/{id}")
    public Object eliminar(@PathVariable String id)  {
        try {
            //STATUS CODE 200
            reservaRepository.deleteById(id);
            return Respuesta.responseJson("La reserva se elimino correctamente", HttpStatus.OK);
        }catch (Error e) {
            //STATUS CODE 500
            return Respuesta.responseJson("Ocurrio un error, no se pudo eliminar la reserva", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
