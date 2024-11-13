package com.tfinal.tf_finanzas.service;
import com.tfinal.tf_finanzas.dto.TransaccionDTO;
import com.tfinal.tf_finanzas.dto.TransaccionDTO2;
import com.tfinal.tf_finanzas.entities.Cartera;
import com.tfinal.tf_finanzas.entities.Transaccion;
import org.springframework.stereotype.Service;

import java.util.List;

public interface TransaccionService {

    public void insert2(TransaccionDTO2 transaccion);

    public void insert(Transaccion transaccion);

    public void insertvarios(TransaccionDTO transaccion);

    List<Transaccion> list();

    List<Transaccion> listporcartera(Cartera cart);
    public
    Transaccion listId(int idTransaccion);
    Transaccion listplet(int letra);
    Transaccion listpfac(int fact);
    Transaccion listpcar(int cart);
    public void updateCosts(int id);
    public void delete(int idTransaccion);
}