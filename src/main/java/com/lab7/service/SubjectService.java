package com.lab7.service;

import com.lab7.model.Subject;
import com.lab7.repository.SubjectRepository;
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




}
