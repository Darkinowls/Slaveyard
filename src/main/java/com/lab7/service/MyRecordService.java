package com.lab7.service;

import com.lab7.model.Lesson;
import com.lab7.model.MyRecord;
import com.lab7.model.Student;
import com.lab7.repository.MyRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MyRecordService {

    private final MyRecordRepository myRecordRepository;

    @Autowired
    public MyRecordService(MyRecordRepository myRecordRepository) {
        this.myRecordRepository = myRecordRepository;
    }


    public MyRecord findById(int id){
        return myRecordRepository.findById(id).orElse(null);
    }

    public List<MyRecord> findAll(){
        return myRecordRepository.findAll();
    }

    public MyRecord saveMyRecord(MyRecord myRecord){
        return myRecordRepository.save(myRecord);
    }

    public void deleteById(int id){
        myRecordRepository.deleteById(id);
    }

    public Boolean existsByStudentAndLesson(Student student, Lesson lesson){
        return  myRecordRepository.existsByStudentAndLesson(student, lesson);
    }



}
