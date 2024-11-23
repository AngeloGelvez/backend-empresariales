package com.hoteles.hotelesBackend.entidades;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

@Document(collection = "reservas")
public class Reserva {

    @Id
    private String id;
    private String fecha;
    private String hora;

    @DocumentReference
    private Usuario usuario;
    @DocumentReference
    private Hotel hotel;

    public Reserva() {
    }

    public Reserva(String id, String fecha, Usuario usuario, Hotel hotel, String hora) {
        this.id = id;
        this.fecha = fecha;
        this.usuario = usuario;
        this.hotel = hotel;
        this.hora = hora;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }
}
