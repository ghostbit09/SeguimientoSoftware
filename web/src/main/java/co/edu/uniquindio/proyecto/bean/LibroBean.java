package co.edu.uniquindio.proyecto.bean;

import co.edu.uniquindio.proyecto.entidades.Libro;
import co.edu.uniquindio.proyecto.servicios.LibroServicio;
import co.edu.uniquindio.proyecto.servicios.ReseñaServicio;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import java.io.Serializable;

@Component
@ViewScoped
public class LibroBean implements Serializable {

    private final LibroServicio libroServicio;
    private final ReseñaServicio reseñaServicio;

    @Getter
    @Setter
    private Libro libro;

    public LibroBean(LibroServicio libroServicio, ReseñaServicio reseñaServicio) {
        this.libroServicio = libroServicio;
        this.reseñaServicio = reseñaServicio;
    }

    @PostConstruct
    public void inicializar() {

        this.libro = new Libro();
    }


}
