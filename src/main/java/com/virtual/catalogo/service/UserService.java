/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.virtual.catalogo.service;

import com.virtual.catalogo.entities.User;
import com.virtual.catalogo.repositories.UserRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import static java.util.Optional.empty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author unPandicornio
 */

@Service
public class UserService {
    @Autowired
    private UserRepository repository;
    
    //Consultar Todos los registros.
    
    public List<User> getAll(){
        return repository.getAll();
    }
    
    //Buscar registro
    public Optional<User> getUser(int userId) {
        return repository.getUser(userId);
    }
    
    //Registrar 
    public User save(User user){
        if(user.getId()==null){
            return repository.save(user);
        }else{
            Optional<User> resultado = repository.getUser(user.getId());
            if(resultado.isPresent()){
                return user;
            }else{
                return repository.save(user);
            }
        }
    }
    //Actualizar

    
    //Eliminar
    public boolean delete(int id){
        Boolean aBoolean = getUser(id).map(user -> {
           repository.delete(user);
           return true;
        }).orElse(false);
        return aBoolean;
    } 
    
    //existencia de email
    public Boolean emailExist(String email) {
        User user = repository.getUser(email);
        return user!=null;
    }
    
    
    //existencia de email y contrasena
    public User correctPassword(String email, String password) {      
        User user = repository.getUser(email);
        String name = "NO DEFINIDO";
        User validacionFallida = new User();

        if (user!=null) {        
            if (user.getPassword().equals(password)) {
                return user;
            }
            else {
                validacionFallida.setName(name);
                validacionFallida.setEmail(email);
                validacionFallida.setPassword(password);
                
                return validacionFallida;
            }
        }
        else {
            validacionFallida.setName(name);
            validacionFallida.setEmail(email);
            validacionFallida.setPassword(password);
            
            return validacionFallida;
        }        
    }
}
