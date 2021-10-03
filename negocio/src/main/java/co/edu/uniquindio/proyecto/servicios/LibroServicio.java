package co.edu.uniquindio.proyecto.servicios;

import co.edu.uniquindio.proyecto.entidades.Libro;
import co.edu.uniquindio.proyecto.entidades.Resenia;

import java.util.List;

public interface LibroServicio {

    List<Libro> obtenerLibrosTituloAutor(String busqueda1,String busqueda2) throws Exception;

    List<Libro> obtenerLibrosCombinacion(String busqueda1,String busqueda2,String busqueda3) throws Exception;

    List<Libro> listarLibros();

    int obtenerCalificacionPromedio(int idLibro) throws Exception;

    Libro obtenerLibro(int id) throws Exception;

    void ingresarResenia(Resenia r, Libro libro) throws Exception;

}
