/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.shopping.entidades;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author roxi9
 */
@Entity
@Table(name = "orden_compra")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OrdenCompra.findAll", query = "SELECT o FROM OrdenCompra o")})
public class OrdenCompra implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idorden_compra")
    private Integer idordenCompra;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "total_precio")
    private Double totalPrecio;
    @Size(max = 20)
    @Column(name = "estado")
    private String estado;
    @Column(name = "fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @Column(name = "sub_total")
    private Integer subTotal;
    @Column(name = "iva")
    private Double iva;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ordenCompraIdordenCompra", fetch = FetchType.LAZY)
    private List<ProductoHasOrdenCompra> productoHasOrdenCompraList;
    @JoinColumn(name = "usuario_idusuario", referencedColumnName = "idusuario")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Usuario usuarioIdusuario;

    public OrdenCompra() {
    }

    public OrdenCompra(Integer idordenCompra) {
        this.idordenCompra = idordenCompra;
    }

    public Integer getIdordenCompra() {
        return idordenCompra;
    }

    public void setIdordenCompra(Integer idordenCompra) {
        this.idordenCompra = idordenCompra;
    }

    public Double getTotalPrecio() {
        return totalPrecio;
    }

    public void setTotalPrecio(Double totalPrecio) {
        this.totalPrecio = totalPrecio;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Integer getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(Integer subTotal) {
        this.subTotal = subTotal;
    }

    public Double getIva() {
        return iva;
    }

    public void setIva(Double iva) {
        this.iva = iva;
    }

    @XmlTransient
    public List<ProductoHasOrdenCompra> getProductoHasOrdenCompraList() {
        return productoHasOrdenCompraList;
    }

    public void setProductoHasOrdenCompraList(List<ProductoHasOrdenCompra> productoHasOrdenCompraList) {
        this.productoHasOrdenCompraList = productoHasOrdenCompraList;
    }

    public Usuario getUsuarioIdusuario() {
        return usuarioIdusuario;
    }

    public void setUsuarioIdusuario(Usuario usuarioIdusuario) {
        this.usuarioIdusuario = usuarioIdusuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idordenCompra != null ? idordenCompra.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrdenCompra)) {
            return false;
        }
        OrdenCompra other = (OrdenCompra) object;
        if ((this.idordenCompra == null && other.idordenCompra != null) || (this.idordenCompra != null && !this.idordenCompra.equals(other.idordenCompra))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.shopping.entidades.OrdenCompra[ idordenCompra=" + idordenCompra + " ]";
    }
    
}
