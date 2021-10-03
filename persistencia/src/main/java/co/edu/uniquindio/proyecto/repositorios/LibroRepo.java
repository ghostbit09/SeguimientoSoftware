package co.edu.uniquindio.proyecto.repositorios;

import co.edu.uniquindio.proyecto.entidades.Imagen;
import co.edu.uniquindio.proyecto.entidades.Libro;
import co.edu.uniquindio.proyecto.entidades.Resenia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LibroRepo extends JpaRepository<Libro,Integer> {

    @Query("select l from Libro l where l.autor like concat('%', :busquedaAutor,'%') and l.nombre like concat('%', :busquedaTitulo,'%')")
    List<Libro> busquedaLibrosTituloAutor(String busquedaAutor,String busquedaTitulo);

    @Query("select l from Libro l where l.autor like concat('%', :busquedaAutor,'%') and l.nombre like concat('%', :busquedaTitulo,'%') and l.isbn= :busquedaIsbn ")
    List<Libro> busquedaLibrosCombinacion(String busquedaAutor,String busquedaTitulo,String busquedaIsbn);

    @Query("select l from Libro l where l.id = :idLibro")
    Libro obtenerLibro(int idLibro);

    @Query("select i from Libro l join l.imagenes i where l.id = :idLibro")
    List<Imagen> obtenerImagenes(int idLibro);

    @Query("select avg(r.calificacion) from Resenia r where r.libro.id = :idLibro")
    Integer obtenerCalificacionLibro(Integer idLibro);

    @Query("select r from Libro l join l.resenias r where l.id = :idLibro")
    List<Resenia> obtenerReseniasLibro(int idLibro);
}
