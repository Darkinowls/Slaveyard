package com.lab7.service;

import com.lab7.model.Clas;
import com.lab7.model.Teacher;
import com.lab7.repository.ClasRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ClasService {

    private final ClasRepository clasRepository;

    @Autowired
    public ClasService(ClasRepository clasRepository) {
        this.clasRepository = clasRepository;
    }


    public Clas findById(int id) {
        return clasRepository.findById(id).orElse(null);
    }

    public List<Clas> findAll() {
        return clasRepository.findAll();
    }

    public Clas saveClas(Clas clas) {
        return clasRepository.save(clas);

    }

    public Boolean existsByName(String name) {
        return clasRepository.existsByName(name);
    }

    public Clas getByName(String name) {
        return clasRepository.getByName(name);
    }


    public void deleteById(int id) {
        clasRepository.deleteById(id);
    }


}
