package com.tfinal.tf_finanzas.repositories;

import com.tfinal.tf_finanzas.entities.ConversionTasa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface ConversionTasaRepository extends JpaRepository<ConversionTasa,Integer>{

}
