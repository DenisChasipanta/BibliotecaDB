package com.istqmet.BibliotecaDB.repositorio;

import com.istqmet.BibliotecaDB.entidad.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutorRepository extends JpaRepository<Autor,Integer> {
}
