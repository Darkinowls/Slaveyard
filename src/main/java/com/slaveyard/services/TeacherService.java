package com.slaveyard.services;

import com.slaveyard.models.Teacher;
import com.slaveyard.repositories.TeacherRepository;
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

    public void saveTeacher(Teacher teacher) {
        teacherRepository.save(teacher);
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
