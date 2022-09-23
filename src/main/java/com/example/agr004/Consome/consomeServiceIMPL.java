package com.example.agr004.Consome;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class consomeServiceIMPL implements consomeService{
    @Autowired
    RepoConsome repoconsome;

    @Override
    public consome saveconsome(consome c) {
        return repoconsome.save(c);
    }

    @Override
    public void deleteconsome(consome c) {
        repoconsome.delete(c);
    }

    @Override
    public void deleteconsomeById(Integer id) {
        repoconsome.deleteById(id);
    }

    @Override
    public consome getconsome(Integer id) {
        return repoconsome.findById(id).get();
    }

    @Override
    public List<consome> getAllconsomes() {
        return repoconsome.findAll();
    }
}
