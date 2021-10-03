package co.edu.uniquindio.proyecto.servicios;

import co.edu.uniquindio.proyecto.entidades.Resenia;
import co.edu.uniquindio.proyecto.repositorios.LibroRepo;
import co.edu.uniquindio.proyecto.repositorios.ReseniaRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReseniaServicioImp implements ReseniaServicio {

    private final ReseniaRepo reseniaRepo;
    private final LibroRepo libroRepo;

    public ReseniaServicioImp(ReseniaRepo reseniaRepo, LibroRepo libroRepo) {
        this.reseniaRepo = reseniaRepo;
        this.libroRepo = libroRepo;
    }

    @Override
    public Resenia registrarResenia(Resenia resenia) throws Exception {

        try{
            return reseniaRepo.save(resenia);
        }catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public List<Resenia> obtenerReseniasLibro(int idLibro) throws Exception {

        List<Resenia>reseñasLibro = libroRepo.obtenerReseñasLibro(idLibro);

        if(reseñasLibro ==null){

            throw new Exception("No se encontraron las reseñas");
        }

        return reseñasLibro ;
    }

    @Override
    public List<Resenia> listarResenias() {
        return reseniaRepo.findAll();
    }

}
