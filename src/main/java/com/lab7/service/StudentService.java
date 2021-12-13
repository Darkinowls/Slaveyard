package com.lab7.service;

import com.lab7.model.Student;
import com.lab7.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class StudentService {

    private final StudentRepository studentRepository;


    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student findById(int id) {
        return studentRepository.findById(id).orElse(null);
    }

    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    public void deleteById(int id) {
        studentRepository.deleteById(id);
    }

    public Boolean existsByFirstNameAndSecondName(String firstName, String secondName){
        return studentRepository.existsByFirstNameAndSecondName(firstName, secondName);
    }

}
