package com.tfinal.tf_finanzas.repositories;

import com.tfinal.tf_finanzas.entities.Letra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LetraRepository extends JpaRepository<Letra,Integer>{

}
