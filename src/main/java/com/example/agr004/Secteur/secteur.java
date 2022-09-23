package com.example.agr004.Secteur;

import com.example.agr004.Coperative.coperative;
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
public class secteur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_secteur;
    private String name_secteur;
    @JsonIgnore
    @OneToMany(mappedBy = "secteur")
    private List<coperative> coperatives;
}
