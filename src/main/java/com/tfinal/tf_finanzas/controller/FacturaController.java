package com.tfinal.tf_finanzas.controller;

import com.tfinal.tf_finanzas.entities.Factura;
import com.tfinal.tf_finanzas.service.FacturaService;
import com.tfinal.tf_finanzas.service.TransaccionService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/factura")
public class FacturaController {
    @Autowired
    private FacturaService revS;
    @Autowired
    private TransaccionService transaccionService;
    @PostMapping
    public void insert(@RequestBody Factura dto) {
        ModelMapper m = new ModelMapper();
        Factura p = m.map(dto, Factura.class);
        revS.insert(p);
    }

    @GetMapping
    public List<Factura> list() {
        return revS.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, Factura.class);
        }).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public Factura listId(@PathVariable("id") Integer id) {
        ModelMapper m = new ModelMapper();
        Factura dto=m.map(revS.listId(id),Factura.class);
        return dto;
    }

    @PutMapping
    public void update(@RequestBody Factura dto) {
        ModelMapper m = new ModelMapper();
        Factura p = m.map(dto, Factura.class);
        revS.insert(p);
    }

    @DeleteMapping("/eliminar")
    public ResponseEntity<Void> eliminarFactura(@RequestParam Integer id) {
        try {
            revS.delete(id, transaccionService);
            return new ResponseEntity<>(HttpStatus.OK); // Estado 202, sin contenido
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); // Estado 404 si no se encuentra el recurso
        }
    }
}
