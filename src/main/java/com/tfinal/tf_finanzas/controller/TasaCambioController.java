package com.tfinal.tf_finanzas.controller;

import com.tfinal.tf_finanzas.entities.TasaCambio;
import com.tfinal.tf_finanzas.service.TasaCambioService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/tasacambio")
public class TasaCambioController {
    @Autowired
    private TasaCambioService revS;

    @PostMapping
    public void insert(@RequestBody TasaCambio dto) {
        ModelMapper m = new ModelMapper();
        TasaCambio p = m.map(dto, TasaCambio.class);
        revS.insert(p);
    }

    @GetMapping
    public List<TasaCambio> list() {
        return revS.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, TasaCambio.class);
        }).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public TasaCambio listId(@PathVariable("id") Integer id) {
        ModelMapper m = new ModelMapper();
        TasaCambio dto=m.map(revS.listId(id),TasaCambio.class);
        return dto;
    }

    @PutMapping
    public void update(@RequestBody TasaCambio dto) {
        ModelMapper m = new ModelMapper();
        TasaCambio p = m.map(dto, TasaCambio.class);
        revS.insert(p);
    }


}
