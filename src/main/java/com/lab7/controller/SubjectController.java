package com.lab7.controller;

import com.lab7.model.Lesson;
import com.lab7.model.Subject;
import com.lab7.model.Teacher;
import com.lab7.service.LessonService;
import com.lab7.service.SubjectService;
import com.lab7.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class SubjectController {

    private final SubjectService subjectService;
    private final TeacherService teacherService;

    @Autowired
    public SubjectController(SubjectService subjectService, TeacherService teacherService, LessonService scheduleService) {
        this.subjectService = subjectService;
        this.teacherService = teacherService;
    }

    @GetMapping("/subjects")
    public String findAll(Model model) {
        List<Subject> subjects = subjectService.findAll();
        model.addAttribute("subjects", subjects);
        return "subjects/subjects";
    }

    @GetMapping("/subjects/create")
    public String createSubjectForm( Subject subject, Model model) {

        List<Teacher> teachers = teacherService.findAll();
        model.addAttribute("teachers", teachers);

        return "subjects/create";
    }

    @PostMapping("/subjects/create")
    public String createSubject(Subject subject, Model model) {

        if(Boolean.TRUE.equals(subjectService.existsByNameAndTeacher(subject.getName(), subject.getTeacher()))) {
            model.addAttribute("exist", true);
            return createSubjectForm(subject, model);
        }

        subjectService.saveSubject(subject);
        return "redirect:/subjects";
    }

    @GetMapping("/subjects/delete/{id}")
    public String deleteSubject(@PathVariable("id") int id) {
        subjectService.deleteById(id);
        return "redirect:/subjects";
    }


    @GetMapping("/subjects/update/{id}")
    public String updateSubjectForm(@PathVariable("id") int id, Model model) {
        Subject subject = subjectService.findById(id);
        model.addAttribute("subject", subject);

        List<Teacher> teachers = teacherService.findAll();
        model.addAttribute("teachers", teachers);

        return "subjects/update";
    }


    @PostMapping("/subjects/update")
    public String updateSubject(Subject subject, Model model) {


        if(Boolean.TRUE.equals(subjectService.existsByNameAndTeacher(subject.getName(), subject.getTeacher()))) {
            model.addAttribute("exist", true);
            return updateSubjectForm(subject.getId(), model);
        }


        subjectService.saveSubject(subject);
        return "redirect:/subjects";

    }
}
