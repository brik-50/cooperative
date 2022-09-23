package com.example.agr004.Consome;

import java.util.List;

public interface consomeService {
    consome saveconsome(consome c);
    void deleteconsome(consome c);
    void deleteconsomeById(Integer id);
    consome getconsome(Integer id);
    List<consome> getAllconsomes();
}
