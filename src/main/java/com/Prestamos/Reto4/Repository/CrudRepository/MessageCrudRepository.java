package com.Prestamos.Reto4.Repository.CrudRepository;

import com.Prestamos.Reto4.Entities.Message;
import org.springframework.data.repository.CrudRepository;

public interface MessageCrudRepository extends CrudRepository<Message, Integer> {
}