package com.lab7.controller;

import com.lab7.model.Clas;
import com.lab7.model.Teacher;
import com.lab7.service.ClasService;
import com.lab7.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class TeacherController {

    private final TeacherService teacherService;

    @Autowired
    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @GetMapping("/teachers")
    public String findAll(Model model) {
        List<Teacher> teachers = teacherService.findAll();
        model.addAttribute("teachers", teachers);
        return "teachers/teachers";
    }

    @GetMapping("/teachers/create")
    public String createTeacherForm(Model model, Teacher teacher) {
        return "teachers/create";
    }

    @PostMapping("/teachers/create")
    public String createTeacher(Teacher teacher) {
        teacherService.saveTeacher(teacher);
        return "redirect:/teachers";
    }

    @GetMapping("/teachers/delete/{id}")
    public String deleteTeacher(@PathVariable("id") int id) {
        teacherService.deleteById(id);
        return "redirect:/teachers";
    }


    @GetMapping("/teachers/update/{id}")
    public String updateTeacherForm(@PathVariable("id") int id, Model model) {
        Teacher teacher = teacherService.findById(id);
        model.addAttribute("teacher", teacher);
        return "teachers/update";
    }


    @PostMapping("/teachers/update")
    public String updateTeacher(Teacher teacher) {
        return createTeacher(teacher);
    }
}
