CREATE USER 'spring_user'@'localhost' IDENTIFIED BY 'spring!';

create database spring_db;

GRANT ALL PRIVILEGES ON spring_db.* TO 'spring_user'@'localhost';

use spring_db;

create table if not exists spring_db.teachers
(
    id                int auto_increment
        primary key,
    first_name        varchar(255) not null,
    second_name       varchar(255) not null,
    experience_months int          null
);

create table if not exists spring_db.classes
(
    id         int auto_increment
        primary key,
    name       varchar(255) not null,
    teacher_id int(255)     not null,
    constraint classes_fk0
        foreign key (teacher_id) references spring_db.teachers (id)
);

create table if not exists spring_db.students
(
    id          int auto_increment
        primary key,
    class_id    int          not null,
    first_name  varchar(255) null,
    second_name varchar(255) null,
    constraint students_fk0
        foreign key (class_id) references spring_db.classes (id)
);

create table if not exists spring_db.subjects
(
    id         int auto_increment
        primary key,
    name       varchar(255) not null,
    teacher_id int          not null,
    constraint subjects_teachers_id_fk
        foreign key (teacher_id) references spring_db.teachers (id)
);

create table if not exists spring_db.times
(
    id    int auto_increment
        primary key,
    start time not null,
    end   time not null
);

insert into spring_db.times (start, end)
VALUES ('9:00:00', '10:00:00'),
       ('10:10:00', '11:10:00'),
       ('11:20:00', '12:20:00'),
       ('12:40:00', '13:40:00');

create table if not exists spring_db.lessons
(
    id         int auto_increment
        primary key,
    date       date not null,
    class_id   int  not null,
    time_id    int  not null,
    subject_id int  not null,
    constraint lessons_ibfk_1
        foreign key (class_id) references spring_db.classes (id),
    constraint lessons_ibfk_2
        foreign key (time_id) references spring_db.times (id),
    constraint lessons_ibfk_3
        foreign key (subject_id) references spring_db.subjects (id)
);

create table if not exists spring_db.records
(
    id         int auto_increment
        primary key,
    student_id int not null,
    grade      int null,
    lesson_id  int not null,
    constraint foreign_key_name
        foreign key (lesson_id) references spring_db.lessons (id),
    constraint students_objects_fk0
        foreign key (student_id) references spring_db.students (id)
);


