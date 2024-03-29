package com.slaveyard.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import javax.persistence.*;

import java.util.List;


@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "students",
        uniqueConstraints = {@UniqueConstraint(columnNames = {"first_name", "second_name"})})
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "second_name")
    private String secondName;

    @ManyToOne
    @JoinColumn(name = "class_id")
    private MyClass myClass;

    @OneToMany(mappedBy = "student")
    private List<MyRecord> myRecords;

    public Student(int id, String firstName, String secondName, MyClass myClass) {
        this.id = id;
        this.firstName = firstName;
        this.secondName = secondName;
        this.myClass = myClass;
    }

    public String getGrade() {
        float size = 0;
        float sum = 0;
        for (MyRecord r : myRecords) {

            if (r.getGrade() > 0) {
                sum += r.getGrade();
                size++;
            }
        }
        if (size == 0) return "0";

        return String.format("%.2f", sum / size);
    }

    public String getPresence() {
        float all = 0;
        float absence = 0;
        for (MyRecord r : myRecords) {
            all++;

            if (r.getGrade() == 0) {
                absence++;
            }
        }

        if (all == 0 || (all - absence) == 0) return "0";

        return String.format("%.2f", (all - absence) / all * 100);
    }



}
