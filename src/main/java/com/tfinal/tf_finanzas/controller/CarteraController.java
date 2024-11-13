package com.tfinal.tf_finanzas.controller;

import com.tfinal.tf_finanzas.dto.CarteraDTO;
import com.tfinal.tf_finanzas.dto.ReporteDTO;
import com.tfinal.tf_finanzas.entities.Cartera;
import com.tfinal.tf_finanzas.service.CarteraService;
import com.tfinal.tf_finanzas.service.FacturaService;
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
@RequestMapping("/api/cartera")
public class CarteraController {
    @Autowired
    private CarteraService revS;
    @Autowired
    private TransaccionService transaccionService;
    @Autowired
    private LetraService letraService;
    @Autowired
    private FacturaService facturaService;
    @PostMapping("")
    public Cartera insert(@RequestBody CarteraDTO dto) {
        ModelMapper m = new ModelMapper();
        Cartera p = m.map(dto, Cartera.class);
        revS.insert(p);
        return p;
    }

    @GetMapping
    public List<Cartera> list() {
        return revS.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, Cartera.class);
        }).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public CarteraDTO listId(@PathVariable("id") Integer id) {
        ModelMapper m = new ModelMapper();
        CarteraDTO dto = m.map(revS.listId(id), CarteraDTO.class);
        return dto;
    }

    @PutMapping
    public void update(@RequestBody Cartera dto) {
        ModelMapper m = new ModelMapper();
        Cartera p = m.map(dto, Cartera.class);
        //   revS.insert(dto);
    }

    @GetMapping("/carteraByUser")
    public List<Cartera> getCarterasByUsuarioId(@RequestParam int usuarioId) {
        return (revS.getCarterasByUsuarioId(usuarioId));
    }

    @GetMapping("/carterareport")
    public List<ReporteDTO> getcarterasreport(@RequestParam int idcar) {

        return (revS.getreport(idcar));
    }

    @DeleteMapping("/eliminar")
    public ResponseEntity<Void> eliminarCartera(@RequestParam Integer id) {
        try {
            revS.delete(id, transaccionService,letraService,facturaService);
            return new ResponseEntity<>(HttpStatus.OK); // Estado 202, sin contenido
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); // Estado 404 si no se encuentra el recurso
        }
    }
}
