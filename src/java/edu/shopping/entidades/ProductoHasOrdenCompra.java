/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.shopping.entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
 * @author roxi9
 */
@Entity
@Table(name = "producto_has_orden_compra")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProductoHasOrdenCompra.findAll", query = "SELECT p FROM ProductoHasOrdenCompra p")})
public class ProductoHasOrdenCompra implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "cantidad")
    private Integer cantidad;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "precio_total")
    private Float precioTotal;
    @JoinColumn(name = "producto_idproducto", referencedColumnName = "idproducto")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Producto productoIdproducto;
    @JoinColumn(name = "orden_compra_idorden_compra", referencedColumnName = "idorden_compra")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private OrdenCompra ordenCompraIdordenCompra;

    public ProductoHasOrdenCompra() {
    }

    public ProductoHasOrdenCompra(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Float getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(Float precioTotal) {
        this.precioTotal = precioTotal;
    }

    public Producto getProductoIdproducto() {
        return productoIdproducto;
    }

    public void setProductoIdproducto(Producto productoIdproducto) {
        this.productoIdproducto = productoIdproducto;
    }

    public OrdenCompra getOrdenCompraIdordenCompra() {
        return ordenCompraIdordenCompra;
    }

    public void setOrdenCompraIdordenCompra(OrdenCompra ordenCompraIdordenCompra) {
        this.ordenCompraIdordenCompra = ordenCompraIdordenCompra;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProductoHasOrdenCompra)) {
            return false;
        }
        ProductoHasOrdenCompra other = (ProductoHasOrdenCompra) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.shopping.entidades.ProductoHasOrdenCompra[ id=" + id + " ]";
    }
    
}
