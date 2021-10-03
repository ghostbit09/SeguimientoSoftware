package co.edu.uniquindio.proyecto.bean;

import co.edu.uniquindio.proyecto.entidades.Imagen;
import co.edu.uniquindio.proyecto.entidades.Libro;
import co.edu.uniquindio.proyecto.servicios.ImagenServicio;
import co.edu.uniquindio.proyecto.servicios.LibroServicio;
import co.edu.uniquindio.proyecto.servicios.ReseniaServicio;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.file.UploadedFile;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.Serializable;
import java.util.ArrayList;

@Component
@ViewScoped
public class LibroBean implements Serializable {

    private final LibroServicio libroServicio;
    private final ReseniaServicio reseniaServicio;
    private final ImagenServicio imagenServicio;

    @Value("${upload.url}")
    private String urlImagenes;
    private ArrayList<Imagen> imagenes;

    @Getter
    @Setter
    private Libro libro;

    public LibroBean(LibroServicio libroServicio, ReseniaServicio reseniaServicio, ImagenServicio imagenServicio) {
        this.libroServicio = libroServicio;
        this.reseniaServicio = reseniaServicio;
        this.imagenServicio = imagenServicio;
    }

    @PostConstruct
    public void inicializar() {

        this.libro = new Libro();
        this.imagenes = new ArrayList<>();
    }

}
