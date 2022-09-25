package com.lab7.controller;

import com.lab7.model.Teacher;
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

    private final String REDIRECT_TEACHERS = "redirect:/teachers";
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
    public String createTeacherForm(Teacher teacher, Model model) {
        return "teachers/create";
    }

    @PostMapping("/teachers/create")
    public String createTeacher(Teacher teacher, Model model) {

        if (Boolean.TRUE.equals(
                teacherService.existsByFirstNameAndSecondName(teacher.getFirstName(), teacher.getSecondName()))) {
            model.addAttribute("exist", true);
            return createTeacherForm(teacher, model);
        }

        teacherService.saveTeacher(teacher);
        return REDIRECT_TEACHERS;
    }

    @GetMapping("/teachers/delete/{id}")
    public String deleteTeacher(@PathVariable("id") int id) {
        teacherService.deleteById(id);
        return REDIRECT_TEACHERS;
    }


    @GetMapping("/teachers/update/{id}")
    public String updateTeacherForm(@PathVariable("id") int id, Model model) {
        Teacher teacher = teacherService.findById(id);
        model.addAttribute("teacher", teacher);
        return "teachers/update";
    }


    @PostMapping("/teachers/update")
    public String updateTeacher(Teacher teacher, Model model) {


        Teacher self = teacherService.getByFirstNameAndSecondName(teacher.getFirstName(), teacher.getSecondName());

        if (self == null || (self.getId() == teacher.getId() && self.getExperience() != teacher.getExperience())) {

            teacherService.saveTeacher(teacher);
            return REDIRECT_TEACHERS;

        }

        model.addAttribute("exist", true);
        return updateTeacherForm(teacher.getId(), model);

    }
}
