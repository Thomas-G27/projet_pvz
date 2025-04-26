package com.coursEpfBack.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;
import com.coursEpfBack.model.Map;
import com.coursEpfBack.services.Map_Service;

// les DTO sont juste les objets renvoyés par les fonctions des controller, ce n'est pas une classe a part entière (je crois)
@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/maps")
public class Map_controller {
    private final Map_Service mapService;

    public Map_controller(Map_Service mapServ) {
        this.mapService = mapServ;
    }

    @PostMapping("")
    public List<Map> getallMap() {
        return this.mapService.listerMaps();
    }

    @PostMapping("")
    public void ajouterMap(Map map) {
        this.mapService.ajouterMap(map);
    }

    @DeleteMapping("/{id}")
    public void supprimerMap(int id) {
        this.mapService.supprimerMap(id);
    }
    @PutMapping("/{id}")
    public void updateMap(int id, Map map) {
        this.mapService.updateMap(id, map);
    }
}
