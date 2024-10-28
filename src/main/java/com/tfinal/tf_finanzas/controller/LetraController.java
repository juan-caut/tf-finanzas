package com.tfinal.tf_finanzas.controller;

import com.tfinal.tf_finanzas.entities.Letra;
import com.tfinal.tf_finanzas.service.LetraService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/letra")
public class LetraController {

    @Autowired
    private LetraService revS;

    @PostMapping
    public void insert(@RequestBody Letra dto) {
        ModelMapper m = new ModelMapper();
        Letra p = m.map(dto, Letra.class);
        revS.insert(p);
    }

    @GetMapping
    public List<Letra> list() {
        return revS.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, Letra.class);
        }).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public Letra listId(@PathVariable("id") Integer id) {
        ModelMapper m = new ModelMapper();
        Letra dto=m.map(revS.listId(id),Letra.class);
        return dto;
    }

    @PutMapping
    public void update(@RequestBody Letra dto) {
        ModelMapper m = new ModelMapper();
        Letra p = m.map(dto, Letra.class);
        revS.insert(p);
    }


}
