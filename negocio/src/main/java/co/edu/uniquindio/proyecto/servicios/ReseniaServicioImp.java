package co.edu.uniquindio.proyecto.servicios;

import co.edu.uniquindio.proyecto.entidades.Resenia;
import co.edu.uniquindio.proyecto.repositorios.LibroRepo;
import co.edu.uniquindio.proyecto.repositorios.ReseniaRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReseniaServicioImp implements ReseniaServicio {

    private final ReseniaRepo reseñaRepo;
    private final LibroRepo libroRepo;

    public ReseniaServicioImp(ReseniaRepo reseniaRepo, LibroRepo libroRepo) {
        this.reseñaRepo = reseniaRepo;
        this.libroRepo = libroRepo;
    }

    @Override
    public Resenia registrarReseña(Resenia resenia) throws Exception {

        try{
            return reseñaRepo.save(resenia);
        }catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public List<Resenia> obtenerReseñasLibro(int idLibro) throws Exception {

        List<Resenia>reseñasLibro = libroRepo.obtenerReseñasLibro(idLibro);

        if(reseñasLibro ==null){

            throw new Exception("No se encontraron las reseñas");
        }

        return reseñasLibro ;
    }

    @Override
    public List<Resenia> listarReseñas() {
        return reseñaRepo.findAll();
    }

}
