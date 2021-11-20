/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.virtual.catalogo.controllers;

import com.virtual.catalogo.entities.User;
import com.virtual.catalogo.service.UserService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author unPandicornio
 */

    
@RestController
@RequestMapping("user")
@CrossOrigin(origins="*")
public class UserController {
    /**
     *
     */
    @Autowired
    private UserService service;
    
    /**
     * GET
     * @return 
     */
    @GetMapping("/all")
    public List<User> getUsers(){
        return service.getAll();
    }
    

    /**
     * @return
     * @param user
     */
    //@PostMapping("/new") 
    //@ResponseStatus(HttpStatus.CREATED)
    //public void save (@RequestBody User user) {
        //service.save(user);
    //}
    
    //prueba si el new user es correcto si no devuelve el user   
    @PostMapping("/new")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Optional<User> save (@RequestBody User user) {         
         try {
             service.save(user);
             return Optional.empty();
             } 
         catch(Exception e) {
            return Optional.of(user);
        }        
     }
    
     
    //valida si el email existe
    /*
    *@return
    */ 
    @GetMapping("/{email}")
    //@ResponseStatus(HttpStatus.ACCEPTED)
    public boolean emailExist(@PathVariable("email") String email) {
        return service.emailExist(email); 
         
    }
    
    //valida si la contrasena es correcta y valida si el email existe
    
    @GetMapping("/{email}/{password}")
    public User emailPassword(@PathVariable("email") String email, @PathVariable("password") String password) {
        return service.correctPassword(email, password);
    }   

}

