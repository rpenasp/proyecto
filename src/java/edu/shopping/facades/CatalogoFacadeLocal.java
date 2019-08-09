/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.shopping.facades;

import edu.shopping.entidades.Catalogo;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author roxi9
 */
@Local
public interface CatalogoFacadeLocal {

    void create(Catalogo catalogo);

    void edit(Catalogo catalogo);

    void remove(Catalogo catalogo);

    Catalogo find(Object id);

    List<Catalogo> findAll();

    List<Catalogo> findRange(int[] range);

    int count();

    public int consultaIdC(String nombreCat);

    public List<Object> mostrarCategorias();

    public List<Object> mostrarCategorias2();

    public List<Object> mostrarCategorias3();


    
}
