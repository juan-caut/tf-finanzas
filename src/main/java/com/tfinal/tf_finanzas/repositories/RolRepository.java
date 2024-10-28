package com.tfinal.tf_finanzas.repositories;

import com.tfinal.tf_finanzas.entities.Rol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolRepository extends JpaRepository<Rol,Integer>{

}
