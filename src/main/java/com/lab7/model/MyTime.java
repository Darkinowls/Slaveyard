package com.lab7.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;


import javax.persistence.*;
import java.sql.Time;
import java.util.List;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "times")
public class MyTime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "start")
    private Time start;

    @Column(name = "end")
    private Time end;

    @OneToMany(mappedBy = "myTime")
    private List<Lesson> lessons;

}
