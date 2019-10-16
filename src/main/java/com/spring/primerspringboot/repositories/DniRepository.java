package com.spring.primerspringboot.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.spring.primerspringboot.models.Cliente;
import com.spring.primerspringboot.models.Dni;
@Repository
public interface DniRepository extends CrudRepository<Dni, Integer> {

}
