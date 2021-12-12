package com.lab7.controller;

import com.lab7.model.*;
import com.lab7.service.*;
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
    private final DayService dayService;
    private final MyTimeService myTimeService;
    private final SubjectService subjectService;

    @Autowired
    public LessonController(LessonService lessonService, ClasService clasService, DayService dayService, MyTimeService myTimeService, SubjectService subjectService) {
        this.lessonService = lessonService;
        this.clasService = clasService;
        this.dayService = dayService;
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
    public String createLessonForm(Model model, Lesson lesson) {

        List<Clas> classes = clasService.findAll();
        model.addAttribute("classes", classes);

        List<Day> days = dayService.findAll();
        model.addAttribute("days", days);

        List<MyTime> times = myTimeService.findAll();
        model.addAttribute("times", times);

        List<Subject> subjects = subjectService.findAll();
        model.addAttribute("subjects", subjects);


        return "lessons/create";
    }

    @PostMapping("/lessons/create")
    public String createLesson(Lesson lesson) {
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

        List<Clas> classes = clasService.findAll();
        model.addAttribute("classes", classes);

        List<Day> days = dayService.findAll();
        model.addAttribute("days", days);

        List<MyTime> times = myTimeService.findAll();
        model.addAttribute("times", times);

        List<Subject> subjects = subjectService.findAll();
        model.addAttribute("subjects", subjects);

        return "lessons/update";
    }


    @PostMapping("/lessons/update")
    public String updateLesson(Lesson lesson) {
        return createLesson(lesson);
    }

}
