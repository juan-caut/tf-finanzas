package com.tfinal.tf_finanzas.repositories;

import com.tfinal.tf_finanzas.entities.Cartera;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarteraRepository extends JpaRepository<Cartera,Integer>{

}
