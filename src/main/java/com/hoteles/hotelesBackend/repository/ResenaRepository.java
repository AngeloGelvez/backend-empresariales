package com.hoteles.hotelesBackend.repository;

import com.hoteles.hotelesBackend.entidades.Resena;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ResenaRepository extends MongoRepository<Resena, String> {

    // Método para encontrar reseñas por el ID del hotel
    List<Resena> findByHotel_Id(String hotelId);
}
