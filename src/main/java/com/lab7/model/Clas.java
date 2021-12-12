package com.lab7.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "classes")
@AllArgsConstructor
@NoArgsConstructor
public class Clas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "teachers_id")
    private Teacher teacher;

    @OneToMany(mappedBy = "clas")
    private List<Student> students;

}
