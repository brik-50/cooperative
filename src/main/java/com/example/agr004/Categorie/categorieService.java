package com.example.agr004.Categorie;

import java.util.List;

public interface categorieService {
    int countfindname(String c);
    int findIDByname(String c);
    categorie savecategorie(categorie c);
    void deletecategorie(categorie c);
    void deletecategorieById(Integer id);
    categorie getcategorie(Integer id);
    List<categorie> getAllcategories();
}
