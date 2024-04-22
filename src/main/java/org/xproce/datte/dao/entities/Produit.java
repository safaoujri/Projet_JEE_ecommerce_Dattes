package org.xproce.datte.dao.entities;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Produit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nom;
    //@Transient
    private String image;
    private int quantity;
    private int prix;
    private String description;
//    @ManyToOne
//    private User customer;
//    @OneToOne(mappedBy = "produit")
//    private Category category;




}
