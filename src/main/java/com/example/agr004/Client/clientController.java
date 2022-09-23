package com.example.agr004.Client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/clients")
public class clientController {
    public static Integer the_user_id;
    @Autowired
    clientService service;
    @PostMapping("sign_in")
    public void sign_in(@RequestBody client c){
        service.saveclient(c);
        the_user_id=service.getIdClient(c);
    }
    @GetMapping("/all")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public List<client> Allclient(){
        return service.getAllclients();
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public client clientbyid(@PathVariable Integer id){
        return service.getclient(id);
    }

    @PostMapping(value="/add")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public client addclient(@RequestBody client c) throws Exception {
      if(service.findclientByemail(c.getEmail_client())==0)
      {  service.saveclient(c);}
      else{
          throw new Exception("Email existe deja ou bien null");
      }
        return c;
    }

   /* @PutMapping("/{id}")
    public String updateclient(@PathVariable("id") Integer id,@RequestBody client c) throws Exception {
        client clientrest=service.getclient(id);
        clientrest.setName_client(c.getName_client());
        if(service.findclientByemail(c.getEmail_client())==0)
        {  clientrest.setEmail_client(c.getEmail_client());}
        else{
            throw new Exception("Email existe deja ou bien null");
        }
        clientrest.setEmail_client(c.getEmail_client());
        clientrest.setFamily_name_client(c.getFamily_name_client());
        clientrest.setPassword_client(c.getPassword_client());
        clientrest.setPaniers(c.getPaniers());

        service.saveclient(clientrest);
        return c.getName_client();
    }*/

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String deleteCoperative(@PathVariable("id") Integer id)
    {
        client c= service.getclient(id);
        service.deleteclient(c);
        return "delete";
    }
}
