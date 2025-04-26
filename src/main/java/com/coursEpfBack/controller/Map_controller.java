package com.coursEpfBack.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.coursEpfBack.model.Map;
import com.coursEpfBack.services.Map_Service;

// les DTO sont juste les objets renvoyés par les fonctions des controller, ce n'est pas une classe a part entière (je crois)
public class Map_controller {
    private final Map_Service mapService;

    public Map_controller(Map_Service mapServ) {
        this.mapService = mapServ;
    }

    @PostMapping
    public void ajouterMap(Map map) {
        this.mapService.ajouterMap(map);
    }

    @DeleteMapping("/{id}")
    public void supprimerMap(Map map) {
        this.mapService.supprimerMap(map);
    }
}
