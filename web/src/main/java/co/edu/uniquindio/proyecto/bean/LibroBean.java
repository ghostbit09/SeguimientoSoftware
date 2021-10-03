package co.edu.uniquindio.proyecto.bean;

import co.edu.uniquindio.proyecto.entidades.Libro;
import co.edu.uniquindio.proyecto.servicios.LibroServicio;
import co.edu.uniquindio.proyecto.servicios.ReseniaServicio;
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
    private final ReseniaServicio reseniaServicio;

    @Getter
    @Setter
    private Libro libro;

    public LibroBean(LibroServicio libroServicio, ReseniaServicio reseniaServicio) {
        this.libroServicio = libroServicio;
        this.reseniaServicio = reseniaServicio;
    }

    @PostConstruct
    public void inicializar() {

        this.libro = new Libro();
    }


}
