package com.hoteles.hotelesBackend.repository;

import com.hoteles.hotelesBackend.entidades.Reserva;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservaRepository extends MongoRepository<Reserva, String> {
}
