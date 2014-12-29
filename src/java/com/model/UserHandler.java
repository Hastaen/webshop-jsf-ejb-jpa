/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javax.ejb.Stateful;
import javax.persistence.*;

/**
 *
 * @author Henrik
 */
@Stateful
public class UserHandler {

    private EntityManager em;
    private String userName;
    private String firstName;
    private String lastName;
    private boolean isAdmin = false;
    private boolean loggedIn = false;
    
    /**
     * Default constructor.
     */
    public UserHandler() {
    }
    
    /**
     * Log in user.
     * @param username
     * @param password
     * @return 
     */
    public boolean logIn(String username, String password) {
        Query logInQuery = em.createNamedQuery("Users.findByUsername", Users.class);
        Users result = (Users)logInQuery.getSingleResult();
        
        if (result.getPassword().equals(password)) {
            this.userName = username;
            this.firstName = result.getFirstname();
            this.lastName = result.getLastname();
            if (result.getIsadmin()) {
                this.isAdmin = true;
            }
            loggedIn = true;
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * Creates new user.
     * @param username
     * @param password
     * @param isAdmin
     * @return false if user exists or connection failed, else true.
     */
    public boolean registerUser(String username, String password, String lastname, String firstname) {
        Users result = findByUsername(username);
        
        if (!result.getUsername().equals(username)) {
            try {
                Users newUser = new Users(username, password, lastname, firstname);
                em.persist(newUser);
                return true;
            }
            catch (EntityExistsException e){
                System.out.println(e.getStackTrace());
                return false;
            }
        }
        else {
            return false;
        }
        
    }
    
    /**
     * Sets user as admin.
     * @param username
     * @return true if successful, else false.
     */
    public boolean setAdmin(String username) {
        Users result = findByUsername(username);
        
        if (result.getUsername().equals(username)) {
            try {
                if (!result.getIsadmin()) {
                    result.setIsadmin(true);
                }
                isAdmin = true;
                return true;
            }
            catch (IllegalArgumentException e){
                System.out.println(e.getStackTrace());
                return false;
            }
        }
        else {
            return false;
        }
    }
    
    /**
     * Sets user as not admin.
     * @param username
     * @return true if successful, else false.
     */
    public boolean removeAdmin(String username) {
        Users result = findByUsername(username);
        
        if (result.getUsername().equals(username)) {
            try {
                if (result.getIsadmin()) {
                    result.setIsadmin(false);
                }
                isAdmin = false;
                return true;
            }
            catch (IllegalArgumentException e){
                System.out.println(e.getStackTrace());
                return false;
            }
        }
        else {
            return false;
        }
    }
    
    private Users findByUsername(String username) {
        Query logInQuery = em.createNamedQuery("Users.findByUsername", Users.class);
        Users result = (Users)logInQuery.getSingleResult();
        return result;
    }
    
    public String getUserName() {
        return userName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    /**
     * Returns true if user is admin.
     * @return 
     */
    public boolean isIsAdmin() {
        return isAdmin;
    }

    public boolean isLoggedIn() {
        return loggedIn;
    }
    
}
