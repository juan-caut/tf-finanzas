package com.tfinal.tf_finanzas.service;

import com.tfinal.tf_finanzas.entities.Log;

import java.util.List;

public interface LogService {
    public void insert(Log log);
    List<Log> list();
    public Log listId(int id);
}