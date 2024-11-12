package com.tfinal.tf_finanzas.repositories;

import com.tfinal.tf_finanzas.entities.Factura;
import com.tfinal.tf_finanzas.entities.Letra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FacturaRepository extends JpaRepository<Factura,Integer>{

    public List<Factura> findAllByCartera_IdCartera(int carteraId);
}
