/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.shopping.entidades;

import java.io.Serializable;
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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author roxi9
 */
@Entity
@Table(name = "producto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Producto.findAll", query = "SELECT p FROM Producto p")})
public class Producto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idproducto")
    private Integer idproducto;
    @Size(max = 100)
    @Column(name = "nombre")
    private String nombre;
    @Size(max = 100)
    @Column(name = "marca")
    private String marca;
    @Size(max = 100)
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "precio")
    private Integer precio;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "impuesto")
    private Float impuesto;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "productoIdproducto", fetch = FetchType.LAZY)
    private List<ProductoHasOrdenCompra> productoHasOrdenCompraList;
    @OneToMany(mappedBy = "productoIdproducto", fetch = FetchType.LAZY)
    private List<Imagen> imagenList;
    @JoinColumn(name = "catalogo_idcatalogo", referencedColumnName = "idcatalogo")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Catalogo catalogoIdcatalogo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "productoIdproducto", fetch = FetchType.LAZY)
    private List<UsuarioHasProducto> usuarioHasProductoList;

    public Producto() {
    }

    public Producto(Integer idproducto) {
        this.idproducto = idproducto;
    }

    public Integer getIdproducto() {
        return idproducto;
    }

    public void setIdproducto(Integer idproducto) {
        this.idproducto = idproducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getPrecio() {
        return precio;
    }

    public void setPrecio(Integer precio) {
        this.precio = precio;
    }

    public Float getImpuesto() {
        return impuesto;
    }

    public void setImpuesto(Float impuesto) {
        this.impuesto = impuesto;
    }

    @XmlTransient
    public List<ProductoHasOrdenCompra> getProductoHasOrdenCompraList() {
        return productoHasOrdenCompraList;
    }

    public void setProductoHasOrdenCompraList(List<ProductoHasOrdenCompra> productoHasOrdenCompraList) {
        this.productoHasOrdenCompraList = productoHasOrdenCompraList;
    }

    @XmlTransient
    public List<Imagen> getImagenList() {
        return imagenList;
    }

    public void setImagenList(List<Imagen> imagenList) {
        this.imagenList = imagenList;
    }

    public Catalogo getCatalogoIdcatalogo() {
        return catalogoIdcatalogo;
    }

    public void setCatalogoIdcatalogo(Catalogo catalogoIdcatalogo) {
        this.catalogoIdcatalogo = catalogoIdcatalogo;
    }

    @XmlTransient
    public List<UsuarioHasProducto> getUsuarioHasProductoList() {
        return usuarioHasProductoList;
    }

    public void setUsuarioHasProductoList(List<UsuarioHasProducto> usuarioHasProductoList) {
        this.usuarioHasProductoList = usuarioHasProductoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idproducto != null ? idproducto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Producto)) {
            return false;
        }
        Producto other = (Producto) object;
        if ((this.idproducto == null && other.idproducto != null) || (this.idproducto != null && !this.idproducto.equals(other.idproducto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.shopping.entidades.Producto[ idproducto=" + idproducto + " ]";
    }
    
}
