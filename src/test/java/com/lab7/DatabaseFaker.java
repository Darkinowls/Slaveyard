package com.lab7;

import com.lab7.model.*;
import com.lab7.repository.*;
import net.datafaker.Faker;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Date;
import java.util.Random;
import java.util.stream.IntStream;


@SpringBootTest
class DatabaseFaker {

    final private Faker faker = new Faker();


    @Autowired
    private TeacherRepository teacherRepository;

    @Autowired
    private ClasRepository clasRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private SubjectRepository subjectRepository;

    @Autowired
    private LessonRepository lessonRepository;


    @Autowired
    private MyTimeRepository myTimeRepository;

    @Autowired
    private MyRecordRepository myRecordRepository;

//    @Test
//    void loadAll(){
//        loadTeachers();
//        loadClasses();
//        loadStudents();
//        loadSubjects();
//        loadLessons();
//        loadRecords();
//    }
       
    void loadTeachers() {
        IntStream.range(0, 100)
                .forEach((i) -> teacherRepository
                        .save(new Teacher(
                                i,
                                faker.name().firstName(),
                                faker.name().lastName(),
                                new Random().nextInt(1, 400)
                        )));
    }

       
    void loadClasses() {
        IntStream.range(0, 25)
                .forEach((i) -> clasRepository
                        .save(new MyClass(
                                i,
                                faker.bothify("??-##"),
                                teacherRepository.getById(new Random().nextInt(1, 100))
                        )));
    }

   
    void loadStudents() {
        IntStream.range(0, 1799)
                .forEach((i) -> studentRepository
                        .save(new Student(
                                i,
                                faker.name().firstName(),
                                faker.name().lastName(),
                                clasRepository.getById(new Random().nextInt(1, 25))
                        )));
    }


    void loadSubjects() {

        IntStream.range(0, 300)
                .forEach((i) -> subjectRepository
                        .save(new Subject(
                                i,
                                faker.job().field(),
                                teacherRepository.getById(new Random().nextInt(1, 100))
                        )));
    }


    @Test
    void loadLessons() {

        IntStream.range(0, 300)
                .forEach((i) -> lessonRepository
                        .save(new Lesson(
                                i,
                                new Date(faker.date().birthday(0,2).getTime()),
                                clasRepository.getById(new Random().nextInt(1, 25)),
                                myTimeRepository.getById(new Random().nextInt(1, 6)),
                                subjectRepository.getById(new Random().nextInt(1, 300))
                        )));
    }

   
    void loadRecords() {

        IntStream.range(0, 5000)
                .forEach((i) -> myRecordRepository
                        .save(new MyRecord(
                                i,
                                new Random().nextInt(1, 13),
                                studentRepository.getById(new Random().nextInt(1, 1799)),
                                lessonRepository.getById(new Random().nextInt(1, 500))

                        )));
    }


}
