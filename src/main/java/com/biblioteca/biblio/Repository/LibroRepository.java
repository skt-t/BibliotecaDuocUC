package com.biblioteca.biblio.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.biblioteca.biblio.Model.Libro;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

@Repository
public interface LibroRepository extends JpaRepository<Libro, Integer> {
    // Encuentra por nombre
    // Devuelve una lista de libros que coinciden con el nombre
    @Query("SELECT l FROM Libro l WHERE l.nombre LIKE %:nombre%")
    List<Libro> findByNombreContaining(@Param("nombre") String nombre);

    // Encuentra a todos los libros
    // Devuelve una lista de todos los libros
    @Query("SELECT l FROM Libro l")
    List<Libro> findAllLibros();



}
