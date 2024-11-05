package com.tfinal.tf_finanzas.controller;

import com.tfinal.tf_finanzas.dto.UsuarioDTO;
import com.tfinal.tf_finanzas.entities.Usuario;
import com.tfinal.tf_finanzas.service.UsuarioService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {
    @Autowired
    private UsuarioService revS;

    @PostMapping
    public void insert(@RequestBody Usuario dto) {
        ModelMapper m = new ModelMapper();
        Usuario p = m.map(dto, Usuario.class);
        revS.insert(p);
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
        UsuarioDTO dto=m.map(revS.listId(id),UsuarioDTO.class);
        return dto;
    }
    @GetMapping("/get/{username}")
    public Usuario getUsuariobyusername(@PathVariable String username) {
        ModelMapper m = new ModelMapper();
        Usuario dto=m.map(revS.getUsuariobyusername(username),Usuario.class);
        return dto;
    }
    @PutMapping
    public void update(@RequestBody Usuario dto) {
        ModelMapper m = new ModelMapper();
        Usuario p = m.map(dto, Usuario.class);
        revS.insert(p);
    }

    @GetMapping("/verification")
    public String verificationUser(@RequestParam("ident") String ident) {
        ModelMapper m = new ModelMapper();
        String str=revS.verificationUser(ident);
        return str;
    }

    @GetMapping("/login/{username}/{pass}")
    public ResponseEntity<String> authUser(@PathVariable("username") String username, @PathVariable("pass") String pass) {

        if (!username.matches("[a-zA-Z0-9_]+")) {
            return ResponseEntity.ok("FALLA");
        } else if (!pass.matches("[a-zA-Z0-9_]+")) {
            return ResponseEntity.ok("FALLA");
        }
        String str = revS.authUser(username, pass);
        try {
            // Lógica principal
            if (str.matches("ACTIVO")) {
                return ResponseEntity.ok(str);
            }else{
                return ResponseEntity.ok("USUARIO INVALIDO");
            }
        } catch (Exception e) {
            // Manejo de la excepción
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("USUARIO INVALIDO" );
        }
    }


}
