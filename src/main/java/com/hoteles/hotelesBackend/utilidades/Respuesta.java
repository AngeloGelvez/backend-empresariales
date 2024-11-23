package com.hoteles.hotelesBackend.utilidades;

import org.springframework.http.HttpStatus;

import java.util.HashMap;

public class Respuesta {

    public static HashMap<String, Object> responseJson(String mensaje, HttpStatus status) {
        HashMap<String, Object> response = new HashMap<>();

        response.put("Mensaje", mensaje);
        response.put("Estado Http", status);

        return response;
    }
}
