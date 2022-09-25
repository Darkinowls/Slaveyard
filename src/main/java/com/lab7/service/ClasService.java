package com.lab7.service;

import com.lab7.model.MyClass;
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


    public MyClass findById(int id) {
        return clasRepository.findById(id).orElse(null);
    }

    public List<MyClass> findAll() {
        return clasRepository.findAll();
    }

    public MyClass saveClas(MyClass myClass) {
        return clasRepository.save(myClass);

    }

    public Boolean existsByName(String name) {
        return clasRepository.existsByName(name);
    }

    public MyClass getByName(String name) {
        return clasRepository.getByName(name);
    }


    public void deleteById(int id) {
        clasRepository.deleteById(id);
    }


}
