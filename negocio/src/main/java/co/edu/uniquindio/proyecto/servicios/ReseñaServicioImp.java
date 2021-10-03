package co.edu.uniquindio.proyecto.servicios;

import co.edu.uniquindio.proyecto.entidades.Reseña;
import co.edu.uniquindio.proyecto.repositorios.LibroRepo;
import co.edu.uniquindio.proyecto.repositorios.ReseñaRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReseñaServicioImp implements ReseñaServicio{

    private final ReseñaRepo reseñaRepo;
    private final LibroRepo libroRepo;

    public ReseñaServicioImp(ReseñaRepo reseñaRepo, LibroRepo libroRepo) {
        this.reseñaRepo = reseñaRepo;
        this.libroRepo = libroRepo;
    }

    @Override
    public Reseña registrarReseña(Reseña reseña) throws Exception {

        try{
            return reseñaRepo.save(reseña);
        }catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public List<Reseña> obtenerReseñasLibro(int idLibro) throws Exception {

        List<Reseña>reseñasLibro = libroRepo.obtenerReseñasLibro(idLibro);

        if(reseñasLibro ==null){

            throw new Exception("No se encontraron las reseñas");
        }

        return reseñasLibro ;
    }

    @Override
    public List<Reseña> listarReseñas() {
        return reseñaRepo.findAll();
    }

}
