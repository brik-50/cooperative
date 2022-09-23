package com.example.agr004.Composition;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

import com.example.agr004.Produit.*;
import com.example.agr004.Matiere1er.*;

@Data
@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class composition {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_composition;
    private Double percent_composition;
    @ManyToOne
    private produit produit;
    @ManyToOne
    private matiere1er matiere1er;
}
