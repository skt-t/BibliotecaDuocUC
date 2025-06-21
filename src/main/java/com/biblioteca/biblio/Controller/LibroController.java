package com.biblioteca.biblio.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.biblioteca.biblio.Service.LibroService;
import org.springframework.http.ResponseEntity;
import java.util.List;
import com.biblioteca.biblio.Model.Libro;
import org.springframework.http.HttpStatus;


@RestController
@RequestMapping("/api/v1/Libros")
public class LibroController {
    @Autowired
    private LibroService libroService;

    @GetMapping
    public ResponseEntity<List<Libro>> findAllLibros() {
        List<Libro> libros = libroService.findAllLibros();
        if (libros.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(libros);
    }

    @PostMapping
    public ResponseEntity<Libro> saveLibro(@RequestBody Libro libro) {
        Libro savedLibro = libroService.saveLibro(libro);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedLibro);
    }

    @GetMapping("/{nombre}")
    public ResponseEntity<List<Libro>> findByNombreContaining(@PathVariable String nombre) {
        try {
            List<Libro> libros = libroService.findByNombreContaining(nombre);
            return ResponseEntity.ok(libros);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLibro(@PathVariable Integer id) {
        try {
            libroService.deleteLibro(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    


}