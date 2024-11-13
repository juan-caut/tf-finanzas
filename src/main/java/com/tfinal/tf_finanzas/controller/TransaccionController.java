package com.tfinal.tf_finanzas.controller;

import com.tfinal.tf_finanzas.dto.TransaccionDTO;
import com.tfinal.tf_finanzas.dto.TransaccionDTO2;
import com.tfinal.tf_finanzas.entities.*;
import com.tfinal.tf_finanzas.service.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
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

    @Autowired
    private LetraService letS;
    @Autowired
    private FacturaService facS;


    @PostMapping
    public void insert(@RequestBody TransaccionDTO2 dto) {
               revS.insert2(dto);
    }

    @PostMapping("/transacart")
    public void insert(@RequestBody TransaccionDTO dto) {
        ModelMapper m = new ModelMapper();

        if (Objects.equals(carsS.listId(dto.getId_cartera()).getTipoDoc(), "LETRA")){

            List<Letra> letrascart=letS.findAllByCarteraIs(dto.getId_cartera());
            for (Letra letra:letrascart){
                TransaccionDTO2 t2 = m.map(dto, TransaccionDTO2.class);
                t2.setIdletra(letra.getIdLetra());

                revS.insert2(t2);

            }
            List<Transaccion> transacion=revS.listporcartera(carsS.listId(dto.getId_cartera()));
            for (Transaccion trans:transacion){
                descS.descontar(trans.getIdTransaccion());
            }

        }else if (Objects.equals(carsS.listId(dto.getId_cartera()).getTipoDoc(), "FACTURA")){

            List<Factura> facturascart=facS.findAllByCarteraIs(dto.getId_cartera());
            for (Factura factura:facturascart){
                TransaccionDTO2 t2 = m.map(dto, TransaccionDTO2.class);
                t2.setIdfactura(factura.getIdFactura());
                revS.insert2(t2);
            }
            List<Transaccion> transaccion=revS.listporcartera(carsS.listId(dto.getId_cartera()));
            for (Transaccion trans:transaccion){
                descS.descontar(trans.getIdTransaccion());
            }
        }



    }


    /// ====NOAPLICAR
    /*
    @PostMapping("peligronousar")
    public void insertvarios(@RequestBody TransaccionDTO dto) {

        revS.insertvarios(dto);

        List<Transaccion> listtra = revS.listporcartera(carsS.listId(dto.getId_cartera()));

        System.out.println("descontarndo transacciones: ");

        if (listtra != null) {
            for (Transaccion t : listtra) {
                descS.insertDesc(t.getIdTransaccion());
            }
        }

    }
*/


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
        return m.map(revS.listId(id), Transaccion.class);
    }
    @GetMapping("/trapletr/{idlet}")
    public TransaccionDTO2 listpletra(@PathVariable("idlet") Integer idlet) {
        ModelMapper m = new ModelMapper();
        return m.map(revS.listplet(idlet), TransaccionDTO2.class);
    }
    @GetMapping("/trapfact/{idfac}")
    public TransaccionDTO2 listpfact(@PathVariable("idfac") Integer idfac) {
        ModelMapper m = new ModelMapper();
        return m.map(revS.listpfac(idfac),TransaccionDTO2.class);
    }
    @GetMapping("/trapcart/{idcar}")
    public TransaccionDTO2 listpcart(@PathVariable("idcar") Integer idcar) {
        ModelMapper m = new ModelMapper();
        return m.map(revS.listpcar(idcar),TransaccionDTO2.class);
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
