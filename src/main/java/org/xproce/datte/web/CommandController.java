package org.xproce.datte.web;

import org.springframework.stereotype.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.xproce.datte.dao.entities.Adress;
import org.xproce.datte.dao.entities.Command;
import org.xproce.datte.dao.entities.Panier;
import org.xproce.datte.service.AdressManager;
import org.xproce.datte.service.CommandManager;
import org.xproce.datte.service.PanierManger;

import java.util.Date;
import java.util.List;

@Controller
public class CommandController {
    @Autowired
    private PanierManger panierManger;

    @Autowired
    private CommandManager commandManager;
    @Autowired
    private AdressManager adressManager;

    @GetMapping("/afficher-commande")
    public String afficherCommande(Model model) {
        List<Panier> listeDesProduitsDansLePanier = panierManger.getProduitsDansLePanier();
        double prixTotal = listeDesProduitsDansLePanier.stream()
                .mapToDouble(panier -> panier.getProduit().getPrix())
                .sum();
        model.addAttribute("listeDesProduitsDansLePanier", listeDesProduitsDansLePanier);
        model.addAttribute("prixTotal", prixTotal);
        model.addAttribute("commande", new Command());
        model.addAttribute("adresse", new Adress());
        return "commandepage"; // Assurez-vous que le nom de la vue est correct
    }
    @PostMapping("/ajouter-adresse")
    public String ajouterAdresse(Model model,
                                 @RequestParam(name = "rue") String rue,
                                 @RequestParam(name = "ville") String ville,
                                 @RequestParam(name = "pays") String pays,
                                 @RequestParam(name = "commandeId") Integer commandeId) {
        // Créer une nouvelle adresse
        Adress adresse = new Adress();
        adresse.setRue(rue);
        adresse.setVille(ville);
        adresse.setPays(pays);

        // Récupérer la commande associée
        Command commande = commandManager.getCommandeById(commandeId);

        // Lier l'adresse à la commande
        commande.setAdressLivraison(adresse);

        // Enregistrer l'adresse
        adressManager.addAdresse(adresse);

        // Passer la commande mise à jour à la vue de confirmation
        model.addAttribute("commande", commande);

        return "redirect:/confirmation?commandeId=" + commande.getId(); // Rediriger vers la page de confirmation
    }

    @GetMapping("/passer-commande")
    public String afficherFormulaire(Model model) {
        model.addAttribute("commande", new Command());
        model.addAttribute("adresse", new Adress());
        return "commandepage"; // Assurez-vous que ce nom de vue correspond à votre fichier HTML
    }

    @PostMapping("/passer-commande")
    public String passerCommande(@ModelAttribute Command commande, @ModelAttribute Adress adresse) {
        commande.setAdressLivraison(adresse); // Associez l'adresse à la commande
        commandManager.ajouterCommand(commande); // Créez la commande avec l'adresse associée
        return "redirect:/confirmation?commandeId=" + commande.getId(); // Redirige vers la page de confirmation
    }

    @GetMapping("/confirmation")
    public String afficherConfirmation(@RequestParam("commandeId") Integer commandeId, Model model) {
        Command commande = commandManager.getCommandeById(commandeId);
        model.addAttribute("commande", commande);

        panierManger.viderPanier();

        return "confirmation";
    }
    @GetMapping("/liste-commandes")
    public String afficherListeCommandes(Model model) {
        List<Command> listeCommandes = commandManager.getAllCommandes();
        model.addAttribute("listeCommandes", listeCommandes);
        return "liste-commandes"; // Assurez-vous que ce nom de vue correspond à votre fichier HTML
    }
}
