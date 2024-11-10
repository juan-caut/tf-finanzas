package com.tfinal.tf_finanzas.controller;

import com.tfinal.tf_finanzas.dto.UsuarioDTO;
import com.tfinal.tf_finanzas.dto.UsuarioRequest;
import com.tfinal.tf_finanzas.entities.Usuario;
import com.tfinal.tf_finanzas.service.UsuarioService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {
    @Autowired
    private UsuarioService revS;

    @PostMapping
    public void insert(@RequestBody UsuarioRequest dto) {
        System.out.println(dto);
        Usuario exite=  revS.getUsuariobyusername(dto.getUsername());
        System.out.println("agggg "+exite);

        if(exite==null) {
            try {
                ModelMapper m = new ModelMapper();
                revS.insert(dto);
            } catch (Exception e) {
                e.toString();
            }

        }
    }

    @GetMapping
    public List<UsuarioDTO> list() {
        return revS.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, UsuarioDTO.class);
        }).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public UsuarioDTO listId(@PathVariable("id") Integer id) {
        ModelMapper m = new ModelMapper();
        UsuarioDTO dto = m.map(revS.listId(id), UsuarioDTO.class);
        return dto;
    }

    @GetMapping("/get")
    public Usuario getUsuariobyusername(@RequestParam String username) {
        ModelMapper m = new ModelMapper();
        Usuario dto = m.map(revS.getUsuariobyusername(username), Usuario.class);
        return dto;
    }




    @GetMapping("/verification")
    public String verificationUser(@RequestParam("ident") String ident) {
        ModelMapper m = new ModelMapper();
        String str = revS.verificationUser(ident);
        return str;
    }

    @GetMapping("/login")
    public ResponseEntity<String> login( @RequestParam String username, @RequestParam String password) {

        if (!username.matches("[a-zA-Z0-9_]+")) {
            return ResponseEntity.ok("FALLA");
        } else if (!password.matches("[a-zA-Z0-9_]+")) {
            return ResponseEntity.ok("FALLA");
        }

        String value = revS.authUser(username, password);

        try {
            // Lógica principalgit
            if (value.matches("ACTIVO")) {
                return ResponseEntity.ok(value);
            } else {
                return ResponseEntity.ok("USUARIO INVALIDO");
            }
        } catch (Exception e) {
            // Manejo de la excepción
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("USUARIO INVALIDO");
        }


    }

}
