package com.lab7.controller;

import com.lab7.model.Clas;
import com.lab7.model.Student;
import com.lab7.service.ClasService;
import com.lab7.service.StudentService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class StudentController {


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
    public String createStudentForm(Model model, Student student) {
        List<Clas> classes = clasService.findAll();
        model.addAttribute("classes", classes);
        return "students/create";
    }

    @PostMapping("/students/create")
    public String createStudent(Student student) {
        studentService.saveStudent(student);
        return "redirect:/students";
    }

    @GetMapping("/students/delete/{id}")
    public String deleteStudent(@PathVariable("id") int id) {
        studentService.deleteById(id);
        return "redirect:/students";
    }


    @GetMapping("/students/update/{id}")
    public String updateStudentForm(@PathVariable("id") int id, Model model) {
        Student student = studentService.findById(id);
        model.addAttribute("student", student);

        List<Clas> classes = clasService.findAll();
        model.addAttribute("classes", classes);

        return "students/update";
    }


    @PostMapping("/students/update")
    public String updateStudent(Student student) {
        return createStudent(student);
    }

}
