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
@Table(name = "teachers")
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "second_name")
    private String secondName;

    @Column(name = "experience_months")
    private int experience;

    @OneToMany(mappedBy = "teacher")
    private List<Subject> subjects;

    public Teacher(int id, String firstName, String secondName, int experience) {
        this.id = id;
        this.firstName = firstName;
        this.secondName = secondName;
        this.experience = experience;
    }
}
