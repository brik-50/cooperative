package com.example.agr004.Composition;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class compositionServiceIMPL implements compositionService{
    @Autowired
    RepoCompostion repocompostion;

    @Override
    public composition savecomposition(composition c) {return repocompostion.save(c);}

    @Override
    public void deletecomposition(composition c) {repocompostion.delete(c);}

    @Override
    public void deletecompositionById(Integer id) {repocompostion.deleteById(id);}

    @Override
    public composition getcomposition(Integer id) {return repocompostion.findById(id).get();}

    @Override
    public List<composition> getAllcompositions() {return repocompostion.findAll();}
}
