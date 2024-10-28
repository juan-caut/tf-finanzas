package com.tfinal.tf_finanzas.controller;

import com.tfinal.tf_finanzas.entities.ConversionTasa;
import com.tfinal.tf_finanzas.service.ConversionTasaService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/conversiontasa")
public class ConversionTasaController {
    @Autowired
    private ConversionTasaService revS;

    @PostMapping
    public void insert(@RequestBody ConversionTasa dto) {
        ModelMapper m = new ModelMapper();
        ConversionTasa p = m.map(dto, ConversionTasa.class);
        revS.insert(p);
    }

    @GetMapping
    public List<ConversionTasa> list() {
        return revS.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, ConversionTasa.class);
        }).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ConversionTasa listId(@PathVariable("id") Integer id) {
        ModelMapper m = new ModelMapper();
        ConversionTasa dto=m.map(revS.listId(id),ConversionTasa.class);
        return dto;
    }

    @PutMapping
    public void update(@RequestBody ConversionTasa dto) {
        ModelMapper m = new ModelMapper();
        ConversionTasa p = m.map(dto, ConversionTasa.class);
        revS.insert(p);
    }


}
