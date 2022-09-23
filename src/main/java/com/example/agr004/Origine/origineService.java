package com.example.agr004.Origine;



import java.util.List;

public interface origineService {
    int countfindname(String o);
    int findIDByname(String o);
    origine saveorigine(origine o);
    void deleteorigine(origine o);
    void deleteorigineById(Integer id);
    origine getorigine(Integer id);
    List<origine> getAllorigines();
}
