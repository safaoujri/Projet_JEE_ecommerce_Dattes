package org.xproce.datte.dao.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Command {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Date dateCommande;
    private double Total;
    @ManyToOne
    private Utilisateur utilisateur;
    @ManyToMany(fetch = FetchType.EAGER)
    private Collection<Produit> produits;
    @OneToOne
    private PaymentCart paiement;
    @OneToMany(mappedBy = "commande")
    private Collection<Livraison> livraisons;
    @ManyToOne
    private Adress adressLivraison;
}
