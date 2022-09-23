package com.example.agr004.Client;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface RepoClient extends JpaRepository<client, Integer> {
    @Query("select  id_client from client where email_client=?1")
    int findclientByemail(String email);
}
