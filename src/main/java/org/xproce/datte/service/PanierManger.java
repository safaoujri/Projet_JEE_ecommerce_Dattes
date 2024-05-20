package org.xproce.datte.service;

import org.springframework.stereotype.Component;
import org.xproce.datte.dao.entities.Panier;

import java.util.List;

@Component
public interface PanierManger {
    public Panier ajouteraupanier(Integer id);
    public List<Panier> getProduitsDansLePanier();

    boolean deleteProduitFromPanier(Integer id);

    void viderPanier();
}
