package com.istqmet.BibliotecaDB.entidad;

import com.istqmet.BibliotecaDB.entidad.Autor1;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
public class Libro {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String titulo;
    private LocalDate publicacion;

    @ManyToOne
    @JoinColumn(name = "autor1_id")
    private Autor1 autor1;

}
