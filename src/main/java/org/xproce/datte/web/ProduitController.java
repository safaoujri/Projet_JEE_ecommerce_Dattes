package org.xproce.datte.web;

import com.fasterxml.classmate.TypeBindings;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.xproce.datte.dao.entities.Produit;
import org.xproce.datte.service.ProduitManager;

import java.util.List;

@Controller
@AllArgsConstructor
public class ProduitController {

   @Autowired
    private ProduitManager produitManager;

    @GetMapping("/")
    public String home(){
        return "home";
    }
    @PostMapping("/ajouter")
    public String ajouterProduitAction(Model model,
                                       @RequestParam(name = "nom") String nom,
                                       @RequestParam(name = "id", defaultValue =  "") Integer id,
                                       @RequestParam(name = "image") String image,
                                       @RequestParam(name = "quantity") int quantity,
                                       @RequestParam(name = "prix") int prix,
                                       @RequestParam(name = "description") String description)
    {
        Produit produit=new Produit();
        produit.setNom(nom);
        produit.setImage(image);
        produit.setQuantity((quantity));
        produit.setPrix(prix);
        produit.setDescription(description);
        produitManager.addProduit(produit);




        return "redirect:/indexpage";
    }

    @PostMapping("/ajouterOnce")
    public String ajouterProduit(Model model,
                                 @Valid Produit produit,
                                 BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            return "ajouterproduit" ;
        }

        produitManager.addProduit(produit);
        return "redirect:indexpage";
    }


    @GetMapping("ajouterproduit")
    public String ajouterproduit(Model model){
        model.addAttribute("produit",new Produit());
        return "ajouterproduit";
    }
    @GetMapping("/indexpage")
    public String listProduits(Model model,
                               @RequestParam(name = "page", defaultValue = "0") int page,
                               @RequestParam(name = "taille", defaultValue = "6") int taille,
                               @RequestParam(name = "search", defaultValue = "") String keyword
    ) {
        Page<Produit> produits = produitManager.searchProduits(keyword, page, taille);
        model.addAttribute("listProduits", produits.getContent());
        int[] pages = new int[produits.getTotalPages()];
        model.addAttribute("pages", pages);
        model.addAttribute("keyword", keyword);
        model.addAttribute("page", page);
        return "indexlayout";
    }

    @GetMapping("/deleteProduit")
    public String deleteProduit(Model model, @RequestParam(name = "id") Integer id) {
        if (produitManager.deleteProduit(id)) {
            return "redirect:indexpage";
        } else {
            return "error";
        }
    }
    @GetMapping("/editProduit")
    public String editProduit(Model model, @RequestParam(name = "id") Integer id) {
        Produit produit = produitManager.getProduitById(id);
        if (produit != null) {
            model.addAttribute("produitToBeUpdated", produit);
            return "updateProduct";
        } else {
            return "error";
        }
    }
    @GetMapping("/loginpage")
    public String login() {
        return "login";
    }
    @GetMapping("/listProduit")
    public  String list(Model model){
        List<Produit> produits=produitManager.getProduit();
        model.addAttribute("list",produits);
        return "listproduit";
    }
    @GetMapping("/infodatte")
    public String info(){
        return "infodatte";
    }
}
