package com.lab7.repository;

import com.lab7.model.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;


public interface LessonRepository extends JpaRepository<Lesson, Integer> {



}