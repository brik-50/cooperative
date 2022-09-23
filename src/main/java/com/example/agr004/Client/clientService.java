package com.example.agr004.Client;

import java.util.List;

public interface clientService {
    client saveclient(client c);
    void deleteclient(client c);
    void deleteclientById(Integer id);
    client getclient(Integer id);
    List<client> getAllclients();
    int findclientByemail(String email);
    Integer getIdClient(client c);
}
