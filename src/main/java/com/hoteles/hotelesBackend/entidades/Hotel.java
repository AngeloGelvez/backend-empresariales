package com.hoteles.hotelesBackend.entidades;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.util.List;

@Document(collection = "hoteles")
public class Hotel {

    @Id
    private String id;
    private String nombre;
    private String descripcion;
    private String direccion;
    private String urlImagen;
    private String puntaje;

    //Lista de reseñas API DE RESEÑAS
    //@DocumentReference
    //private List<Resena> resenas;

    public Hotel() {
    }

    public Hotel(String id, String nombre, String descripcion, String direccion, String urlImagen, String puntaje) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.direccion = direccion;
        this.urlImagen = urlImagen;
        this.puntaje = puntaje;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getUrlImagen() {
        return urlImagen;
    }

    public void setUrlImagen(String urlImagen) {
        this.urlImagen = urlImagen;
    }

    public String getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(String puntaje) {
        this.puntaje = puntaje;
    }
}
