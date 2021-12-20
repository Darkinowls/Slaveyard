package com.lab7.controller;

import com.lab7.model.*;
import com.lab7.model.MyRecord;
import com.lab7.service.LessonService;
import com.lab7.service.MyRecordService;
import com.lab7.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Objects;

@Controller
public class MyRecordController {

    private final String REDIRECT_RECORDS = "redirect:/records";
    private final MyRecordService myRecordService;
    private final LessonService lessonService;
    private final StudentService studentService;

    public MyRecordController(MyRecordService myRecordService, LessonService lessonService, StudentService studentService) {
        this.myRecordService = myRecordService;
        this.lessonService = lessonService;
        this.studentService = studentService;
    }


    @GetMapping("/records")
    public String findAll(Model model) {
        List<MyRecord> records = myRecordService.findAll();
        model.addAttribute("records", records);
        return "records/records";
    }

    @GetMapping("/records/create")
    public String createRecordForm(MyRecord myRecord, Model model) {

        List<Student> students = studentService.findAll();
        model.addAttribute("students", students);

        List<Lesson> lessons = lessonService.findAll();
        model.addAttribute("lessons", lessons);


        return "records/create";
    }

    @PostMapping("/records/create")
    public String createMyRecord(MyRecord myRecord, Model model) {

        if (Boolean.TRUE.equals(
                myRecordService.existsByStudentAndLesson(myRecord.getStudent(), myRecord.getLesson()))) {
            model.addAttribute("exist", true);
            return createRecordForm(myRecord, model);
        }

        myRecordService.saveMyRecord(myRecord);
        return REDIRECT_RECORDS;
    }

    @GetMapping("/records/delete/{id}")
    public String deleteMyRecord(@PathVariable("id") int id) {
        myRecordService.deleteById(id);
        return REDIRECT_RECORDS;
    }


    @GetMapping("/records/update/{id}")
    public String updateMyRecordForm(@PathVariable("id") int id, Model model) {
        MyRecord myRecord = myRecordService.findById(id);
        model.addAttribute("myRecord", myRecord);

        List<Student> students = studentService.findAll();
        model.addAttribute("students", students);

        List<Lesson> lessons = lessonService.findAll();
        model.addAttribute("lessons", lessons);

        return "records/update";
    }


    @PostMapping("/records/update")
    public String updateMyRecord(MyRecord myRecord, Model model) {


        MyRecord self = myRecordService.getByStudentAndLesson(myRecord.getStudent(), myRecord.getLesson());


        if (self == null || (self.getId() == myRecord.getId() && !Objects.equals(self.getGrade(), myRecord.getGrade()))) {

            myRecordService.saveMyRecord(myRecord);
            return REDIRECT_RECORDS;

        }


        model.addAttribute("exist", true);
        return updateMyRecordForm(myRecord.getId(), model);


    }


}
