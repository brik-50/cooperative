package com.example.agr004.Client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class clientServiceIMPL implements clientService{
    @Autowired
    RepoClient repoclient;
    @Override
    public client saveclient(client c) {return repoclient.save(c);}

    @Override
    public void deleteclient(client c) {repoclient.delete(c);}

    @Override
    public void deleteclientById(Integer id) {repoclient.deleteById(id);}

    @Override
    public client getclient(Integer id) {return repoclient.findById(id).get();}

    @Override
    public List<client> getAllclients() {return repoclient.findAll();}

    @Override
    public int findclientByemail(String email) {
        return repoclient.findclientByemail(email);
    }

    @Override
    public Integer getIdClient(client c) {
        return repoclient.findclientByemail(c.getEmail_client());
    }
}
