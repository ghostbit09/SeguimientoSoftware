package co.edu.uniquindio.proyecto.servicios;

import co.edu.uniquindio.proyecto.entidades.Resenia;

import java.util.List;

public interface ReseniaServicio {

    Resenia registrarReseña(Resenia resenia) throws Exception;

    List<Resenia> obtenerReseñasLibro(int idLibro) throws Exception;

    List<Resenia> listarReseñas();
}
