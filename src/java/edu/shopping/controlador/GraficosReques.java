/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.shopping.controlador;

import edu.shopping.facades.CatalogoFacade;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author roxi9
 */
@Named(value = "graficosReques")
@RequestScoped
public class GraficosReques {
    
    @EJB
    CatalogoFacade catFacadeLocal;
    
    

   
    public GraficosReques() {
    }
    
     public List<Object> mostrarCate3() {
        try {
            return catFacadeLocal.mostrarCategorias3();
        } catch (Exception e) {
            return null;
        }
    }
    
}
