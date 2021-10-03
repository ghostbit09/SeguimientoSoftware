package co.edu.uniquindio.proyecto.entidades;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Size;

@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Resenia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column(name = "calificacion")
    private int calificacion;

    @Column(name = "reseña")
    @Size(max = 200, message = "El comentario no puede superar los 200 caracteres")
    private String reseña;

    @ManyToOne
    private Libro libro;
}
