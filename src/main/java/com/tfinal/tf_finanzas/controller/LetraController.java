package com.tfinal.tf_finanzas.controller;

import com.tfinal.tf_finanzas.dto.LetraDTO;
import com.tfinal.tf_finanzas.entities.Letra;
import com.tfinal.tf_finanzas.service.LetraService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/letra")
public class LetraController {

    @Autowired
    private LetraService revS;

    @PostMapping
    public void insert(@RequestBody LetraDTO dto) {
        System.out.println("Solicitud recibida en /save con datos: "+dto.getNumeroLetra());

        ModelMapper m = new ModelMapper();
        LetraDTO p = m.map(dto, LetraDTO.class);
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
        revS.insertuptade(p);
    }
    @GetMapping("/letraByCartera")
    public List<Letra> findAllByCarteraIs(@RequestParam int carteraId){
        ModelMapper m = new ModelMapper();
        return revS.findAllByCarteraIs(carteraId);
    }

}
