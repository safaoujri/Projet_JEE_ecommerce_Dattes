package org.xproce.datte.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.xproce.datte.dao.entities.Panier;
import org.xproce.datte.dao.entities.Produit;
import org.xproce.datte.dao.repositories.PanierRepository;
import org.xproce.datte.dao.repositories.ProduitRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PanierService implements PanierManger{
    @Autowired
    private PanierRepository panierRepository;
    @Autowired
    private ProduitRepository produitRepository;
    public PanierService(PanierRepository panierRepository, ProduitRepository produitRepository) {
        this.panierRepository = panierRepository;
        this.produitRepository = produitRepository;
    }

    @Override
    public Panier ajouteraupanier(Integer id) {
        Produit produit=produitRepository.findById(id).get();
        if(produit!=null){
            Panier panier=new Panier(produit);
            return panierRepository.save(panier);
        }
        return null;
    }

    @Override
    public List<Panier> getProduitsDansLePanier() {
        return panierRepository.findAll();
    }

    @Override
    public boolean deleteProduitFromPanier(Integer id) {
        Optional<Panier> panierOptional = panierRepository.findByProduitId(id);
        if (panierOptional.isPresent()) {
            panierRepository.delete(panierOptional.get());
            return true;
        } else {
            return false; // Le produit n'était pas dans le panier
        }
    }

    @Override
    public void viderPanier() {
        panierRepository.deleteAll();

    }
}
