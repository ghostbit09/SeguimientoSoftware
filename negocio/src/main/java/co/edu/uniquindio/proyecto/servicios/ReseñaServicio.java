package co.edu.uniquindio.proyecto.servicios;

import co.edu.uniquindio.proyecto.entidades.Reseña;

import java.util.List;

public interface ReseñaServicio {

    Reseña registrarReseña(Reseña reseña) throws Exception;

    List<Reseña> obtenerReseñasLibro(int idLibro) throws Exception;

    List<Reseña> listarReseñas();
}
