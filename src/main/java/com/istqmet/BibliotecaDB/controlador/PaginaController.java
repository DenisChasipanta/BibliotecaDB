package com.istqmet.BibliotecaDB.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PaginaController {
    @GetMapping("/")
    public String home(){
        return "home";
    }

}
