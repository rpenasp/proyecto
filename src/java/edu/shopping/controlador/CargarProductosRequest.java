/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.shopping.controlador;

import edu.shopping.entidades.Catalogo;
import edu.shopping.entidades.Imagen;
import edu.shopping.entidades.Producto;
import edu.shopping.entidades.Usuario;
import edu.shopping.facades.CatalogoFacadeLocal;
import edu.shopping.facades.ImagenFacadeLocal;
import edu.shopping.facades.ProductoFacadeLocal;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.file.Files;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import javax.servlet.http.Part;

/**
 *
 * @author roxi9
 */
@Named(value = "cargarProductosRequest")
@RequestScoped
public class CargarProductosRequest {

    @EJB
    CatalogoFacadeLocal catalogoFacadeLocal;
    @EJB
    ProductoFacadeLocal productoFacadeLocal;
    @EJB
    ImagenFacadeLocal imgagenFacadeLocal;

    private Part imgProducto;
    private Part imgProducto2;
    private Part imgProducto3;
    private Part imgProducto4;
    private Part imgProducto5;
    private String idCatalogo;
    private String nombre;
    private String nombreCat;
    private String descripcion;
    private String marca;
    private int precio;
    private float impuesto;
    private String folder = ("C:\\Users\\roxi9\\Documents\\NetBeansProjects\\shopping2\\web\\img\\Imagenes");
    private Catalogo catalogo;
    private Producto producto;
    private Imagen imagenId;

    public CargarProductosRequest() {
    }

    public Part getImgProducto() {
        return imgProducto;
    }

    public void setImgProducto(Part imgProducto) {
        this.imgProducto = imgProducto;
    }

    public Part getImgProducto2() {
        return imgProducto2;
    }

    public void setImgProducto2(Part imgProducto2) {
        this.imgProducto2 = imgProducto2;
    }

    public Part getImgProducto3() {
        return imgProducto3;
    }

    public void setImgProducto3(Part imgProducto3) {
        this.imgProducto3 = imgProducto3;
    }

    public Part getImgProducto4() {
        return imgProducto4;
    }

    public void setImgProducto4(Part imgProducto4) {
        this.imgProducto4 = imgProducto4;
    }

    public Part getImgProducto5() {
        return imgProducto5;
    }

    public void setImgProducto5(Part imgProducto5) {
        this.imgProducto5 = imgProducto5;
    }

    public String getIdCatalogo() {
        return idCatalogo;
    }

    public void setIdCatalogo(String idCatalogo) {
        this.idCatalogo = idCatalogo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public float getImpuesto() {
        return impuesto;
    }

    public void setImpuesto(float impuesto) {
        this.impuesto = impuesto;
    }

    public String getFolder() {
        return folder;
    }

    public void setFolder(String folder) {
        this.folder = folder;
    }

    public Catalogo getCatalogo() {
        return catalogo;
    }

    public void setCatalogo(Catalogo catalogo) {
        this.catalogo = catalogo;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public String getNombreCat() {
        return nombreCat;
    }

    public void setNombreCat(String nombreCat) {
        this.nombreCat = nombreCat;
    }

    public Imagen getImagenId() {
        return imagenId;
    }

    public void setImagenId(Imagen imagenId) {
        this.imagenId = imagenId;
    }

    public List<Producto> listarP() {
        try {
            return productoFacadeLocal.findAll();
        } catch (Exception e) {
            return null;
        }
    }

   public List<Object> mostrarProduc() {
        try {
            return productoFacadeLocal.mostrarProduc();
        } catch (Exception e) {
            return null;
        }
    }
   
   public List<Object> mostrarProductos11() {
        try {
            return productoFacadeLocal.mostrarProductos1();
        } catch (Exception e) {
            return null;
        }
    }
   
  
   public List<Catalogo> mostrarCatalogos() {
        try {
            return catalogoFacadeLocal.findAll();
        } catch (Exception e) {
            return null;
        }
    }
   
    public void validarArchivo(FacesContext ctx, UIComponent comp, Object value) throws IOException {

        List<FacesMessage> msgs = new ArrayList<FacesMessage>();
        Part file = (Part) value;
        if (file.getSize() > 1000024) {
            msgs.add(new FacesMessage("El archivo es muy grande"));
        }
        if (!"image/jpeg".equals(file.getContentType())) {
            msgs.add(new FacesMessage("No es una imagen jpeg"));
        }
        if (!msgs.isEmpty()) {
            throw new ValidatorException(msgs);
        }

    }

    public void conCat() {
        try {
            productoFacadeLocal.listaProduc();

        } catch (Exception e) {
        }
    }

    public String subirProducto() {
        try {
            InputStream input = imgProducto.getInputStream();
            String fileName = imgProducto.getSubmittedFileName();
            Calendar hoy = Calendar.getInstance();
            DateFormat formatter = new SimpleDateFormat("ddMMyyyyhhmmss");
            fileName = formatter.format(hoy.getTime()) + fileName;
            Files.copy(input, new File(folder, fileName).toPath());

            
            int posicion = catalogoFacadeLocal.consultaIdC(this.nombreCat);
            catalogo = catalogoFacadeLocal.find(posicion);

            Producto objProducto = new Producto();
            objProducto.setCatalogoIdcatalogo(catalogo);
            objProducto.setDescripcion(descripcion);
            objProducto.setImpuesto(impuesto);
            objProducto.setNombre(nombre);
            objProducto.setPrecio(precio);
            objProducto.setMarca(marca);
            productoFacadeLocal.create(objProducto);

            Imagen img = new Imagen();
            img.setProductoIdproducto(objProducto);
            img.setRuta(fileName);
            img.setEstado("Principal");
            imgagenFacadeLocal.create(img);
            
            
            InputStream input2 = imgProducto2.getInputStream();
            String fileName2 = imgProducto2.getSubmittedFileName();
            Calendar hoy2 = Calendar.getInstance();
            DateFormat formatter2 = new SimpleDateFormat("ddMMyyyyhhmmss");
            fileName2 = formatter2.format(hoy2.getTime()) + fileName2;
            Files.copy(input2, new File(folder, fileName2).toPath());

            Imagen img2 = new Imagen();
            img2.setProductoIdproducto(objProducto);
            img2.setRuta(fileName2);
            img2.setEstado("Secundaria");
            imgagenFacadeLocal.create(img2);
            
            InputStream input3 = imgProducto3.getInputStream();
            String fileName3 = imgProducto3.getSubmittedFileName();
            Calendar hoy3 = Calendar.getInstance();
            DateFormat formatter3 = new SimpleDateFormat("ddMMyyyyhhmmss");
            fileName3 = formatter3.format(hoy3.getTime()) + fileName3;
            Files.copy(input3, new File(folder, fileName3).toPath());

            Imagen img3 = new Imagen();
            img3.setProductoIdproducto(objProducto);
            img3.setRuta(fileName3);
            img3.setEstado("Secundaria");
            imgagenFacadeLocal.create(img3);
            
            InputStream input4 = imgProducto4.getInputStream();
            String fileName4 = imgProducto4.getSubmittedFileName();
            Calendar hoy4 = Calendar.getInstance();
            DateFormat formatter4 = new SimpleDateFormat("ddMMyyyyhhmmss");
            fileName4 = formatter4.format(hoy4.getTime()) + fileName4;
            Files.copy(input4, new File(folder, fileName4).toPath());

            Imagen img4 = new Imagen();
            img4.setProductoIdproducto(objProducto);
            img4.setRuta(fileName4);
            img4.setEstado("Secundaria");
            imgagenFacadeLocal.create(img4);
            
            InputStream input5 = imgProducto5.getInputStream();
            String fileName5 = imgProducto5.getSubmittedFileName();
            Calendar hoy5 = Calendar.getInstance();
            DateFormat formatter5 = new SimpleDateFormat("ddMMyyyyhhmmss");
            fileName5 = formatter5.format(hoy5.getTime()) + fileName5;
            Files.copy(input5, new File(folder, fileName5).toPath());

            Imagen img5 = new Imagen();
            img5.setProductoIdproducto(objProducto);
            img5.setRuta(fileName5);
            img5.setEstado("Secundaria");
            imgagenFacadeLocal.create(img5);
            
            

        } catch (Exception e) {
            e.printStackTrace();
        }
        this.descripcion = "";
        this.impuesto = 0;
        this.nombre = "";
        this.precio = 0;
        this.marca = "";
        return "cargarDatosRegistroP.xhtml";

    }
    
     public List<Producto> mostrarProductosxcategoria(int idCat){
         try {
           return productoFacadeLocal.mostrarProductosxcategoria(idCat);
         } catch (Exception e) {
             return null;
         }
     }

}
