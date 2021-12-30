/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eCommerce.eCommerce.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.io.Serializable;
import java.util.List;

/**
 * @author bnc
 */
@Entity
@Table(name = "city")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "City.findAll", query = "SELECT c FROM City c"),
        @NamedQuery(name = "City.findByIdcity", query = "SELECT c FROM City c WHERE c.idcity = :idcity"),
        @NamedQuery(name = "City.findByName", query = "SELECT c FROM City c WHERE c.name = :name"),
        @NamedQuery(name = "City.findByPostalNumber", query = "SELECT c FROM City c WHERE c.postalNumber = :postalNumber")})
public class City implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idcity")
    private Integer idcity;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @Column(name = "postal_number")
    private int postalNumber;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCity")
    private List<Address> addressList;

    public City() {
    }

    public City(Integer idcity) {
        this.idcity = idcity;
    }

    public City(Integer idcity, String name, int postalNumber) {
        this.idcity = idcity;
        this.name = name;
        this.postalNumber = postalNumber;
    }

    public Integer getIdcity() {
        return idcity;
    }

    public void setIdcity(Integer idcity) {
        this.idcity = idcity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPostalNumber() {
        return postalNumber;
    }

    public void setPostalNumber(int postalNumber) {
        this.postalNumber = postalNumber;
    }

    @XmlTransient
    public List<Address> getAddressList() {
        return addressList;
    }

    public void setAddressList(List<Address> addressList) {
        this.addressList = addressList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcity != null ? idcity.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof City)) {
            return false;
        }
        City other = (City) object;
        if ((this.idcity == null && other.idcity != null) || (this.idcity != null && !this.idcity.equals(other.idcity))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.eCommerce.eCommerce.model.City[ idcity=" + idcity + " ]";
    }

}
