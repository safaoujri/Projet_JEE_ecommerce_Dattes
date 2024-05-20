package org.xproce.datte.service;

import org.xproce.datte.dao.entities.Adress;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.xproce.datte.dao.repositories.AdressRepository;

@Service
public class AdressService implements AdressManager{


    @Autowired
    AdressRepository adressRepository;
    @Override
    public Adress addAdresse(Adress adresse) {
        return adressRepository.save(adresse);
    }


    @Override
    public List<Adress> getAllAdresses() {
        return adressRepository.findAll();
    }
}
