package com.slaveyard.controllers;

import com.slaveyard.models.*;
import com.slaveyard.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class LessonController {

    private final LessonService lessonService;
    private final ClasService clasService;
    private final MyTimeService myTimeService;
    private final SubjectService subjectService;

    @Autowired
    public LessonController(LessonService lessonService, ClasService clasService, MyTimeService myTimeService, SubjectService subjectService) {
        this.lessonService = lessonService;
        this.clasService = clasService;
        this.myTimeService = myTimeService;
        this.subjectService = subjectService;
    }


    @GetMapping("/lessons")
    public String findAll(Model model) {
        List<Lesson> lessons = lessonService.findAll();
        model.addAttribute("lessons", lessons);
        return "lessons/lessons";
    }

    @GetMapping("/lessons/create")
    public String createLessonForm(Lesson lesson, Model model) {

        List<MyClass> classes = clasService.findAll();
        model.addAttribute("classes", classes);

        List<MyTime> times = myTimeService.findAll();
        model.addAttribute("times", times);

        List<Subject> subjects = subjectService.findAll();
        model.addAttribute("subjects", subjects);


        return "lessons/create";
    }

    @PostMapping("/lessons/create")
    public String createLesson(Lesson lesson, Model model) {

        if (Boolean.TRUE.equals(lessonService.existsByClasAndDateAndMyTime(lesson.getMyClass(), lesson.getDate(), lesson.getMyTime()))) {
            model.addAttribute("exist", true);
            return createLessonForm(lesson, model);
        }


        lessonService.saveLesson(lesson);
        return "redirect:/lessons";
    }

    @GetMapping("/lessons/delete/{id}")
    public String deleteLesson(@PathVariable("id") int id) {
        lessonService.deleteById(id);
        return "redirect:/lessons";
    }


    @GetMapping("/lessons/update/{id}")
    public String updateLessonForm(@PathVariable("id") int id, Model model) {

        Lesson lesson = lessonService.findById(id);
        model.addAttribute("lesson", lesson);

        List<MyClass> classes = clasService.findAll();
        model.addAttribute("classes", classes);

        List<MyTime> times = myTimeService.findAll();
        model.addAttribute("times", times);

        List<Subject> subjects = subjectService.findAll();
        model.addAttribute("subjects", subjects);

        return "lessons/update";
    }


    @PostMapping("/lessons/update")
    public String updateLesson(Lesson lesson, Model model) {


        Lesson self = lessonService.getByClasAndDateAndMyTime(lesson.getMyClass(), lesson.getDate(), lesson.getMyTime());


        if (self == null || (self.getId() == lesson.getId() && self.getSubject().getId() != lesson.getSubject().getId())) {

            lessonService.saveLesson(lesson);
            return "redirect:/lessons";

        }


        model.addAttribute("exist", true);
        return updateLessonForm(lesson.getId(), model);


    }

}
