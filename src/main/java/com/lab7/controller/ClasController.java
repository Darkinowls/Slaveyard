package com.lab7.controller;

import com.lab7.model.MyClass;
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
        List<MyClass> aClasses = clasService.findAll();
        model.addAttribute("classes", aClasses);
        return "classes/classes";
    }

    @GetMapping("/classes/create")
    public String createClasForm(MyClass myClass, Model model) {
        List<Teacher> teachers = teacherService.findAll();
        model.addAttribute("teachers", teachers);
        return "classes/create";
    }

    @PostMapping("/classes/create")
    public String createClass(MyClass myClass, Model model) {

        if ((clasService.existsByName(myClass.getName()))) {
            model.addAttribute("exist", true);
            return createClasForm(myClass, model);
        }

        clasService.saveClas(myClass);
        return REDIRECT_CLASSES;
    }

    @GetMapping("/classes/delete/{id}")
    public String deleteClas(@PathVariable("id") int id) {
        clasService.deleteById(id);
        return REDIRECT_CLASSES;
    }


    @GetMapping("/classes/update/{id}")
    public String updateClasForm(@PathVariable("id") int id, Model model) {

        MyClass myClass = clasService.findById(id);
        model.addAttribute("clas", myClass);

        List<Teacher> teachers = teacherService.findAll();
        model.addAttribute("teachers", teachers);

        return "classes/update";
    }


    @PostMapping("/classes/update")
    public String updateClas(MyClass myClass, Model model) {

        MyClass self = clasService.getByName(myClass.getName());


        if (self == null || (self.getId() == myClass.getId() && myClass.getTeacher().getId() != self.getTeacher().getId())) {

            clasService.saveClas(myClass);
            return REDIRECT_CLASSES;

        }

        model.addAttribute("exist", true);
        return updateClasForm(myClass.getId(), model);


    }


}
