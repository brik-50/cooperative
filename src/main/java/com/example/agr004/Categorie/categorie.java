package com.example.agr004.Categorie;

import com.example.agr004.Produit.produit;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class categorie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_categorie;
    private String name_categorie;
    @JsonIgnore
    @OneToMany(mappedBy = "categorie")
    private List<produit> produits;
}
