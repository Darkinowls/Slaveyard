package com.slaveyard.services;

import com.slaveyard.models.Subject;
import com.slaveyard.models.Teacher;
import com.slaveyard.repositories.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SubjectService {

    private final SubjectRepository subjectRepository;

    @Autowired
    public SubjectService(SubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
    }


    public Subject findById(int id){
        return subjectRepository.findById(id).orElse(null);
    }

    public List<Subject> findAll(){
        return subjectRepository.findAll();
    }

    public Subject saveSubject(Subject subject){
        return subjectRepository.save(subject);
    }

    public void deleteById(int id){
        subjectRepository.deleteById(id);
    }

    public boolean existsByNameAndTeacher(String name, Teacher teacher){
        return subjectRepository.existsByNameAndTeacher(name, teacher);
    }


}
