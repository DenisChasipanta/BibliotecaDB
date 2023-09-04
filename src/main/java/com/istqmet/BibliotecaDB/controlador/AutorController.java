package com.istqmet.BibliotecaDB.controlador;

import com.istqmet.BibliotecaDB.entidad.Autor;
import com.istqmet.BibliotecaDB.repositorio.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Controller
public class AutorController {
    @Autowired
    AutorRepository autorRepository;

    @GetMapping("/autores")
    public String autor(Model model){
        List<Autor> autores = autorRepository.findAll();
        model.addAttribute("autores",autores);
        return "autor/autor";
    }
    @GetMapping("/autor/form")
    public String form(Model model){
        model.addAttribute("autores", new Autor());
        return "autor/formulario";
    }

    @GetMapping("/autor/form")
    public String crear(Autor autor){
        autorRepository.save(autor);
        return "redirect:/autores";
    }
    //EDITAR
    @GetMapping("autor/editar/{id}")
    public String editar(@PathVariable int id,Model model){
        Optional<Autor> autores = autorRepository.findById(id);
        model.addAttribute("autores", autores);
        return "/autor/formulario";
    }

    //ELIMINAR
    @GetMapping("/autor/eliminar/{id}")
    public  String eliminar(@PathVariable int id){
        autorRepository.deleteById(id);
        return "redirect:/autores";
    }

}
