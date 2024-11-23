package com.hoteles.hotelesBackend.entidades;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

@Document(collection = "resenas")
public class Resena {

    @Id
    private String id;
    private String descripcion;
    private int puntaje;

    @DocumentReference
    private Usuario usuario;

    @DocumentReference
    private Hotel hotel;

    public Resena() {
    }

    public Resena(String id, String descripcion, int puntaje, Usuario usuario, Hotel hotel) {
        this.id = id;
        this.descripcion = descripcion;
        this.puntaje = puntaje;
        this.usuario = usuario;
        this.hotel = hotel;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
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
}
