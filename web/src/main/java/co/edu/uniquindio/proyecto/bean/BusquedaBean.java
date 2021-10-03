package co.edu.uniquindio.proyecto.bean;

import co.edu.uniquindio.proyecto.entidades.Libro;
import co.edu.uniquindio.proyecto.servicios.LibroServicio;
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
public class BusquedaBean implements Serializable {

    @Value("#{param['busquedaAutor']}")
    private String busquedaParam;

    @Value("#{param['busquedaTitulo']}")
    private String busquedaParam2;

    @Value("#{param['busquedaIsbn']}")
    private String busquedaParam3;

    private String busquedaAutor;
    private String busquedaTitulo;
    private String busquedaIsbn;

    private List<Libro> libros;

    @Autowired
    private LibroServicio libroServicio;

    @PostConstruct
    public void inicializar() throws Exception {
        if (busquedaParam!=null && !busquedaParam.isEmpty() && busquedaParam2!=null && !busquedaParam2.isEmpty()) {

            System.out.println(busquedaParam);
            libros= libroServicio.obtenerLibrosTituloAutor(busquedaParam,busquedaParam2);

            System.out.println(libros);

        }else{
            libros = libroServicio.obtenerLibrosCombinacion(busquedaParam,busquedaParam2,busquedaParam3);
        }
    }

    public String buscarSimple(){
        if(!busquedaAutor.isEmpty() && !busquedaTitulo.isEmpty()){
            return "resultadoBusqueda?faces-redirect=true&amp;busquedaAutor="+busquedaAutor +"&busquedaTitulo="+busquedaTitulo;

            //return "/usuario/ruta?faces-redirect=true&amp;latitud="+lugar.getLatitud()+"&"+"longitud="+lugar.getLongitud();
        }
        return "";
    }

    public String buscarCombinada(){
        if(!busquedaAutor.isEmpty() && !busquedaTitulo.isEmpty()){
            return "resultadoBusqueda?faces-redirect=true&amp;busquedaAutor="+busquedaAutor +"&busquedaTitulo="+busquedaTitulo+"&busquedaIsbn="+busquedaIsbn;
        }
        return "";
    }

    public String getBusquedaParam() {
        return busquedaParam;
    }

    public void setBusquedaParam(String busquedaParam) {
        this.busquedaParam = busquedaParam;
    }

    public String getBusquedaParam2() {
        return busquedaParam2;
    }

    public void setBusquedaParam2(String busquedaParam2) {
        this.busquedaParam2 = busquedaParam2;
    }

    public String getBusquedaParam3() {
        return busquedaParam3;
    }

    public void setBusquedaParam3(String busquedaParam3) {
        this.busquedaParam3 = busquedaParam3;
    }

    public String getBusquedaAutor() {
        return busquedaAutor;
    }

    public void setBusquedaAutor(String busquedaAutor) {
        this.busquedaAutor = busquedaAutor;
    }

    public String getBusquedaTitulo() {
        return busquedaTitulo;
    }

    public void setBusquedaTitulo(String busquedaTitulo) {
        this.busquedaTitulo = busquedaTitulo;
    }

    public String getBusquedaIsbn() {
        return busquedaIsbn;
    }

    public void setBusquedaIsbn(String busquedaIsbn) {
        this.busquedaIsbn = busquedaIsbn;
    }

    public List<Libro> getLibros() {
        return libros;
    }

    public void setLibros(List<Libro> libros) {
        this.libros = libros;
    }
}
