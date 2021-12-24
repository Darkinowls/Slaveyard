package com.lab7.service;

import com.lab7.MyHash;
import com.lab7.model.*;
import com.lab7.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.data.util.Pair;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    public Boolean existsByFirstNameAndSecondName(String firstName, String secondName) {
        return studentRepository.existsByFirstNameAndSecondName(firstName, secondName);
    }

    public Student getByFirstNameAndSecondName(String firstName, String secondName) {
        return studentRepository.getByFirstNameAndSecondName(firstName, secondName);
    }

    public MyHash getEvaluation(int id) {
        MyHash evaluations = new MyHash();
        Student student = findById(id);

        List<MyRecord> myRecords = student.getMyRecords();


        for (MyRecord mr : myRecords) {

            int grade = mr.getGrade();

            String name = mr.getLesson().getSubject().getName();

            evaluations.put(name, grade);

        }

        return evaluations;
    }

}
