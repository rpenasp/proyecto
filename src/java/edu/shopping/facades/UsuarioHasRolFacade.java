/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.shopping.facades;

import edu.shopping.entidades.UsuarioHasRol;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author roxi9
 */
@Stateless
public class UsuarioHasRolFacade extends AbstractFacade<UsuarioHasRol> implements UsuarioHasRolFacadeLocal {

    @PersistenceContext(unitName = "shopping2PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuarioHasRolFacade() {
        super(UsuarioHasRol.class);
    }
    
}
