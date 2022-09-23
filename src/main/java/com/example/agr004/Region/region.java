package com.example.agr004.Region;

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
public class region {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_region;
    private String name_region;
    @JsonIgnore
    @OneToMany(mappedBy = "region")
    private List<coperative> coperatives;

}
