/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.shopping.facades;

import edu.shopping.entidades.Usuario;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author roxi9
 */
@Stateless
public class UsuarioFacade extends AbstractFacade<Usuario> implements UsuarioFacadeLocal {

    @PersistenceContext(unitName = "shopping2PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuarioFacade() {
        super(Usuario.class);
    }

    @Override
    public boolean ingresarUsuario(Usuario usuarioIn) {

        try {
            Query cUsuario = em.createNativeQuery("insert into usuario (tipo_documento,documento,nombre,usuario,contrasena,correo,direccion,apellido,celular) values (?,?,?,?,?,?,?,?,?);");

            cUsuario.setParameter(1, usuarioIn.getTipoDocumento());
            cUsuario.setParameter(2, usuarioIn.getDocumento());
            cUsuario.setParameter(3, usuarioIn.getNombre());
            cUsuario.setParameter(4, usuarioIn.getUsuario());
            cUsuario.setParameter(5, usuarioIn.getContrasena());
            cUsuario.setParameter(6, usuarioIn.getCorreo());
            cUsuario.setParameter(7, usuarioIn.getDireccion());
            cUsuario.setParameter(8, usuarioIn.getApellido());
            cUsuario.setParameter(9, usuarioIn.getCelular());

            cUsuario.executeUpdate();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public int consultaId(String numeroDoc) {
        try {
            Query cUsuario = em.createNativeQuery("SELECT `idusuario` FROM `usuario` WHERE `documento`=?");
            cUsuario.setParameter(1, numeroDoc);
            int posicion = Integer.parseInt(cUsuario.getSingleResult().toString());
            return posicion;
        } catch (Exception e) {
            return 0;
        }
    }

    @Override
    public boolean asignarRol(int usuarioId, int rolId) {
        try {
            Query cUsuario = em.createNativeQuery("insert into usuario_has_rol (usuario_idusuario,rol_idrol) VALUES (?, 3);");
            cUsuario.setParameter(1, usuarioId);
            cUsuario.setParameter(2, rolId);
            cUsuario.executeUpdate();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public Usuario iniciarSesion(String correo, String clave) {
        try {
            Query inicioUsu = em.createQuery("SELECT f FROM Usuario f WHERE f.contrasena = :clave AND f.correo = :correo");
            inicioUsu.setParameter("clave", clave);
            inicioUsu.setParameter("correo", correo);
            List<Usuario> listaResultados = inicioUsu.getResultList();
            if (listaResultados.isEmpty()) {
                return null;
            } else {
                return listaResultados.get(0);
            }

        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public int consulraRol(int idUsu) {
        try {
            Query consUsu = em.createNativeQuery("select rol_idrol from usuario_has_rol where usuario_idusuario = ?");
            consUsu.setParameter(1, idUsu);
            int idR = Integer.parseInt(consUsu.getSingleResult().toString());
            return idR;
        } catch (Exception e) {
            return 0;
        }
    }

    @Override
    public String consutlaDos(int idRol) {
        try {
            Query consRol = em.createNativeQuery("select nombre from rol where idRol = ?");
            consRol.setParameter(1, idRol);
            String idU = consRol.getSingleResult().toString();
            return idU;
        } catch (Exception e) {
            return "";
        }
    }

    @Override
    public int consultaId1(String idCed) {
        try {
            Query cUsuario1 = em.createNativeQuery("SELECT `idusuario` FROM `usuario` WHERE `documento`=?");
            cUsuario1.setParameter(1, idCed);
            int posicion = Integer.parseInt(cUsuario1.getSingleResult().toString());
            return posicion;
        } catch (Exception e) {
            return 0;
        }
    }

    @Override
    public boolean asignarRol2(int usuarioId2) {
        try {
            Query cUsuario1 = em.createNativeQuery("insert into usuario_has_rol (usuario_idusuario,rol_idrol) VALUES (?, 3);");
            cUsuario1.setParameter(1, usuarioId2);
            cUsuario1.executeUpdate();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
