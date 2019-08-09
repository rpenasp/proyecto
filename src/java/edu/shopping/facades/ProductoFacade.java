/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.shopping.facades;

import edu.shopping.entidades.Producto;
import edu.shopping.entidades.Usuario;
import java.util.ArrayList;
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
public class ProductoFacade extends AbstractFacade<Producto> implements ProductoFacadeLocal {

    @PersistenceContext(unitName = "shopping2PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProductoFacade() {
        super(Producto.class);
    }

    @Override
    public List<Object> listaProduc() {
    
    try {
        List<Object> listaO = new ArrayList<>();
        Query listP = em.createNativeQuery("SELECT `ruta` FROM `imagen` WHERE `catalogo_idcatalogo` = `catalogo_idcatalogo`");
        listaO = listP.getResultList();
        return  listaO;
    } catch (Exception e) {
        return null;
    }

}
    @Override
      public List<Object> mostrarProduc(){
        try {
            List<Object> rutaImg = new ArrayList<>();
            Query mostrarImg= em.createNativeQuery("SELECT producto.nombre,`ruta`,`producto_idproducto`,`estado` FROM `imagen` INNER JOIN producto ON producto.idproducto=imagen.producto_idproducto WHERE `producto_idproducto`=`producto_idproducto`");
            rutaImg = mostrarImg.getResultList();
            return rutaImg;
        } catch (Exception e) {
            return null;
        }
    
    }


}
