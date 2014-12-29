/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 * Class that handles administrator functions.
 * @author Henrik
 */
@Stateless
public class Admin {

    private EntityManager em;
    
    /**
     * Default constructor.
     */
    public Admin() {}
    
    /**
     * Sets user as banned.
     * @param username
     * @return true if ban was successful, otherwise false.
     */
    public boolean banUser(String username) {
        Query banQuery = em.createNamedQuery("Users.findByUsername", Users.class);
        Users result = (Users)banQuery.getSingleResult();
        if (result.getUsername() == username && !result.getIsbanned()) {
            result.setIsbanned(Boolean.TRUE);
            em.merge(result);
            return true;
        }
        else {
            return false;
        }
    }
    
    /**
     * Sets user as not banned.
     * @param username
     * @return true if ban was successful, otherwise false.
     */
    public boolean unbanUser(String username) {
        Query unbanQuery = em.createNamedQuery("Users.findByUsername", Users.class);
        Users result = (Users)unbanQuery.getSingleResult();
        if (result.getUsername() == username && result.getIsbanned()) {
            result.setIsbanned(Boolean.FALSE);
            em.merge(result);
            return true;
        }
        else {
            return false;
        }
    }

}
