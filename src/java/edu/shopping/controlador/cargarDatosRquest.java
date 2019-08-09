package edu.shopping.controlador;

import edu.shopping.entidades.Catalogo;
import edu.shopping.entidades.Rol;
import edu.shopping.entidades.Usuario;
import edu.shopping.entidades.UsuarioHasRol;
import edu.shopping.facades.CatalogoFacadeLocal;
import edu.shopping.facades.RolFacadeLocal;
import edu.shopping.facades.UsuarioFacadeLocal;
import edu.shopping.facades.UsuarioHasRolFacadeLocal;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import javax.mail.MessagingException;
import javax.servlet.http.Part;
import org.jboss.weld.bean.builtin.FacadeInjectionPoint;

/**
 *
 * @author roxi9
 */
@Named(value = "cargarDatosRquest")
@RequestScoped
public class cargarDatosRquest {

    @EJB
    CatalogoFacadeLocal catalogoFacadeLocal;
    @EJB
    UsuarioFacadeLocal usuarioFacadeLocal;
    @EJB
    RolFacadeLocal rolFacadeLocal;
    @EJB
    UsuarioHasRolFacadeLocal UsuarioHasRolFacade;

    private Part cargarRol;
    private Part cargarUsuario;
    private Rol Idrol;
    private Usuario IdUsuarios;

    public cargarDatosRquest() {
    }

    public Part getCargarRol() {
        return cargarRol;
    }

    public void setCargarRol(Part cargarRol) {
        this.cargarRol = cargarRol;
    }

    public Part getCargarUsuario() {
        return cargarUsuario;
    }

    public void setCargarUsuario(Part cargarUsuario) {
        this.cargarUsuario = cargarUsuario;
    }

    public Rol getIdrol() {
        return Idrol;
    }

    public void setIdrol(Rol Idrol) {
        this.Idrol = Idrol;
    }

    public Usuario getIdUsuarios() {
        return IdUsuarios;
    }

    public void setIdUsuarios(Usuario IdUsuarios) {
        this.IdUsuarios = IdUsuarios;
    }

    public List<Rol> listarRoles() {
        try {
            return rolFacadeLocal.findAll();
        } catch (Exception e) {
            return null;
        }

    }

    public List<Usuario> listaUsu() {
        try {
            return usuarioFacadeLocal.findAll();
        } catch (Exception e) {
            return null;
        }
    }

    public void cargarRol() {
        try {

            InputStreamReader reader = new InputStreamReader(cargarRol.getInputStream());
            BufferedReader br = new BufferedReader(reader);
            String line;
            while ((line = br.readLine()) != null) {

                Rol objRol = new Rol();
                objRol.setNombre(line);
                rolFacadeLocal.create(objRol);

                Idrol = objRol;

            }
        } catch (Exception e) {
        }
    }

    public void cargarUsuario() {
        try {
           
            InputStreamReader readerUsu = new InputStreamReader(cargarUsuario.getInputStream());
            BufferedReader brR = new BufferedReader(readerUsu);
            String lineUsuario;
            while ((lineUsuario = brR.readLine()) != null) {
                String[] dUsu = lineUsuario.split(",");
                Usuario objUsu = new Usuario();
                objUsu.setTipoDocumento(dUsu[0]);
                objUsu.setDocumento(dUsu[1]);
                objUsu.setNombre(dUsu[2]);
                objUsu.setUsuario(dUsu[3]);
                objUsu.setContrasena(dUsu[4]);
                objUsu.setCorreo(dUsu[5]);
                objUsu.setDireccion(dUsu[6]);
                objUsu.setApellido(dUsu[7]);
                objUsu.setCelular(dUsu[8]);
                
                IdUsuarios = objUsu;
              
                usuarioFacadeLocal.create(objUsu);
                 
                boolean resultado = usuarioFacadeLocal.asignarRol2(IdUsuarios.getIdusuario());

            }

        } catch (Exception e) {
        }
    }

    public void validarArchivo(FacesContext fct, UIComponent Componente, Object Archivo) {
        List<FacesMessage> listaMensajes = new ArrayList<FacesMessage>();
        javax.servlet.http.Part Archi = (javax.servlet.http.Part) Archivo;

        if (Archi.getSize() > 1024) {

            listaMensajes.add(new FacesMessage("El archivo es demasiado grande"));
        }
        if (!"text/plain".equals(Archi.getContentType())) {
            listaMensajes.add(new FacesMessage("El archivo no es un .txt"));
        }
        if (!listaMensajes.isEmpty()) {
            throw new ValidatorException(listaMensajes);
        }

    }

}
