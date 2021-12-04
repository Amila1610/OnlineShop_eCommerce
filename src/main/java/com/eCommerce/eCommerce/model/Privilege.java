/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eCommerce.eCommerce.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author bnc
 */
@Entity
@Table(name = "privilege")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Privilege.findAll", query = "SELECT p FROM Privilege p"),
    @NamedQuery(name = "Privilege.findByIdprivilege", query = "SELECT p FROM Privilege p WHERE p.idprivilege = :idprivilege"),
    @NamedQuery(name = "Privilege.findByName", query = "SELECT p FROM Privilege p WHERE p.name = :name")})
public class Privilege implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idprivilege")
    private Integer idprivilege;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "privilege")
    private List<User> userList;

    public Privilege() {
    }

    public Privilege(Integer idprivilege) {
        this.idprivilege = idprivilege;
    }

    public Privilege(Integer idprivilege, String name) {
        this.idprivilege = idprivilege;
        this.name = name;
    }

    public Integer getIdprivilege() {
        return idprivilege;
    }

    public void setIdprivilege(Integer idprivilege) {
        this.idprivilege = idprivilege;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlTransient
    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idprivilege != null ? idprivilege.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Privilege)) {
            return false;
        }
        Privilege other = (Privilege) object;
        if ((this.idprivilege == null && other.idprivilege != null) || (this.idprivilege != null && !this.idprivilege.equals(other.idprivilege))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.eCommerce.eCommerce.model.Privilege[ idprivilege=" + idprivilege + " ]";
    }
    
}
