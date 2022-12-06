package com.slaveyard.repositories;

import com.slaveyard.models.MyTime;
import org.springframework.data.jpa.repository.JpaRepository;


public interface MyTimeRepository extends JpaRepository<MyTime, Integer> {



}