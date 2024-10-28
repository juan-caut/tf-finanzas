package com.tfinal.tf_finanzas.repositories;

import com.tfinal.tf_finanzas.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario,Integer>{

    @Query("SELECT u.estado from Usuario u where u.ident=:ident")
    String verificationUser(@Param("ident") String ident);

    @Query("SELECT u.estado from Usuario u where u.ident=:ident and u.password=:pass")
    String authUser(@Param("ident") String ident,@Param("pass") String pass);

}
