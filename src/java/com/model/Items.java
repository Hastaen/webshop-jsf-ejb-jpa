/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Jonas
 */
@Entity
@Table(name = "ITEMS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Items.findAll", query = "SELECT i FROM Items i"),
    @NamedQuery(name = "Items.findByItemid", query = "SELECT i FROM Items i WHERE i.itemid = :itemid"),
    @NamedQuery(name = "Items.findByItemname", query = "SELECT i FROM Items i WHERE i.itemname = :itemname"),
    @NamedQuery(name = "Items.findByItemstock", query = "SELECT i FROM Items i WHERE i.itemstock = :itemstock"),
    @NamedQuery(name = "Items.findByItemdescription", query = "SELECT i FROM Items i WHERE i.itemdescription = :itemdescription")})
public class Items implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ITEMID")
    private Integer itemid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "ITEMNAME")
    private String itemname;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ITEMSTOCK")
    private int itemstock;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "ITEMDESCRIPTION")
    private String itemdescription;

    public Items() {
    }

    public Items(Integer itemid) {
        this.itemid = itemid;
    }

    public Items(Integer itemid, String itemname, int itemstock, String itemdescription) {
        this.itemid = itemid;
        this.itemname = itemname;
        this.itemstock = itemstock;
        this.itemdescription = itemdescription;
    }

    public Integer getItemid() {
        return itemid;
    }

    public void setItemid(Integer itemid) {
        this.itemid = itemid;
    }

    public String getItemname() {
        return itemname;
    }

    public void setItemname(String itemname) {
        this.itemname = itemname;
    }

    public int getItemstock() {
        return itemstock;
    }

    public void setItemstock(int itemstock) {
        this.itemstock = itemstock;
    }

    public String getItemdescription() {
        return itemdescription;
    }

    public void setItemdescription(String itemdescription) {
        this.itemdescription = itemdescription;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (itemid != null ? itemid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Items)) {
            return false;
        }
        Items other = (Items) object;
        if ((this.itemid == null && other.itemid != null) || (this.itemid != null && !this.itemid.equals(other.itemid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.model.Items[ itemid=" + itemid + " ]";
    }
    
}
