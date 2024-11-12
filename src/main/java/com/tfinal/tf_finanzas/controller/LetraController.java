package com.tfinal.tf_finanzas.controller;

import com.tfinal.tf_finanzas.dto.LetraDTO;
import com.tfinal.tf_finanzas.dto.LetraeditDTO;
import com.tfinal.tf_finanzas.entities.Letra;
import com.tfinal.tf_finanzas.service.LetraService;
import com.tfinal.tf_finanzas.service.TransaccionService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    @Autowired
    private TransaccionService transaccionService;

    @PostMapping("")
    public ResponseEntity<Letra> crearLetra(@RequestBody LetraDTO letraDTO) {
        Letra nuevaLetra = revS.insert(letraDTO);
        return new ResponseEntity<>(nuevaLetra, HttpStatus.CREATED);
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
        Letra dto = m.map(revS.listId(id), Letra.class);
        return dto;
    }

    @PutMapping("/actualizacion")
    public void update(@RequestBody LetraeditDTO dto) {
        ModelMapper m = new ModelMapper();
        revS.insertuptade(dto);
    }

    @GetMapping("/letraByCartera")
    public List<Letra> findAllByCarteraIs(@RequestParam int carteraId) {
        ModelMapper m = new ModelMapper();
        return revS.findAllByCarteraIs(carteraId);
    }

    @DeleteMapping("/eliminar")
    public ResponseEntity<Void> eliminarletra(@RequestParam Integer id) {
        try {
            revS.delete(id, transaccionService);
            return new ResponseEntity<>(HttpStatus.OK); // Estado 202, sin contenido
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); // Estado 404 si no se encuentra el recurso
        }
    }
}
