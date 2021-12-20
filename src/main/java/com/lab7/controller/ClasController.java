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
import java.util.Objects;

@Controller
public class ClasController {

    private final String REDIRECT_CLASSES = "redirect:/classes";
    private final ClasService clasService;
    private final TeacherService teacherService;

    @Autowired
    public ClasController(ClasService clasService, TeacherService teacherService) {
        this.clasService = clasService;
        this.teacherService = teacherService;
    }

    @GetMapping("/classes")
    public String findAll(Model model) {
        List<Clas> classes = clasService.findAll();
        model.addAttribute("classes", classes);
        return "classes/classes";
    }

    @GetMapping("/classes/create")
    public String createClasForm(Clas clas, Model model) {
        List<Teacher> teachers = teacherService.findAll();
        model.addAttribute("teachers", teachers);
        return "classes/create";
    }

    @PostMapping("/classes/create")
    public String createClass(Clas clas, Model model) {

        if ((clasService.existsByName(clas.getName()))) {
            model.addAttribute("exist", true);
            return createClasForm(clas, model);
        }

        clasService.saveClas(clas);
        return REDIRECT_CLASSES;
    }

    @GetMapping("/classes/delete/{id}")
    public String deleteClas(@PathVariable("id") int id) {
        clasService.deleteById(id);
        return REDIRECT_CLASSES;
    }


    @GetMapping("/classes/update/{id}")
    public String updateClasForm(@PathVariable("id") int id, Model model) {

        Clas clas = clasService.findById(id);
        model.addAttribute("clas", clas);

        List<Teacher> teachers = teacherService.findAll();
        model.addAttribute("teachers", teachers);

        return "classes/update";
    }


    @PostMapping("/classes/update")
    public String updateClas(Clas clas, Model model) {

        Clas self = clasService.getByName(clas.getName());


        if (self == null || (self.getId() == clas.getId() && clas.getTeacher().getId() != self.getTeacher().getId())) {

            clasService.saveClas(clas);
            return REDIRECT_CLASSES;

        }


        model.addAttribute("exist", true);
        return updateClasForm(clas.getId(), model);


    }


}
