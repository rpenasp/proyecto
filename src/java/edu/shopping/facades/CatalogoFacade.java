/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.shopping.facades;

import edu.shopping.entidades.Catalogo;
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
public class CatalogoFacade extends AbstractFacade<Catalogo> implements CatalogoFacadeLocal {

    @PersistenceContext(unitName = "shopping2PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CatalogoFacade() {
        super(Catalogo.class);
    }
    
    @Override
    public int consultaIdC (String nombreCat) {
        try {
            Query cUsuarios = em.createNativeQuery("select idcatalogo from catalogo where nombre=?");
            cUsuarios.setParameter(1, nombreCat);
            int posicion = Integer.parseInt(cUsuarios.getSingleResult().toString());
            return posicion;         
        } catch (Exception e) {
            return 0;
        }
    }
    
    @Override
    public List<Object> mostrarCategorias(){
        try {
            List<Object> rutaImg = new ArrayList<>();
            Query mostrarImg= em.createNativeQuery("SELECT catalogo.nombre,`ruta`,`estado` FROM `imagen` INNER JOIN catalogo ON catalogo.idcatalogo=imagen.catalogo_idcatalogo WHERE `catalogo_idcatalogo`=`catalogo_idcatalogo`");
            rutaImg = mostrarImg.getResultList();
            return rutaImg;
        } catch (Exception e) {
            return null;
        }
    
    }
    @Override
    public List<Object> mostrarCategorias2(){
        try {
            List<Object> rutaImg = new ArrayList<>();
            Query mostrarImg= em.createNativeQuery("SELECT catalogo.nombre,`ruta` FROM `imagen` INNER JOIN catalogo ON catalogo.idcatalogo=imagen.catalogo_idcatalogo WHERE `catalogo_idcatalogo`=`catalogo_idcatalogo`");
            rutaImg = mostrarImg.getResultList();
            return rutaImg;
        } catch (Exception e) {
            return null;
        }
    
    }
    
    @Override
      public List<Object> mostrarCategorias3(){
        try {
            List<Object> rutaImg = new ArrayList<>();
            Query mostrarImg= em.createNativeQuery("SELECT catalogo.nombre FROM `imagen` INNER JOIN catalogo ON catalogo.idcatalogo=imagen.catalogo_idcatalogo WHERE `catalogo_idcatalogo`=`catalogo_idcatalogo`");
            rutaImg = mostrarImg.getResultList();
            return rutaImg;
        } catch (Exception e) {
            return null;
        }
    
    }
   
}
