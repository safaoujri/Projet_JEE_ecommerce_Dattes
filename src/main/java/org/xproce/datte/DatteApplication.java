package org.xproce.datte;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.xproce.datte.service.ProduitManager;

@SpringBootApplication
public class DatteApplication implements CommandLineRunner {
    @Autowired
    ProduitManager produitManager;

    public static void main(String[] args) {
        SpringApplication.run(DatteApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
//        Produit produit = new Produit(null, "datte", "image", 54, 25, "mm");
//        Produit produit1 = new Produit(null, "datte1", "im", 54, 25, "mm");
//        Produit produit2 = new Produit(null, "majhoul", "new byte[]{}", 54, 25, "pp");
//        produitManager.addProduit(produit);
//        produitManager.addProduit(produit1);
//        produitManager.addProduit(produit2);
    }

}
