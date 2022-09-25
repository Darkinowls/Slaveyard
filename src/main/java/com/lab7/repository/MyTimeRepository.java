package com.lab7.repository;

import com.lab7.model.MyTime;
import org.springframework.data.jpa.repository.JpaRepository;


public interface MyTimeRepository extends JpaRepository<MyTime, Integer> {



}