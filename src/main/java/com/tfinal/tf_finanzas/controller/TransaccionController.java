package com.tfinal.tf_finanzas.controller;

import com.tfinal.tf_finanzas.dto.TransaccionDTO;
import com.tfinal.tf_finanzas.dto.TransaccionDTO2;
import com.tfinal.tf_finanzas.entities.Cartera;
import com.tfinal.tf_finanzas.entities.Descuento;
import com.tfinal.tf_finanzas.entities.Transaccion;
import com.tfinal.tf_finanzas.service.CarteraService;
import com.tfinal.tf_finanzas.service.DescuentoService;
import com.tfinal.tf_finanzas.service.TransaccionService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/transaccion")
public class TransaccionController {

    @Autowired
    private TransaccionService revS;

    @Autowired
    private DescuentoService descS;

    @Autowired
    private CarteraService carsS;


    @PostMapping
    public void insert(@RequestBody TransaccionDTO2 dto) {
        ModelMapper m = new ModelMapper();
        TransaccionDTO2 p = m.map(dto, TransaccionDTO2.class);
        revS.insert2(p);
    }

    @PostMapping("/descontarletras")
    public void insertvarios(@RequestBody TransaccionDTO dto) {
        ModelMapper m = new ModelMapper();
        TransaccionDTO p = m.map(dto, TransaccionDTO.class);
        revS.insertvarios(p);

        List<Transaccion> listtra = revS.listporcartera(carsS.listId(dto.getId_cartera()));

        System.out.println("descontarndo transacciones: ");

        if (listtra != null) {
            for (Transaccion t : listtra) {
                descS.insertDesc(t.getIdTransaccion());
            }
        }

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
        Transaccion dto = m.map(revS.listId(id), Transaccion.class);
        return dto;
    }

    @GetMapping("/trapletr/{idlet}")
    public TransaccionDTO2 listpletra(@PathVariable("idlet") Integer idlet) {
        ModelMapper m = new ModelMapper();
        TransaccionDTO2 dto = m.map(revS.listplet(idlet), TransaccionDTO2.class);
        return dto;
    }

    @GetMapping("/trapfact/{idlet}")
    public TransaccionDTO2 listpfact(@PathVariable("idlet") Integer idlet) {
        ModelMapper m = new ModelMapper();
        TransaccionDTO2 dto=m.map(revS.listpfac(idlet),TransaccionDTO2.class);
        return dto;
    }


    @PutMapping
    public void update(@RequestBody Transaccion dto) {
        ModelMapper m = new ModelMapper();
        Transaccion p = m.map(dto, Transaccion.class);
        revS.insert(p);
    }

    @PutMapping("/updatecosts")
    public void updateCosts(@RequestParam("id") Integer id) {
        revS.updateCosts(id);
    }

    @DeleteMapping("/delelete")
    public void delete(@RequestParam int id) {
        revS.delete(id);
    }
}
