/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.shopping.facades;

import edu.shopping.entidades.OrdenCompra;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author roxi9
 */
@Local
public interface OrdenCompraFacadeLocal {

    void create(OrdenCompra ordenCompra);

    void edit(OrdenCompra ordenCompra);

    void remove(OrdenCompra ordenCompra);

    OrdenCompra find(Object id);

    List<OrdenCompra> findAll();

    List<OrdenCompra> findRange(int[] range);

    int count();
    
}
