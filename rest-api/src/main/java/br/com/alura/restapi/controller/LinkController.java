package br.com.alura.restapi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LinkController {
    
    @GetMapping("links-api")
    public String getLinks(Model model) {
        model.addAttribute("titulo", "API Links");
        return "form";
    }
    
}
