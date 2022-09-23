package com.example.agr004.Matiere1er;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import com.example.agr004.Composition.*;
import com.example.agr004.Origine.*;

import java.util.List;

@Data
@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class matiere1er {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_matiere1er;
    private String name_matiere1er;
    @ManyToOne
    private origine origine;
    @JsonIgnore
    @OneToMany(mappedBy = "matiere1er")
    private List<composition> compositions;
}
