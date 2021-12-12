package com.lab7.repository;

import com.lab7.model.MyRecord;
import org.springframework.data.jpa.repository.JpaRepository;



public interface MyRecordRepository extends JpaRepository<MyRecord, Integer> {



}