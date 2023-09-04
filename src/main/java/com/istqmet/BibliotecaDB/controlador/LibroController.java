package com.istqmet.BibliotecaDB.controlador;

import com.istqmet.BibliotecaDB.entidad.Libro;
import com.istqmet.BibliotecaDB.repositorio.AutorRepository;
import com.istqmet.BibliotecaDB.repositorio.EditorRepository;
import com.istqmet.BibliotecaDB.repositorio.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

@Controller
public class LibroController {
    @Autowired
    LibroRepository libroRepository;
    @Autowired
    AutorRepository autorRepository;
    @Autowired
    EditorRepository editorRepository;

    @GetMapping("/libros")
    public String libro(Model model){
        List<Libro> libros = libroRepository.findAll();
        model.addAttribute("libros", libros);
        return "libro/libro";
    }
    @GetMapping("/libro/form")
    public String formulario(Model model){
        model.addAttribute("libro", new Libro());
        //List<Autor> autores = autorRepository.findAll();
        //model.addAttribute("autores",autores);
        return "libro/formulario";
    }

    @PostMapping("/libro/form")
    public String crear(Libro libro){
        libroRepository.save(libro);
        return "redirect:/libros";
    }

    //EDITAR
    @GetMapping("libro/editar/{id}")
    public String editar(@PathVariable int id,Model model){
        Optional<Libro> libros = libroRepository.findById(id);
        model.addAttribute("libros", libros);
        return "/libro/formulario";
    }

    //ELIMINAR
    @GetMapping("/libro/eliminar/{id}")
    public String eliminar(@PathVariable int id){
        libroRepository.deleteById(id);
        return "redirect:/libros";
    }

}
