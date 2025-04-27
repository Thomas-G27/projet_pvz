package com.oxyl.coursepfback.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oxyl.coursepfback.model.Map;
import com.oxyl.coursepfback.services.Map_Service;

import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;

@RequestMapping("/maps")
@RestController
public class MapController {

    private final Map_Service mapService;

    public MapController(Map_Service mapServ) {
        this.mapService = mapServ;
    }

    @PostMapping("")
    public List<Map> getallMap() {
        return this.mapService.listerMaps();
    }

    // @PostMapping("")
    // public void ajouterMap(Map map) {
    //     this.mapService.ajouterMap(map);
    // }

    // @DeleteMapping("/{id}")
    // public void supprimerMap(int id) {
    //     this.mapService.supprimerMap(id);
    // }
    // @PutMapping("/{id}")
    // public void updateMap(int id, Map map) {
    //     this.mapService.updateMap(id, map);
    // }
}
