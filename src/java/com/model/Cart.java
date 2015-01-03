/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model;

import java.util.HashMap;
import java.util.Set;
import javax.ejb.Stateful;
import javax.enterprise.context.SessionScoped;

/**
 * Shopping cart that holds the items the user intends to buy.
 * @author Henrik
 */
@Stateful
@SessionScoped
public class Cart {
    
    private HashMap items;
    
    /**
     * Default constructor
     */
    public Cart() {
        items = new HashMap(5);
    }
    
    /**
     * Adds one item to the cart.
     * @param item 
     */
    public void addItem(String item) {
        if ((int)items.get(item) > 0) {
            int amount = (int)items.get(item) + 1;
            items.replace(item, amount);
        } 
        else {
            items.put(item, 1);
        }
        
    }
    
    /**
     * Adds specfied amount of an item to the cart.
     * @param item
     * @param amount 
     */
    public void addItem(String item, int amount) {
        if ((int)items.get(item) > 0) {
            amount = amount + (int)items.get(item);
            items.replace(item, amount);
        } 
        else {
            items.put(item, amount);
        }
        
    }
    
    /**
     * Removes all of specified item.
     * @param item 
     */
    public void removeItem(String item) {
        items.remove(item);
    }
    
    /**
     * Removes specified amount of item from cart.
     * @param item
     * @param amount 
     */
    public void removeItem(String item, int amount) {
        amount = amount - (int)items.get(item);
        items.replace(item, amount);
    }
    
    /**
     * Removes all items from cart.
     */
    public void removeAll(){
        items.clear();
    }
    
    /**
     * Returns a Set of the mappings in the Cart.
     * @return Set
     */
    public Set getCart() {
        return items.entrySet();
    }
    
    /**
     * Returns string representation of object.
     * @return String
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Set cart = this.getCart();
        sb.append(cart);
        
        return sb.toString();
    }
}
