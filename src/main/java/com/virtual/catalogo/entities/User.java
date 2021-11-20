/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.virtual.catalogo.entities;

import java.io.Serializable;
import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author unPandicornio
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user",indexes = @Index(name = "email_index", columnList = "email", unique = true))
public class User implements Serializable {
       
    @Id
    @Column(length=11)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(length=50, nullable = false)
    private String email;
     
    @Column(length=80, nullable = false)
    private String name;
      
    @Column(length=50, nullable = false)
    private String password;
}
