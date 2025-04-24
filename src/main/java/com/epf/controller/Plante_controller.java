package com.epf.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.epf.model.Plante;
import com.epf.services.Plante_Service;

// Les DTO sont juste les objets renvoyés par les fonctions des controller, ce n'est pas une classe a part entière (je crois)
public class Plante_controller {
    private final Plante_Service planteService;

    public Plante_controller (Plante_Service planteServ){
        this.planteService = planteServ;
    }

    @PostMapping
    public void ajouterPlante (Plante plante){
        this.planteService.ajouterPlante(plante);
    }

    @DeleteMapping("/{id}")
    public void suprimerPlante (Plante plante){
        this.planteService.supprimerPlante(plante);
    }

}
