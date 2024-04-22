package org.xproce.datte;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.xproce.datte.dao.entities.Category;
import org.xproce.datte.dao.entities.Produit;
import org.xproce.datte.dao.entities.User;
import org.xproce.datte.dao.repositories.ProduitRepository;
import org.xproce.datte.service.ProduitManager;

import java.util.ArrayList;

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
