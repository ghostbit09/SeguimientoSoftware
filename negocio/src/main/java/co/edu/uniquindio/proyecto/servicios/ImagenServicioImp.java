package co.edu.uniquindio.proyecto.servicios;

import co.edu.uniquindio.proyecto.entidades.Imagen;
import co.edu.uniquindio.proyecto.repositorios.ImagenRepo;
import co.edu.uniquindio.proyecto.repositorios.LibroRepo;

import java.util.List;
import java.util.Optional;

public class ImagenServicioImp implements ImagenServicio{

    private final ImagenRepo imagenRepo;
    private final LibroRepo libroRepo;

    public ImagenServicioImp(ImagenRepo imagenRepo, LibroRepo libroRepo) {
        this.imagenRepo = imagenRepo;
        this.libroRepo = libroRepo;
    }

    @Override
    public Imagen registrarImagen(Imagen i) throws Exception {

        if (i.getUrl().length() > 100){
            throw  new Exception("La URL no es valida");
        }

        return imagenRepo.save(i);
    }

    @Override
    public List<Imagen> obtenerImagenesLibro(int idLibro) throws Exception {

        List<Imagen> imagenes = libroRepo.obtenerImagenes(idLibro);

        if(imagenes ==null){
            throw new Exception("No se encontraron las imagenes");
        }

        return imagenes;
    }

    @Override
    public Imagen obtenerImagen(int id) throws Exception {

        Optional<Imagen> imagen = imagenRepo.findById(id);

        if(imagen.isEmpty()){
            throw  new Exception("No se encontro la imagen");
        }
        return imagen.get();
    }

    @Override
    public List<Imagen> listarImagenes() {
        return imagenRepo.findAll();
    }
}
