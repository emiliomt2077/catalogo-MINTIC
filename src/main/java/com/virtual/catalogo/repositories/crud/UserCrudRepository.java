/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.virtual.catalogo.repositories.crud;

import com.virtual.catalogo.entities.User;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.Query;



/**
 *
 * @author unPandicornio
 */

public interface UserCrudRepository extends CrudRepository<User,Integer> {
    User findAllByEmail(String email);
}

