package co.edu.uniquindio.proyecto.servicios;

import co.edu.uniquindio.proyecto.entidades.Imagen;

import java.util.List;

public interface ImagenServicio {

    List<Imagen> obtenerImagenesLibro(int idLibro) throws Exception;

    Imagen obtenerImagen(int id) throws Exception;

    List<Imagen> listarImagenes() ;

    Imagen registrarImagen(Imagen i) throws Exception;
}
