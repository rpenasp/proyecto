/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.shopping.facades;

import edu.shopping.entidades.UsuarioHasRol;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author roxi9
 */
@Local
public interface UsuarioHasRolFacadeLocal {

    void create(UsuarioHasRol usuarioHasRol);

    void edit(UsuarioHasRol usuarioHasRol);

    void remove(UsuarioHasRol usuarioHasRol);

    UsuarioHasRol find(Object id);

    List<UsuarioHasRol> findAll();

    List<UsuarioHasRol> findRange(int[] range);

    int count();
    
}
