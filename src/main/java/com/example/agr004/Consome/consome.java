package com.example.agr004.Consome;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

import com.example.agr004.Panier.*;
import com.example.agr004.Produit.*;
@Data
@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class consome {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_consome;
    private Integer quantite_consome;

    @ManyToOne
    private panier panier;
    @ManyToOne
    private produit produit;
}
