package org.xproce.datte.dao.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Adress {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String rue;
    private String ville;
    private String codePostal;
    private String pays;
    @ManyToOne
    private Utilisateur utilisateur;
    @OneToMany(mappedBy = "adressLivraison", fetch = FetchType.EAGER)
    private Collection<Command> commandes;

}
