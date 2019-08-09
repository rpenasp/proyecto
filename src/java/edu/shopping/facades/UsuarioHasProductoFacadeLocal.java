/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.shopping.facades;

import edu.shopping.entidades.UsuarioHasProducto;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author roxi9
 */
@Local
public interface UsuarioHasProductoFacadeLocal {

    void create(UsuarioHasProducto usuarioHasProducto);

    void edit(UsuarioHasProducto usuarioHasProducto);

    void remove(UsuarioHasProducto usuarioHasProducto);

    UsuarioHasProducto find(Object id);

    List<UsuarioHasProducto> findAll();

    List<UsuarioHasProducto> findRange(int[] range);

    int count();
    
}
