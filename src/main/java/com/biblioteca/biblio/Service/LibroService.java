package com.biblioteca.biblio.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;
import com.biblioteca.biblio.Model.Libro;
import com.biblioteca.biblio.Repository.LibroRepository;
import java.util.List;

@Service
@Transactional
public class LibroService {

    @Autowired
    private LibroRepository libroRepository;
    
    public List<Libro> findByNombreContaining(String nombre) {
        return libroRepository.findByNombreContaining(nombre);
    }

    public List<Libro> findAllLibros() {
        return libroRepository.findAll();
    }

    public Libro saveLibro(Libro libro) {
        return libroRepository.save(libro);
    }

    public void deleteLibro(Integer id) {
        libroRepository.deleteById(id);
    }
}
