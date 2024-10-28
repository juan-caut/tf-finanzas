package com.tfinal.tf_finanzas.controller;

import com.tfinal.tf_finanzas.entities.Coste;
import com.tfinal.tf_finanzas.service.CosteService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/coste")
public class CosteController {
    @Autowired
    private CosteService revS;

    @PostMapping
    public void insert(@RequestBody Coste dto) {
        ModelMapper m = new ModelMapper();
        Coste p = m.map(dto, Coste.class);
        revS.insert(p);
    }

    @GetMapping
    public List<Coste> list() {
        return revS.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, Coste.class);
        }).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public Coste listId(@PathVariable("id") Integer id) {
        ModelMapper m = new ModelMapper();
        Coste dto=m.map(revS.listId(id),Coste.class);
        return dto;
    }

    @PutMapping
    public void update(@RequestBody Coste dto) {
        ModelMapper m = new ModelMapper();
        Coste p = m.map(dto, Coste.class);
        revS.insert(p);
    }


}
