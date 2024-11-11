package com.tfinal.tf_finanzas.controller;

import com.tfinal.tf_finanzas.entities.Descuento;
import com.tfinal.tf_finanzas.service.DescuentoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/descuento")
public class DescuentoController {
    @Autowired
    private DescuentoService revS;

    @PostMapping
    public void insert(@RequestBody Descuento dto) {
        ModelMapper m = new ModelMapper();
        Descuento p = m.map(dto, Descuento.class);
        revS.insert(p);
    }

    @GetMapping
    public List<Descuento> list() {
        return revS.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, Descuento.class);
        }).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public Descuento listId(@PathVariable("id") Integer id) {
        ModelMapper m = new ModelMapper();
        Descuento dto=m.map(revS.listId(id),Descuento.class);
        return dto;
    }

    @PutMapping
    public void update(@RequestBody Descuento dto) {
        ModelMapper m = new ModelMapper();
        Descuento p = m.map(dto, Descuento.class);
        revS.insert(p);
    }
    @PutMapping("/calcdescuento")
    public void insertDesc(@RequestParam("idtransac") Integer id) {

        revS.insertDesc(id);
    }


}
