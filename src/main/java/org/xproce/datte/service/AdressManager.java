package org.xproce.datte.service;

import org.xproce.datte.dao.entities.Adress;

import java.util.List;

public interface AdressManager {
    public Adress addAdresse(Adress adresse);
    public List<Adress> getAllAdresses();
}
