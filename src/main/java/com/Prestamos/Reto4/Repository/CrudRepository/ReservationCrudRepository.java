package com.Prestamos.Reto4.Repository.CrudRepository;

import com.Prestamos.Reto4.Entities.Reservation;
import org.springframework.data.repository.CrudRepository;

public interface ReservationCrudRepository extends CrudRepository<Reservation,Integer> {
}