package com.example.agr004.Produit;

import com.example.agr004.Categorie.categorieService;
import com.example.agr004.Coperative.coperativeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produits")
public class produitController {
    @Autowired
    produitService service;
    @Autowired
    categorieService servicecategorie;
    @Autowired
    coperativeService servicecoperative;

    @GetMapping("/categorie/{namecategorie}")
    @PreAuthorize("hasAuthority('produit:read')")
    public List<produit>  getProduitsBycategorie(@PathVariable String namecategorie){
        return service.getProduitsBycategorie(servicecategorie.findIDByname(namecategorie));
    }
    @GetMapping("/coperative/{namecoperative}")
    @PreAuthorize("hasAuthority('produit:read')")
    public List<produit>  getProduitsBycoperative(@PathVariable String namecoperative){
        return service.getProduitsBycoperative(servicecoperative.findIDByname(namecoperative));
    }
    @GetMapping("/region/{nameregion}")
    @PreAuthorize("hasAuthority('produit:read')")
    public List<produit>  getProduitsByregion(@PathVariable String nameregion){
        return service.getProduitsByregion(nameregion);
    }
    @GetMapping("/matiere1er/{namem}")
    @PreAuthorize("hasAuthority('produit:read')")
    public List<produit>  getProduitsBymatiere1er(@PathVariable String namem){
        return service.getProduitsBymatiere1er(namem);
    }
    @GetMapping("/origine/{nameO}")
    @PreAuthorize("hasAuthority('produit:read')")
    public List<produit>  getProduitsByoriginematiere1er(@PathVariable String nameO){
        return service.getProduitsByOriginematiere1er(nameO);
    }

    @GetMapping("/all")
    public List<produit> Allproduit(){
        return service.getAllproduits();
    }

    @GetMapping("/{id}")
    public produit produitbyid(@PathVariable Integer id){
        return service.getproduit(id);
    }

    @PostMapping(value="/add")
    @PreAuthorize("hasAuthority('produit:write')")
    public produit addproduit(@RequestBody produit p) {
        if(p.getCategorie()!=null){
            if(servicecategorie.countfindname(p.getCategorie().getName_categorie())==0 )
            {servicecategorie.savecategorie(p.getCategorie());
            }
            else
            {p.getCategorie().setId_categorie(servicecategorie.findIDByname(p.getCategorie().getName_categorie()));
            }
        }
        if(p.getCoperative()!=null){
            if(servicecoperative.countfindname(p.getCoperative().getName_copeartive())==0)
            {servicecoperative.savecoperative(p.getCoperative());}
            else
            {p.getCoperative().setId_coperative(servicecoperative.findIDByname(p.getCoperative().getName_copeartive()));
            }
        }
        return service.saveproduit(p); }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN_ROLE')")
    public String updateproduit(@PathVariable("id") Integer id,@RequestBody produit p) {
        produit  produitrest=service.getproduit(id);

        produitrest.setName_produit(p.getName_produit());
        produitrest.setPrice_produit(p.getPrice_produit());
        produitrest.setStock_produit(p.getStock_produit());
        produitrest.setUnity_produit(p.getUnity_produit());
        produitrest.setDescription_produit(p.getDescription_produit());
        produitrest.setCategorie(p.getCategorie());
        produitrest.setCompositions(p.getCompositions());
        produitrest.setConsomes(p.getConsomes());
        produitrest.setCoperative(p.getCoperative());

        service.saveproduit(produitrest);
        return p.getName_produit();
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN_ROLE')")
    public String deleteproduit(@PathVariable("id") Integer id)
    {
        produit p= service.getproduit(id);
        service.deleteproduit(p);
        return "delete";
    }


}
