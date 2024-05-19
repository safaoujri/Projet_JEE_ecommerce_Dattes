package org.xproce.datte.dao.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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

}
