package com.lab7.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "lessons",
        uniqueConstraints = {@UniqueConstraint(columnNames = { "class_id", "time_id", "date" }) })
public class Lesson {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;



    @Column(name = "date")
    private Date date;

    @ManyToOne
    @JoinColumn(name = "class_id")
    private MyClass myClass;

    @ManyToOne
    @JoinColumn(name = "time_id")
    private MyTime myTime;

    @ManyToOne()
    @JoinColumn(name = "subject_id")
    private Subject subject;

    @OneToMany(mappedBy = "lesson")
    private List<MyRecord> myRecords;

    public Lesson(int id, Date date, MyClass myClass, MyTime myTime, Subject subject) {
        this.id = id;
        this.date = date;
        this.myClass = myClass;
        this.myTime = myTime;
        this.subject = subject;
    }
}
