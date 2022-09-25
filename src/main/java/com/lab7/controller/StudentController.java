package com.lab7.controller;

import com.lab7.model.MyClass;

import com.lab7.model.Student;
import com.lab7.service.ClasService;
import com.lab7.service.StudentService;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.*;

@Controller
public class StudentController {


    private final String REDIRECT_STUDENTS = "redirect:/students";
    private final StudentService studentService;
    private final ClasService clasService;

    @Autowired
    public StudentController(StudentService studentService, ClasService clasService) {
        this.studentService = studentService;
        this.clasService = clasService;
    }

    @GetMapping("/students")
    public String findAll(Model model) {
        List<Student> students = studentService.findAll();
        model.addAttribute("students", students);
        return "students/students";
    }

    @GetMapping("/students/create")
    public String createStudentForm(Student student, Model model) {
        List<MyClass> aClasses = clasService.findAll();
        model.addAttribute("classes", aClasses);
        return "students/create";
    }


    @GetMapping("/students/details/{id}")
    public String goToDetails(@PathVariable("id") int id, Model model) {


        model.addAttribute("student", studentService.findById(id));

        model.addAttribute("evals", studentService.getEvaluation(id));


        return "students/details";
    }

    @PostMapping("/students/create")
    public String createStudent(Student student, Model model) {

        if (Boolean.TRUE.equals(
                studentService.existsByFirstNameAndSecondName(student.getFirstName(), student.getSecondName()))) {
            model.addAttribute("exist", true);
            return createStudentForm(student, model);
        }

        studentService.saveStudent(student);
        return REDIRECT_STUDENTS;
    }

    @GetMapping("/students/delete/{id}")
    public String deleteStudent(@PathVariable("id") int id) {
        studentService.deleteById(id);
        return REDIRECT_STUDENTS;
    }


    @GetMapping("/students/update/{id}")
    public String updateStudentForm(@PathVariable("id") int id, Model model) {
        Student student = studentService.findById(id);
        model.addAttribute("student", student);

        List<MyClass> aClasses = clasService.findAll();
        model.addAttribute("classes", aClasses);

        return "students/update";
    }


    @PostMapping("/students/update")
    public String updateStudent(Student student, Model model) {


        Student self = studentService.getByFirstNameAndSecondName(student.getFirstName(), student.getSecondName());

        if (self == null || (self.getId() == student.getId() && self.getMyClass().getId() != student.getMyClass().getId())) {

            studentService.saveStudent(student);
            return REDIRECT_STUDENTS;

        }


        model.addAttribute("exist", true);
        return updateStudentForm(student.getId(), model);


    }

}
