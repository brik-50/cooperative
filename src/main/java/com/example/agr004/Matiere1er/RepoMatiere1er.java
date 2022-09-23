package com.example.agr004.Matiere1er;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface RepoMatiere1er extends JpaRepository<matiere1er, Integer> {
    @Query("SELECT count(name_matiere1er) from matiere1er where name_matiere1er =?1 ")
    int countfindByname(String name);

    @Query("SELECT id_matiere1er from matiere1er where name_matiere1er =?1 ")
    int findIDByname(String name);
}
