package com.example.agr004.Panier;

import java.util.List;

public interface panierService {
    panier savepanier(panier p);
    void deletepanier(panier p);
    void deletepanierById(Integer id);
    panier getpanier(Integer id);
    List<panier> getAllpaniers();
}
