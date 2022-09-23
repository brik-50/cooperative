package com.example.agr004.Produit;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

import com.example.agr004.Coperative.*;
import com.example.agr004.Categorie.*;
import com.example.agr004.Composition.*;
import com.example.agr004.Consome.*;

import java.util.List;

@Data
@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class produit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_produit;
    private String name_produit;
    private String description_produit;
    private Double price_produit;
    private String unity_produit;
    private Double Stock_produit;
    @ManyToOne
    private coperative coperative;
    @ManyToOne
    private categorie categorie;
    @JsonIgnore
    @OneToMany(mappedBy = "produit")
    private List<composition> compositions;
    @JsonIgnore
    @OneToMany(mappedBy = "produit")
    private List<consome> consomes;
}
