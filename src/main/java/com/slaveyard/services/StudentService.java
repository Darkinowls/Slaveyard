package com.slaveyard.services;

import com.slaveyard.helpers.Evaluation;
import com.slaveyard.models.*;
import com.slaveyard.repositories.StudentRepository;
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

    public Boolean existsByFirstNameAndSecondName(String firstName, String secondName) {
        return studentRepository.existsByFirstNameAndSecondName(firstName, secondName);
    }

    public Student getByFirstNameAndSecondName(String firstName, String secondName) {
        return studentRepository.getByFirstNameAndSecondName(firstName, secondName);
    }

    public Evaluation getEvaluation(int id) {
        Evaluation evaluations = new Evaluation();
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
