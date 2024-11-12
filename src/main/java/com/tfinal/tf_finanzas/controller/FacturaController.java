package com.tfinal.tf_finanzas.controller;

import com.tfinal.tf_finanzas.dto.FacturaDTO;
import com.tfinal.tf_finanzas.entities.Factura;
import com.tfinal.tf_finanzas.service.CarteraService;
import com.tfinal.tf_finanzas.service.FacturaService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/factura")
public class FacturaController {
    @Autowired
    private FacturaService revS;
    @Autowired
    private CarteraService carS;

    @PostMapping("/insert")
    public void insert(@RequestBody FacturaDTO dto) {
        ModelMapper m = new ModelMapper();
        Factura p = m.map(dto, Factura.class);

        System.out.println("BUSCANDO CARTERA POR  ID: "+dto.getIdcartera());
        p.setCartera(carS.listId(dto.getIdcartera()));
        revS.insert(p);
    }

    @GetMapping()
    public List<FacturaDTO> list() {
        return revS.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, FacturaDTO.class);
        }).collect(Collectors.toList());
    }
    @GetMapping("/listart")
    public List<FacturaDTO> listpcart(@RequestParam int carteraId) {
        return revS.findAllByCarteraIs(carteraId).stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, FacturaDTO.class);
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


}
