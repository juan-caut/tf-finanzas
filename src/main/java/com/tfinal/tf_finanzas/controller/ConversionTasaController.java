package com.tfinal.tf_finanzas.controller;

import com.tfinal.tf_finanzas.entities.ConversionTasa;
import com.tfinal.tf_finanzas.service.ConversionTasaService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/conversiontasa")
public class ConversionTasaController {
    @Autowired
    private ConversionTasaService revS;

    @PostMapping
    public ResponseEntity<BigDecimal> insert(@RequestBody ConversionTasa dto) {
        System.out.println("Solicitud recibida de conversiontasa: "+dto.getTasaNominal());
        ModelMapper m = new ModelMapper();
        ConversionTasa p = m.map(dto, ConversionTasa.class);
        return ResponseEntity.ok(revS.insert(p));

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
