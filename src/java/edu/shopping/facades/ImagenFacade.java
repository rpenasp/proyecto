/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.shopping.facades;

import edu.shopping.entidades.Imagen;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author roxi9
 */
@Stateless
public class ImagenFacade extends AbstractFacade<Imagen> implements ImagenFacadeLocal {

    @PersistenceContext(unitName = "shopping2PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ImagenFacade() {
        super(Imagen.class);
    }
    
    @Override
        public int consultaIdP (String nombre) {
        try {
            Query cUsuarios = em.createNativeQuery("select idproducto from producto where nombre=?");
            cUsuarios.setParameter(1, nombre);
            int posicion = Integer.parseInt(cUsuarios.getSingleResult().toString());
            return posicion;         
        } catch (Exception e) {
            return 0;
        }
    }
    
}
