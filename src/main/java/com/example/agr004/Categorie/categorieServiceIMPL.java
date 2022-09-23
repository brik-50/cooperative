package com.example.agr004.Categorie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class categorieServiceIMPL implements categorieService{
    @Autowired
    RepoCategorie repocategorie;

    @Override
    public int countfindname(String c) {
        return repocategorie.countfindByname(c);
    }

    @Override
    public int findIDByname(String c) {
        return repocategorie.findIDByname(c);
    }

    @Override
    public categorie savecategorie(categorie c) {return repocategorie.save(c);}

    @Override
    public void deletecategorie(categorie c) {repocategorie.delete(c);}

    @Override
    public void deletecategorieById(Integer id) {repocategorie.deleteById(id);}

    @Override
    public categorie getcategorie(Integer id) {return repocategorie.findById(id).get();}

    @Override
    public List<categorie> getAllcategories() {return repocategorie.findAll();}
}
