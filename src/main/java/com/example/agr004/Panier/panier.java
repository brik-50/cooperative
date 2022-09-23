package com.example.agr004.Panier;

import com.example.agr004.Consome.consome;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import com.example.agr004.Client.*;
import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class panier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_panier;
    private String date_de_validation_panier;
    @JsonIgnore
    @OneToMany(mappedBy = "panier")
    private List<consome> consomes;
    @ManyToOne
    private client client;
}
