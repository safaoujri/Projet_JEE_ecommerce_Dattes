package org.xproce.datte.web;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.xproce.datte.dao.entities.Panier;
import org.xproce.datte.dao.repositories.ProduitRepository;
import org.xproce.datte.service.PanierManger;
import org.xproce.datte.service.ProduitManager;

import java.util.List;

@Controller
public class Paniercontroller {

    @Autowired
    private PanierManger panierManger;

    @Autowired
    private ProduitManager produitManager;

    @Autowired
    private ProduitRepository produitRepository;

    @GetMapping("/ajouter-au-panier/{id}")
    public String ajouterAuPanier(@PathVariable("id") Integer id) {
        panierManger.ajouteraupanier(id);
        return "redirect:/listProduit";
    }

    @GetMapping("/panier")
    public String afficherPanier(Model model) {
        List<Panier> listeDesProduitsDansLePanier = panierManger.getProduitsDansLePanier();
        double prixTotal = listeDesProduitsDansLePanier.stream()
                .mapToDouble(panier -> panier.getProduit().getPrix())
                .sum();
        model.addAttribute("listeDesProduitsDansLePanier", listeDesProduitsDansLePanier);
        model.addAttribute("prixTotal", prixTotal);
        return "pannier"; // Assurez-vous que le nom de la vue est correct
    }

    @GetMapping("/removedupanier/{id}")
    public String removeProductFromPanier(@PathVariable("id") Integer id) {
        if (panierManger.deleteProduitFromPanier(id)) {
            return "redirect:/panier";
        } else {
            return "error";
        }
    }

    @PostMapping("/vider-panier")
    public String viderPanier() {
        panierManger.viderPanier();
        return "redirect:/panier";
    }
}
