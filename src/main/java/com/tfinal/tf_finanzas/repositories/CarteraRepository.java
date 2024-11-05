package com.tfinal.tf_finanzas.repositories;

import com.tfinal.tf_finanzas.dto.CarteraDTO;
import com.tfinal.tf_finanzas.entities.Cartera;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarteraRepository extends JpaRepository<Cartera, Integer> {

    List<Cartera> findAllByUsuarioCreador_Iduser(int usuarioId);
}
