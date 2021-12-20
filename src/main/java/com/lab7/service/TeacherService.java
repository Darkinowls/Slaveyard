package com.lab7.service;

import com.lab7.model.Teacher;
import com.lab7.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TeacherService {


    private final TeacherRepository teacherRepository;


    @Autowired
    public TeacherService(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    public Teacher findById(int id) {
        return teacherRepository.findById(id).orElse(null);
    }

    public List<Teacher> findAll() {
        return teacherRepository.findAll();
    }

    public Teacher saveTeacher(Teacher student) {
        return teacherRepository.save(student);
    }

    public void deleteById(int id) {
        teacherRepository.deleteById(id);
    }

    public Boolean existsByFirstNameAndSecondName(String firstName, String secondName){
        return teacherRepository.existsByFirstNameAndSecondName(firstName, secondName);
    }

    public Teacher getByFirstNameAndSecondName(String firstName, String secondName){
        return teacherRepository.getByFirstNameAndSecondName(firstName, secondName);
    }


}
