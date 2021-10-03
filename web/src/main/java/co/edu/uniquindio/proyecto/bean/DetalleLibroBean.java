package co.edu.uniquindio.proyecto.bean;

import co.edu.uniquindio.proyecto.entidades.Libro;
import co.edu.uniquindio.proyecto.entidades.Resenia;
import co.edu.uniquindio.proyecto.servicios.LibroServicio;
import co.edu.uniquindio.proyecto.servicios.ReseniaServicio;
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
    private Resenia reseniaNueva;

    @Getter @Setter
    private int calificacionPromedio;

    @Getter @Setter
    private List<Resenia> reseniasDetal;

    @Getter
    @Setter
    private Libro libro;

    @Autowired
    private LibroServicio libroServicio;

    @Autowired
    private ReseniaServicio reseniaServicio;

    @PostConstruct
    public void inicializar(){

        this.reseniaNueva = new Resenia();

        if (idLibro!=null && !"".equals(idLibro)){
            try {
                int id = Integer.parseInt(idLibro);

                this.libro = libroServicio.obtenerLibro(id);
                this.reseniasDetal =  obtenerResenias();
                this.calificacionPromedio = libroServicio.obtenerCalificacionPromedio(id);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public List<Resenia> obtenerResenias(){

        List<Resenia> resenias;

        if (idLibro!=null){

            int id = Integer.parseInt(idLibro);

            try {
                resenias = reseniaServicio.obtenerReseniasLibro(id);

                return resenias;

            }catch (Exception e){
                e.printStackTrace();
            }
        }

        return null;
    }


    public String ingresarResenia(){

        Libro libroEncontrado;

        try {
            int id = Integer.parseInt(idLibro);
            libroEncontrado = libroServicio.obtenerLibro(id);

                libroServicio.ingresarResenia(reseniaNueva,libroEncontrado);
                this.reseniaNueva = new Resenia();
                this.calificacionPromedio = libroServicio.obtenerCalificacionPromedio(id);

            return "detalleLibro?faces-redirect=true&amp;libro="+idLibro;

        }catch (Exception e){
            e.printStackTrace();
        }

        return "detalleLibro?faces-redirect=true&amp;libro="+idLibro;

    }


}
