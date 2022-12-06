package com.slaveyard.repositories;

import com.slaveyard.models.MyClass;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ClasRepository extends JpaRepository<MyClass, Integer> {

    MyClass getByName(String name);
    Boolean existsByName(String name);


}