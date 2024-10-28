package com.tfinal.tf_finanzas.controller;

import com.tfinal.tf_finanzas.entities.EstadoLetFac;
import com.tfinal.tf_finanzas.service.EstadoLetFacService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/estadoletrafactura")
public class EstadoLetFacController {
    @Autowired
    private EstadoLetFacService revS;

    @PostMapping
    public void insert(@RequestBody EstadoLetFac dto) {
        ModelMapper m = new ModelMapper();
        EstadoLetFac p = m.map(dto, EstadoLetFac.class);
        revS.insert(p);
    }

    @GetMapping
    public List<EstadoLetFac> list() {
        return revS.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, EstadoLetFac.class);
        }).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public EstadoLetFac listId(@PathVariable("id") Integer id) {
        ModelMapper m = new ModelMapper();
        EstadoLetFac dto=m.map(revS.listId(id),EstadoLetFac.class);
        return dto;
    }

    @PutMapping
    public void update(@RequestBody EstadoLetFac dto) {
        ModelMapper m = new ModelMapper();
        EstadoLetFac p = m.map(dto, EstadoLetFac.class);
        revS.insert(p);
    }


}
