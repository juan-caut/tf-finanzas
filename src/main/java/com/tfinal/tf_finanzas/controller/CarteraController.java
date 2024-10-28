package com.tfinal.tf_finanzas.controller;

import com.tfinal.tf_finanzas.entities.Cartera;
import com.tfinal.tf_finanzas.service.CarteraService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/cartera")
public class CarteraController {
    @Autowired
    private CarteraService revS;

    @PostMapping
    public void insert(@RequestBody Cartera dto) {
        ModelMapper m = new ModelMapper();
        Cartera p = m.map(dto, Cartera.class);
        revS.insert(p);
    }

    @GetMapping
    public List<Cartera> list() {
        return revS.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, Cartera.class);
        }).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public Cartera listId(@PathVariable("id") Integer id) {
        ModelMapper m = new ModelMapper();
        Cartera dto=m.map(revS.listId(id),Cartera.class);
        return dto;
    }

    @PutMapping
    public void update(@RequestBody Cartera dto) {
        ModelMapper m = new ModelMapper();
        Cartera p = m.map(dto, Cartera.class);
        revS.insert(p);
    }


}
