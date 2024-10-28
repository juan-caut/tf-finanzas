package com.tfinal.tf_finanzas.repositories;

import com.tfinal.tf_finanzas.entities.Log;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LogRepository extends JpaRepository<Log,Integer>{

}
