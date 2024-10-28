package com.tfinal.tf_finanzas.servicesimplement;


import com.tfinal.tf_finanzas.entities.Log;
import com.tfinal.tf_finanzas.repositories.LogRepository;
import com.tfinal.tf_finanzas.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LogServiceImplement implements LogService {

    @Autowired
    private LogRepository cR;


    @Override
    public List<Log> list() {
        return cR.findAll();
    }

    @Override
    public void insert(Log log) {
        cR.save(log);
    }

    @Override
    public Log listId(int id) {
        return cR.findById(id).orElse(new Log());
    }
}

