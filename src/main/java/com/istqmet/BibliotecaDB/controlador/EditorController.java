package com.istqmet.BibliotecaDB.controlador;

import com.istqmet.BibliotecaDB.entidad.Autor;
import com.istqmet.BibliotecaDB.entidad.Editor;
import com.istqmet.BibliotecaDB.repositorio.EditorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Controller
public class EditorController {
    @Autowired
    EditorRepository editorRepository;
    @GetMapping("/editores")
    public String editor(Model model){
        List<Editor> editores = editorRepository.findAll();
        model.addAttribute("editores", editores);
        return "editor/editor";
    }
    @GetMapping("/editor/form")
    public String form(Model model){
        model.addAttribute("editores", new Editor());
        return "editor/formulario";
    }

    @GetMapping("/editor/form")
    public String crear(Editor editor){
        editorRepository.save(editor);
        return "redirect:/editores";
    }
    //EDITAR
    @GetMapping("editor/editar/{id}")
    public String editar(@PathVariable int id, Model model){
        Optional<Editor> editores = editorRepository.findById(id);
        model.addAttribute("editores", editores);
        return "/editor/formulario";
    }

    //ELIMINAR
    @GetMapping("/editor/eliminar/{id}")
    public  String eliminar(@PathVariable int id){
        editorRepository.deleteById(id);
        return "redirect:/editores";
    }
}
