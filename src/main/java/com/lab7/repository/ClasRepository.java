package com.lab7.repository;

import com.lab7.model.Clas;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ClasRepository extends JpaRepository<Clas, Integer> {

    Boolean existsByName(String name);

}