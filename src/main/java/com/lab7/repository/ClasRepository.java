package com.lab7.repository;

import com.lab7.model.Clas;
import com.lab7.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ClasRepository extends JpaRepository<Clas, Integer> {

    Clas getByName(String name);
    Boolean existsByName(String name);


}