package com.lab7.repository;

import com.lab7.model.MyClass;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ClasRepository extends JpaRepository<MyClass, Integer> {

    MyClass getByName(String name);
    Boolean existsByName(String name);


}