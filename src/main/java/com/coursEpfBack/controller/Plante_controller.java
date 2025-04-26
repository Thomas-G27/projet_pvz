package com.coursEpfBack.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coursEpfBack.model.Plante;
import com.coursEpfBack.services.Plante_Service;

// Les DTO sont juste les objets renvoyés par les fonctions des controller, ce n'est pas une classe a part entière (je crois)
@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/plantes")
public class Plante_controller {

    private final Plante_Service planteService;

    @Autowired
    public Plante_controller (Plante_Service planteServ){
        this.planteService = planteServ;
    }

    @GetMapping("")
    public List<Plante> getallPlante (){
        return this.planteService.listerPlantes();
    }

    @PostMapping("")
    public void ajouterPlante (Plante plante){
        this.planteService.ajouterPlante(plante);
    }

    @PutMapping("/{id}")
    public void updatePlante (Plante plante){
        this.planteService.updatePlante(plante);
    }

    @DeleteMapping("/{id}")
    public void suprimerPlante (Plante plante){
        this.planteService.supprimerPlante(plante);
    }

}
