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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author roxi9
 */
@Entity
@Table(name = "imagen")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Imagen.findAll", query = "SELECT i FROM Imagen i")})
public class Imagen implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idimagen")
    private Integer idimagen;
    @Size(max = 255)
    @Column(name = "ruta")
    private String ruta;
    @Size(max = 10)
    @Column(name = "estado")
    private String estado;
    @JoinColumn(name = "catalogo_idcatalogo", referencedColumnName = "idcatalogo")
    @ManyToOne(fetch = FetchType.LAZY)
    private Catalogo catalogoIdcatalogo;
    @JoinColumn(name = "usuario_idusuario", referencedColumnName = "idusuario")
    @ManyToOne(fetch = FetchType.LAZY)
    private Usuario usuarioIdusuario;
    @JoinColumn(name = "producto_idproducto", referencedColumnName = "idproducto")
    @ManyToOne(fetch = FetchType.LAZY)
    private Producto productoIdproducto;

    public Imagen() {
    }

    public Imagen(Integer idimagen) {
        this.idimagen = idimagen;
    }

    public Integer getIdimagen() {
        return idimagen;
    }

    public void setIdimagen(Integer idimagen) {
        this.idimagen = idimagen;
    }

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Catalogo getCatalogoIdcatalogo() {
        return catalogoIdcatalogo;
    }

    public void setCatalogoIdcatalogo(Catalogo catalogoIdcatalogo) {
        this.catalogoIdcatalogo = catalogoIdcatalogo;
    }

    public Usuario getUsuarioIdusuario() {
        return usuarioIdusuario;
    }

    public void setUsuarioIdusuario(Usuario usuarioIdusuario) {
        this.usuarioIdusuario = usuarioIdusuario;
    }

    public Producto getProductoIdproducto() {
        return productoIdproducto;
    }

    public void setProductoIdproducto(Producto productoIdproducto) {
        this.productoIdproducto = productoIdproducto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idimagen != null ? idimagen.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Imagen)) {
            return false;
        }
        Imagen other = (Imagen) object;
        if ((this.idimagen == null && other.idimagen != null) || (this.idimagen != null && !this.idimagen.equals(other.idimagen))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.shopping.entidades.Imagen[ idimagen=" + idimagen + " ]";
    }
    
}
