
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.shopping.facades;

import edu.shopping.entidades.Usuario;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author roxi9
 */
@Local
public interface UsuarioFacadeLocal {

    void create(Usuario usuario);

    void edit(Usuario usuario);

    void remove(Usuario usuario);

    Usuario find(Object id);

    List<Usuario> findAll();

    List<Usuario> findRange(int[] range);

    int count();

    public boolean ingresarUsuario(Usuario usuarioIn);

    public int consultaId(String numeroDoc);

    public boolean asignarRol(int usuarioId, int rolId);

    public Usuario iniciarSesion(String correo, String clave);

    public int consulraRol(int idUsu);

    public String consutlaDos(int idRol);

    public boolean asignarRol2(int usuarioId2);

    public int consultaId1(String idCed);
    
    
    
}