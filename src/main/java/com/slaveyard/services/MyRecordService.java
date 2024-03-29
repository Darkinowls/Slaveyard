package com.slaveyard.services;

import com.slaveyard.models.Lesson;
import com.slaveyard.models.MyRecord;
import com.slaveyard.models.Student;
import com.slaveyard.repositories.MyRecordRepository;
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

    public MyRecord getByStudentAndLesson(Student student, Lesson lesson){
        return  myRecordRepository.getByStudentAndLesson(student, lesson);
    }


}
