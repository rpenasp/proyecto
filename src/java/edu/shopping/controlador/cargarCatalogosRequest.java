package edu.shopping.controlador;

import edu.shopping.entidades.Catalogo;
import edu.shopping.entidades.Imagen;
import edu.shopping.facades.CatalogoFacadeLocal;
import edu.shopping.facades.ImagenFacadeLocal;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
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

@Named(value = "cargarCatalogosRequest")
@RequestScoped
public class cargarCatalogosRequest {

    @EJB
    ImagenFacadeLocal imgFacadeLocal;
    @EJB
    CatalogoFacadeLocal catFacadeLocal;

    private Part img;
    private String folder = "C:\\Users\\roxi9\\Documents\\NetBeansProjects\\shopping2\\web\\img\\Imagenes";
    private int idCat;
    private String nombre;
    private Catalogo catalogo;

    public cargarCatalogosRequest() {
    }

    public Part getImg() {
        return img;
    }

    public void setImg(Part img) {
        this.img = img;
    }

    public String getFolder() {
        return folder;
    }

    public void setFolder(String folder) {
        this.folder = folder;
    }

    public int getIdCat() {
        return idCat;
    }

    public void setIdCat(int idCat) {
        this.idCat = idCat;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Catalogo getCatalogo() {
        return catalogo;
    }

    public void setCatalogo(Catalogo catalogo) {
        this.catalogo = catalogo;
    }



    public List<Object> mostrarCate() {
        try {
            return catFacadeLocal.mostrarCategorias();
        } catch (Exception e) {
            return null;
        }
    }

    public List<Object> mostrarCate2() {
        try {
            return catFacadeLocal.mostrarCategorias2();
        } catch (Exception e) {
            return null;
        }
    }

    

    public void consCatalogoId() {

        try {
            int posicion = catFacadeLocal.consultaIdC(this.nombre);
            catalogo = catFacadeLocal.find(posicion);

            Imagen objImg = new Imagen();

            objImg.setRuta(folder);
            objImg.setEstado("Principal");
            objImg.setCatalogoIdcatalogo(catalogo);
            imgFacadeLocal.create(objImg);

        } catch (Exception e) {
        }
    }

    public String subirArchivos() {
        try (InputStream input = img.getInputStream()) {
            String fileName = img.getSubmittedFileName();
            Calendar hoy = Calendar.getInstance();
            DateFormat formatter = new SimpleDateFormat("ddMMyyyyhhmmss");
            fileName = formatter.format(hoy.getTime()) + fileName;
            Files.copy(input, new File(folder, fileName).toPath());

            int posicion = catFacadeLocal.consultaIdC(this.nombre);
            catalogo = catFacadeLocal.find(posicion);

            Imagen objImagen = new Imagen();

            objImagen.setRuta(fileName);
            objImagen.setEstado("Principal");
            objImagen.setCatalogoIdcatalogo(catalogo);
            imgFacadeLocal.create(objImagen);
            return "";

        } catch (IOException e) {
            e.printStackTrace();
        }
        this.nombre = "";
        return "cargarDatosCategorias.xhtm";
    }

    public void validarArchivo(FacesContext ctx, UIComponent comp, Object value) throws IOException {

        List<FacesMessage> msgs = new ArrayList<FacesMessage>();
        Part file = (Part) value;
        if (file.getSize() > 1000024) {
            msgs.add(new FacesMessage("El archivo es muy grande"));
        }
        if (!"image/jpeg".equals(file.getContentType())) {
            msgs.add(new FacesMessage("El formato de la imagen no es JPEG"));
        }
        if (!msgs.isEmpty()) {
            throw new ValidatorException(msgs);
        }

    }

}
