package com.example.agr004.Composition;

import com.example.agr004.Matiere1er.matiere1erService;
import com.example.agr004.Produit.produitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/compositions")
public class compositionController {
    @Autowired
    compositionService service;
    @Autowired
    produitService serviceproduit;
    @Autowired
    matiere1erService servicematiere1er;

    @GetMapping("/all")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public List<composition> Allcomposition(){
        return service.getAllcompositions();
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public composition compositionbyid(@PathVariable Integer id){
        return service.getcomposition(id);
    }

    @PostMapping(value="/add")
    @PreAuthorize("hasAuthority('composition:write')")
    public composition addcomposition(@RequestBody composition c) {
        //khas l verification d categorie o coperative tkon nta mdekhlha f ldakhl d produit
        //khas lmatiere premiere t verifie wach kayna o bnafs region
        /*serviceproduit.saveproduit(c.getProduit());
        if(servicematiere1er.countfindname(c.getMatiere1er().getName_matiere1er())==0)
        {servicematiere1er.savematiere1er(c.getMatiere1er());}
        else{c.getMatiere1er().setId_matiere1er(servicematiere1er.findIDByname(c.getMatiere1er().getName_matiere1er()));
        }*/
        return service.savecomposition(c);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('composition:write')")
    public Double updatecomposition(@PathVariable("id") Integer id,@RequestBody composition c) {
        composition  compositionrest=service.getcomposition(id);
        compositionrest.setPercent_composition(c.getPercent_composition());
        compositionrest.setProduit(c.getProduit());
        compositionrest.setMatiere1er(c.getMatiere1er());

        service.savecomposition(compositionrest);
        return c.getPercent_composition();
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('composition:write')")
    public String deletecompositione(@PathVariable("id") Integer id)
    {   composition c= service.getcomposition(id);
        service.deletecomposition(c);
        return "delete";
    }

}
