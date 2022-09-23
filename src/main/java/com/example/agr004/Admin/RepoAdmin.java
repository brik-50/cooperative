package com.example.agr004.Admin;

import com.example.agr004.Categorie.categorie;
import com.example.agr004.Coperative.coperative;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface RepoAdmin extends JpaRepository<Admin,Integer> {
}
