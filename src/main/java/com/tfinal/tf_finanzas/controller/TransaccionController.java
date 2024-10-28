package com.tfinal.tf_finanzas.controller;

import com.tfinal.tf_finanzas.entities.Transaccion;
import com.tfinal.tf_finanzas.service.TransaccionService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/transaccion")
public class TransaccionController {

    @Autowired
    private TransaccionService revS;

    @PostMapping
    public void insert(@RequestBody Transaccion dto) {
        ModelMapper m = new ModelMapper();
        Transaccion p = m.map(dto, Transaccion.class);
        revS.insert(p);
    }

    @GetMapping
    public List<Transaccion> list() {
        return revS.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, Transaccion.class);
        }).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public Transaccion listId(@PathVariable("id") Integer id) {
        ModelMapper m = new ModelMapper();
        Transaccion dto=m.map(revS.listId(id),Transaccion.class);
        return dto;
    }

    @PutMapping
    public void update(@RequestBody Transaccion dto) {
        ModelMapper m = new ModelMapper();
        Transaccion p = m.map(dto, Transaccion.class);
        revS.insert(p);
    }


}
