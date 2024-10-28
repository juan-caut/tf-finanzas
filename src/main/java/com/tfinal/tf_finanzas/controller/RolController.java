package com.tfinal.tf_finanzas.controller;

import com.tfinal.tf_finanzas.entities.Rol;
import com.tfinal.tf_finanzas.service.RolService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/rol")
public class RolController {
    @Autowired
    private RolService revS;

    @PostMapping
    public void insert(@RequestBody Rol dto) {
        ModelMapper m = new ModelMapper();
        Rol p = m.map(dto, Rol.class);
        revS.insert(p);
    }

    @GetMapping
    public List<Rol> list() {
        return revS.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, Rol.class);
        }).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public Rol listId(@PathVariable("id") Integer id) {
        ModelMapper m = new ModelMapper();
        Rol dto=m.map(revS.listId(id),Rol.class);
        return dto;
    }

    @PutMapping
    public void update(@RequestBody Rol dto) {
        ModelMapper m = new ModelMapper();
        Rol p = m.map(dto, Rol.class);
        revS.insert(p);
    }


}
