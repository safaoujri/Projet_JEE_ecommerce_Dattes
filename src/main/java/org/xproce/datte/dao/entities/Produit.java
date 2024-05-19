package org.xproce.datte.dao.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Collection;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "produit", discriminatorType = DiscriminatorType.STRING)
public class Produit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nom;
    @Lob
    private String image;
    private int quantity;
    private int prix;
    private String description;
    @ManyToOne
    private Utilisateur customer;
    @OneToOne(mappedBy = "produit")
    private Category category;
    @ManyToMany(mappedBy = "produits",fetch = FetchType.EAGER)
    private Collection<Command> commande ;
    @OneToMany(mappedBy = "produit", cascade = CascadeType.ALL)
    private Collection<Livraison> livraison;




}
