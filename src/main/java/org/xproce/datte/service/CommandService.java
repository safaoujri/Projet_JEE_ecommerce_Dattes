package org.xproce.datte.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.xproce.datte.dao.entities.Adress;
import org.xproce.datte.dao.entities.Command;
import org.xproce.datte.dao.entities.Panier;
import org.xproce.datte.dao.repositories.AdressRepository;
import org.xproce.datte.dao.repositories.CommandRepository;
import org.xproce.datte.dao.repositories.PanierRepository;

import java.util.Date;
import java.util.List;

@Service
public class CommandService implements CommandManager{
    @Autowired
    private CommandRepository commandRepository;
    @Autowired
    private PanierRepository panierRepository;
    @Autowired
    private AdressRepository adressRepository;
    @Override
    public void ajouterCommand(Command commande) {
        List<Panier> produitsDansLePanier = panierRepository.findAll();
        commande.setProduits(produitsDansLePanier.stream()
                .map(Panier::getProduit)
                .toList());

        double montantTotal = produitsDansLePanier.stream()
                .mapToDouble(panier -> panier.getProduit().getPrix())
                .sum();
        commande.setTotal(montantTotal);

        commande.setDateCommande(new Date());

        // Récupérer l'adresse associée à la commande
        Adress adresse = commande.getAdressLivraison();
        // Enregistrer l'adresse si elle n'existe pas déjà
        if (adresse != null && adresse.getId() == null) {
            adressRepository.save(adresse);
        }

        // Associer l'adresse à la commande
        commande.setAdressLivraison(adresse);

        // Enregistrer la commande
        commandRepository.save(commande);

        // Vider le panier après avoir passé la commande

    }

    @Override
    public Command getCommandeById(Integer Id) {
        return commandRepository.findById(Id).orElse(null);
    }

    @Override
    public List<Command> getAllCommandes() {
        return commandRepository.findAll();
    }
}
