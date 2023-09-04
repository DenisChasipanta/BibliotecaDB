package com.istqmet.BibliotecaDB.repositorio;

import com.istqmet.BibliotecaDB.entidad.Libro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibroRepository extends JpaRepository<Libro,Integer> {
}
