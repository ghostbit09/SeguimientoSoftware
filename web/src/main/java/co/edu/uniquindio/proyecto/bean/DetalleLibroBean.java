package co.edu.uniquindio.proyecto.bean;

import co.edu.uniquindio.proyecto.entidades.Libro;
import co.edu.uniquindio.proyecto.entidades.Reseña;
import co.edu.uniquindio.proyecto.servicios.LibroServicio;
import co.edu.uniquindio.proyecto.servicios.ReseñaServicio;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import java.io.Serializable;
import java.util.List;


@Component
@ViewScoped
public class DetalleLibroBean implements Serializable {

    @Value("#{param['libro']}")
    private  String idLibro;

    @Getter
    @Setter
    private Reseña reseñaNueva;

    @Getter @Setter
    private int calificacionPromedio;

    @Getter @Setter
    private List<Reseña> reseñasDetal;

    @Getter
    @Setter
    private Libro libro;

    @Autowired
    private LibroServicio libroServicio;

    @Autowired
    private ReseñaServicio reseñaServicio;

    @PostConstruct
    public void inicializar(){

        this.reseñaNueva = new Reseña();

        if (idLibro!=null && !"".equals(idLibro)){
            try {
                int id = Integer.parseInt(idLibro);

                this.libro = libroServicio.obtenerLibro(id);
                this.reseñasDetal =  obtenerReseñas();
                this.calificacionPromedio = libroServicio.obtenerCalificacionPromedio(id);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public List<Reseña> obtenerReseñas(){

        List<Reseña> reseñas;

        if (idLibro!=null){

            int id = Integer.parseInt(idLibro);

            try {
                reseñas = reseñaServicio.obtenerReseñasLibro(id);

                return reseñas;

            }catch (Exception e){
                e.printStackTrace();
            }
        }

        return null;
    }


    public void ingresarReseña(){

        Libro libroEncontrado;

        try {
            int id = Integer.parseInt(idLibro);
            libroEncontrado = libroServicio.obtenerLibro(id);

                libroServicio.ingresarReseña(reseñaNueva,libroEncontrado);
                this.reseñaNueva = new Reseña();
                this.calificacionPromedio = libroServicio.obtenerCalificacionPromedio(id);
        }catch (Exception e){
            e.printStackTrace();
        }
    }


}
