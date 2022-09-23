package com.example.agr004.Origine;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class origineServiceIMPL implements origineService{
    @Autowired
    RepoOrigine repoorigine;

    @Override
    public int countfindname(String o) {
        return repoorigine.countfindByname(o);
    }

    @Override
    public int findIDByname(String o) {
        return repoorigine.findIDByname(o);
    }

    @Override
    public origine saveorigine(origine o) {
        return repoorigine.save(o);
    }

    @Override
    public void deleteorigine(origine o) {
        repoorigine.delete(o);
    }

    @Override
    public void deleteorigineById(Integer id) {
        repoorigine.deleteById(id);
    }

    @Override
    public origine getorigine(Integer id) {
        return repoorigine.findById(id).get();
    }

    @Override
    public List<origine> getAllorigines() {
        return repoorigine.findAll();
    }
}
