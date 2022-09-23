package com.example.agr004.Composition;



import java.util.List;

public interface compositionService {
    composition savecomposition(composition c);
    void deletecomposition(composition c);
    void deletecompositionById(Integer id);
    composition getcomposition(Integer id);
    List<composition> getAllcompositions();
}
