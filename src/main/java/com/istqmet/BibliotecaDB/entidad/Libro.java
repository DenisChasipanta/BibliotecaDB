package com.istqmet.BibliotecaDB.entidad;

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
    @JoinColumn(name = "autor_id")
    private Autor autor;

    @OneToOne
    @JoinColumn(name = "editor_id")
    private Editor editor;

}
