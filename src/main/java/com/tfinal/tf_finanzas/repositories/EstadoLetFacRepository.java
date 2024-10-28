package com.tfinal.tf_finanzas.repositories;

import com.tfinal.tf_finanzas.entities.EstadoLetFac;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstadoLetFacRepository extends JpaRepository<EstadoLetFac,Integer>{

}
