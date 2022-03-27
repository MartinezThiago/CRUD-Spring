package com.example.democrud.controller;

import com.example.democrud.interfaceService.IpersonaService;
import com.example.democrud.model.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping
public class Controlador {

    @Autowired
    private IpersonaService service;

    @GetMapping("/")
    public String listar(Model model){
        List<Persona> personas= service.listar();
        model.addAttribute("personas", personas);
        return "index";
    }
    @GetMapping("/new")
    public String agregar(Model model){
        model.addAttribute("persona", new Persona());
        return "form";
    }
    @PostMapping("/save")
    public String save(@Validated Persona p, Model model){
        service.save(p);
    return "redirect:/";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable int id, Model model){
        Optional<Persona> persona=service.listarId(id);
        model.addAttribute("persona",persona);
        return "form";
    }
    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable int id, Model model){
        service.delete(id);
        return "redirect:/";
    }
}
