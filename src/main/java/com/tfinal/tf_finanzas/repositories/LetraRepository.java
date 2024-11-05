package com.tfinal.tf_finanzas.repositories;

import com.tfinal.tf_finanzas.entities.Letra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LetraRepository extends JpaRepository<Letra,Integer>{
public List<Letra> findAllByCartera_IdCartera(int carteraId);
}
