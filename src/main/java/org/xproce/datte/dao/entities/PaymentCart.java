package org.xproce.datte.dao.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@DiscriminatorValue("CART")

public  class PaymentCart extends Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String cardName;
    private int cardNumber;
    private int expiryMonth;
    private int expiryYear;
    private int cvc;
    @Column(name = "type_paiement")
    private String typePaiement;
    @OneToOne(mappedBy = "paiement")
    private Command commande;
    @ManyToOne
    private Utilisateur customer;

}
