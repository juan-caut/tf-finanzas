package com.tfinal.tf_finanzas.controller;

import com.tfinal.tf_finanzas.entities.Log;
import com.tfinal.tf_finanzas.service.LogService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/log")
public class LogController {
    @Autowired
    private LogService revS;

    @PostMapping
    public void insert(@RequestBody Log dto) {
        ModelMapper m = new ModelMapper();
        Log p = m.map(dto, Log.class);
        revS.insert(p);
    }

    @GetMapping
    public List<Log> list() {
        return revS.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, Log.class);
        }).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public Log listId(@PathVariable("id") Integer id) {
        ModelMapper m = new ModelMapper();
        Log dto=m.map(revS.listId(id),Log.class);
        return dto;
    }

    @PutMapping
    public void update(@RequestBody Log dto) {
        ModelMapper m = new ModelMapper();
        Log p = m.map(dto, Log.class);
        revS.insert(p);
    }


}
