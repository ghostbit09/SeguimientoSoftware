package co.edu.uniquindio.proyecto.entidades;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Libro implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", length = 10)
    @EqualsAndHashCode.Include
    private int id;

    @Column(name = "nombre",length =100, nullable = false)
    @NotBlank
    @Size(max = 100)
    private String nombre;

    @Column(name = "autor",length =100, nullable = false)
    @NotBlank
    private String autor;

    @Column(name = "isbn",length =100, nullable = false)
    @NotBlank
    private String isbn;

    @Column(name = "descripcion",length =1000)
    private String descripcion;

    @Temporal(TemporalType.DATE)
    @Column(name = "fecha_publicacion", nullable = false)
    private Date fechaPublicacion;

    @OneToMany(mappedBy = "libro")
    @ToString.Exclude
    private List<Resenia> resenias;

    @OneToMany(mappedBy = "libro",fetch=FetchType.EAGER)
    @ToString.Exclude
    private List<Imagen> imagenes;

    @Builder
    public Libro(String nombre, String autor, String isbn, Date fechaPublicacion,List<Imagen>imagenes) {
        this.nombre = nombre;
        this.autor = autor;
        this.isbn = isbn;
        this.fechaPublicacion = fechaPublicacion;
        this.imagenes= imagenes;
    }

    public String getImagenPrincipal(){

        if(imagenes!=null && !imagenes.isEmpty()){

            return imagenes.get(0).getUrl();
        }

        return "default.png";
    }
}
