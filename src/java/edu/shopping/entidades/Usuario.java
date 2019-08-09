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
@Table(name = "usuario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u")})
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idusuario")
    private Integer idusuario;
    @Size(max = 100)
    @Column(name = "tipo_documento")
    private String tipoDocumento;
    @Size(max = 100)
    @Column(name = "documento")
    private String documento;
    @Size(max = 100)
    @Column(name = "nombre")
    private String nombre;
    @Size(max = 100)
    @Column(name = "usuario")
    private String usuario;
    @Size(max = 100)
    @Column(name = "contrasena")
    private String contrasena;
    @Size(max = 100)
    @Column(name = "correo")
    private String correo;
    @Size(max = 100)
    @Column(name = "direccion")
    private String direccion;
    @Size(max = 100)
    @Column(name = "apellido")
    private String apellido;
    @Size(max = 100)
    @Column(name = "celular")
    private String celular;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuarioIdusuario", fetch = FetchType.LAZY)
    private List<UsuarioHasRol> usuarioHasRolList;
    @OneToMany(mappedBy = "usuarioIdusuario", fetch = FetchType.LAZY)
    private List<Imagen> imagenList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuarioIdusuario", fetch = FetchType.LAZY)
    private List<OrdenCompra> ordenCompraList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuarioIdusuario", fetch = FetchType.LAZY)
    private List<UsuarioHasProducto> usuarioHasProductoList;

    public Usuario() {
    }

    public Usuario(Integer idusuario) {
        this.idusuario = idusuario;
    }

    public Integer getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(Integer idusuario) {
        this.idusuario = idusuario;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    @XmlTransient
    public List<UsuarioHasRol> getUsuarioHasRolList() {
        return usuarioHasRolList;
    }

    public void setUsuarioHasRolList(List<UsuarioHasRol> usuarioHasRolList) {
        this.usuarioHasRolList = usuarioHasRolList;
    }

    @XmlTransient
    public List<Imagen> getImagenList() {
        return imagenList;
    }

    public void setImagenList(List<Imagen> imagenList) {
        this.imagenList = imagenList;
    }

    @XmlTransient
    public List<OrdenCompra> getOrdenCompraList() {
        return ordenCompraList;
    }

    public void setOrdenCompraList(List<OrdenCompra> ordenCompraList) {
        this.ordenCompraList = ordenCompraList;
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
        hash += (idusuario != null ? idusuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.idusuario == null && other.idusuario != null) || (this.idusuario != null && !this.idusuario.equals(other.idusuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.shopping.entidades.Usuario[ idusuario=" + idusuario + " ]";
    }
    
}
