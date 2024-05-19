package org.xproce.datte.dao.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Collection;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@DiscriminatorValue("user")

public class Utilisateur extends Admin{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String role;
    @OneToMany(mappedBy = "customer")
    private Collection<Produit> produits=new ArrayList<>();
    @OneToMany(mappedBy = "utilisateur", cascade = CascadeType.ALL)
    private Collection<Adress> adresses;
    @OneToMany(mappedBy = "utilisateur")
    private Collection<Command> commands;
    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private Collection<PaymentCart> paymentCarts;



}
