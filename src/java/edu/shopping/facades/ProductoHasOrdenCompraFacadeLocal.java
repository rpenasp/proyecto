/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.shopping.facades;

import edu.shopping.entidades.ProductoHasOrdenCompra;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author roxi9
 */
@Local
public interface ProductoHasOrdenCompraFacadeLocal {

    void create(ProductoHasOrdenCompra productoHasOrdenCompra);

    void edit(ProductoHasOrdenCompra productoHasOrdenCompra);

    void remove(ProductoHasOrdenCompra productoHasOrdenCompra);

    ProductoHasOrdenCompra find(Object id);

    List<ProductoHasOrdenCompra> findAll();

    List<ProductoHasOrdenCompra> findRange(int[] range);

    int count();
    
}
