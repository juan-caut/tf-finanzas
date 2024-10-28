package com.tfinal.tf_finanzas.repositories;

import com.tfinal.tf_finanzas.entities.Coste;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CosteRepository extends JpaRepository<Coste,Integer>{


}
