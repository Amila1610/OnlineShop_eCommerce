/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eCommerce.eCommerce.model;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author bnc
 */
@Entity
@Table(name = "product_order")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProductOrder.findAll", query = "SELECT p FROM ProductOrder p"),
    @NamedQuery(name = "ProductOrder.findByIdproductOrder", query = "SELECT p FROM ProductOrder p WHERE p.idproductOrder = :idproductOrder"),
    @NamedQuery(name = "ProductOrder.findByQuantity", query = "SELECT p FROM ProductOrder p WHERE p.quantity = :quantity"),
    @NamedQuery(name = "ProductOrder.findByTotal", query = "SELECT p FROM ProductOrder p WHERE p.total = :total")})
public class ProductOrder implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idproduct_order")
    private Integer idproductOrder;
    @Basic(optional = false)
    @Column(name = "quantity")
    private int quantity;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "total")
    private BigDecimal total;
    @JoinColumn(name = "order_id", referencedColumnName = "idorder")
    @ManyToOne(optional = false)
    private Order orderId;
    @JoinColumn(name = "product_id", referencedColumnName = "idproduct")
    @ManyToOne(optional = false)
    private Product productId;

    public ProductOrder() {
    }

    public ProductOrder(Integer idproductOrder) {
        this.idproductOrder = idproductOrder;
    }

    public ProductOrder(Integer idproductOrder, int quantity, BigDecimal total) {
        this.idproductOrder = idproductOrder;
        this.quantity = quantity;
        this.total = total;
    }

    public Integer getIdproductOrder() {
        return idproductOrder;
    }

    public void setIdproductOrder(Integer idproductOrder) {
        this.idproductOrder = idproductOrder;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public Order getOrderId() {
        return orderId;
    }

    public void setOrderId(Order orderId) {
        this.orderId = orderId;
    }

    public Product getProductId() {
        return productId;
    }

    public void setProductId(Product productId) {
        this.productId = productId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idproductOrder != null ? idproductOrder.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProductOrder)) {
            return false;
        }
        ProductOrder other = (ProductOrder) object;
        if ((this.idproductOrder == null && other.idproductOrder != null) || (this.idproductOrder != null && !this.idproductOrder.equals(other.idproductOrder))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.eCommerce.eCommerce.model.ProductOrder[ idproductOrder=" + idproductOrder + " ]";
    }
    
}