package com.example.agr004.Consome;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/consomes")
public class consomeController {
    private List<consome> consomations=new ArrayList<>();
    @Autowired
    consomeService service;

    @GetMapping("/all")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public List<consome> Allconsome(){
        return service.getAllconsomes();
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public consome consomebyid(@PathVariable Integer id){
        return service.getconsome(id);
    }

    @PostMapping(value="/add")
    @PreAuthorize("hasAuthority('consome:write')")
    public consome addconsome(@RequestBody consome c) {
        return service.saveconsome(c);
    }
    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String deleteconsome(@PathVariable("id") Integer id)
    {   consome c= service.getconsome(id);
        service.deleteconsome(c);
        return "delete";
    }
}
