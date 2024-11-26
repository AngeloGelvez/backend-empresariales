package com.hoteles.hotelesBackend.repository;

import com.hoteles.hotelesBackend.entidades.Reserva;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservaRepository extends MongoRepository<Reserva, String> {

    List<Reserva> findByUsuario_Id(String idUsuario);

    List<Reserva> findByHotel_id(String idHotel);
}
