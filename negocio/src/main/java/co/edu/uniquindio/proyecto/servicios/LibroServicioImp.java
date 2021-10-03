package co.edu.uniquindio.proyecto.servicios;

import co.edu.uniquindio.proyecto.entidades.Libro;
import co.edu.uniquindio.proyecto.entidades.Resenia;
import co.edu.uniquindio.proyecto.repositorios.LibroRepo;
import co.edu.uniquindio.proyecto.repositorios.ReseniaRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LibroServicioImp implements LibroServicio{

    private final LibroRepo libroRepo;
    private final ReseniaRepo reseñaRepo;

    public LibroServicioImp(LibroRepo libroRepo, ReseniaRepo reseniaRepo) {
        this.libroRepo = libroRepo;
        this.reseñaRepo = reseniaRepo;
    }

    @Override
    public List<Libro> obtenerLibrosTituloAutor(String busquedaAutor,String busquedaTitulo) throws Exception{

        return libroRepo.busquedaLibrosTituloAutor(busquedaAutor,busquedaTitulo);
    }

    @Override
    public List<Libro> obtenerLibrosCombinacion(String busquedaAutor,String busquedaTitulo,String busquedaIsbn) throws Exception {

        return libroRepo.busquedaLibrosCombinacion(busquedaAutor,busquedaTitulo,busquedaIsbn);
    }

    @Override
    public int obtenerCalificacionPromedio(int idLibro) throws Exception {

        Integer calificacion=0;
        Libro libroEncontrado= libroRepo.obtenerLibro(idLibro);

        if (libroEncontrado!=null){

            calificacion = libroRepo.obtenerCalificacionLibro(libroEncontrado.getId());


        }else{
            throw new Exception("El libro no fue encontrado");
        }

        if(calificacion==null){

            return 0;
        }
        else{
            return calificacion;
        }
    }

    @Override
    public void ingresarReseña(Resenia r, Libro libro) throws Exception {

        try {
            if (libro != null) {

                r.setLibro(libro);
                reseñaRepo.save(r);
            }
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Libro obtenerLibro(int id) throws Exception {

        Optional<Libro> lugar = libroRepo.findById(id);

        if(lugar.isEmpty()){
            throw  new Exception("No se encontro el libro");
        }

        return lugar.get();
    }

    @Override
    public List<Libro> listarLibros() {
        return libroRepo.findAll();
    }
}
