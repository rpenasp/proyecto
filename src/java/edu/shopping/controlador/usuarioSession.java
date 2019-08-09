/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.shopping.controlador;

import edu.shopping.entidades.Usuario;


import edu.shopping.facades.UsuarioFacadeLocal;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.ejb.EJB;

/**
 *
 * @author roxi9
 */
@Named(value = "usuarioSession")
@SessionScoped
public class usuarioSession implements Serializable {

    @EJB
    UsuarioFacadeLocal usuarioFacadeLocal;

    private String tipoDocumento;
    private String nomUsuario;
    private String documento;
    private String nombre;
    private String apellido;
    private String correo;
    private String direccion;
    private String celular;
    private Usuario usuLogin;
    private String clave;

    public usuarioSession() {
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

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getNomUsuario() {
        return nomUsuario;
    }

    public void setNomUsuario(String nomUsuario) {
        this.nomUsuario = nomUsuario;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public Usuario getUsuLogin() {
        return usuLogin;
    }

    public void setUsuLogin(Usuario usuLogin) {
        this.usuLogin = usuLogin;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String ingresarUsuario() {
        try {
            Usuario usuLog = new Usuario();

            usuLog.setTipoDocumento(tipoDocumento);
            usuLog.setDocumento(documento);
            usuLog.setNombre(nombre);
            usuLog.setApellido(apellido);
            usuLog.setCorreo(correo);
            usuLog.setDireccion(direccion);
            usuLog.setCelular(celular);
            usuLog.setUsuario(nomUsuario);
            usuLog.setContrasena(clave);
            boolean usuarioReg;

            usuarioReg = usuarioFacadeLocal.ingresarUsuario(usuLog);

            if (usuarioReg) {
                int posicion = usuarioFacadeLocal.consultaId(documento);
                boolean resultado = usuarioFacadeLocal.asignarRol(posicion,3);
            } else {
            }

            this.tipoDocumento = "";
            this.documento = "";
            this.nombre = "";
            this.apellido = "";
            this.correo = "";
            this.direccion = "";
            this.celular = "";
            this.nomUsuario = "";
            this.clave = "";

        } catch (Exception e) {
        }
        return "";

    }

    public String validarUsuarios() {
        try {
            usuLogin = usuarioFacadeLocal.iniciarSesion(correo, clave);
            String ruta = "#";

            if (this.usuLogin != null) {
                int asigRol = usuarioFacadeLocal.consulraRol(usuLogin.getIdusuario());
                String rol = usuarioFacadeLocal.consutlaDos(asigRol);
                ruta=rol;

                return "/" + ruta + "/index.xhtml?faces-redirect=true";
            } else {
                return "#";
            }

        } catch (Exception e) {
            return "#";
        }
    }

}
