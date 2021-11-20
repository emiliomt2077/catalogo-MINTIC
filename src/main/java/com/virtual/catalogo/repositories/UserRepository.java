/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.virtual.catalogo.repositories;

import com.virtual.catalogo.entities.User;
import com.virtual.catalogo.repositories.crud.UserCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author unPandicornio
 */
@Repository
public class UserRepository {
    @Autowired
    private UserCrudRepository repository;
    
    /**
     * Consultar
     * @return 
    */
    public List<User> getAll(){
        return (List<User>) repository.findAll();
    }
    
      /**
     * Consultar
     * @param id
     * @return 
    */
  
    //Buscar registro por Id
    public Optional<User> getUser(int id){
        return repository.findById(id);
    }
    
    /**
     * Registrar
     * @param user
     * @return 
     */
    public User save(User user){
        return repository.save(user);
    }
    
    /**
     * Eliminar
     * @param user
     */
    public void delete(User user){
        repository.delete(user);
    }
    
    
    public User getUser(String email){
        return repository.findAllByEmail(email);
    }
    
}
