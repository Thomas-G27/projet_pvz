package com.oxyl.coursepfback.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;

import com.oxyl.coursepfback.model.Map;
import com.oxyl.coursepfback.dto.Map_DTO;
import com.oxyl.coursepfback.services.Map_Service;

import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;

@RequestMapping("/maps")
@RestController
public class Map_controller {

    private final Map_Service mapService;

    public Map_controller(Map_Service mapServ) {
        this.mapService = mapServ;
    }

    // validation du format des maps
    @GetMapping("/validation")
    public ResponseEntity<List<Map_DTO>> validateMapsFormat() {
        List<Map_DTO> maps = getallMap();
        if (maps != null && !maps.isEmpty()) {
            for (Map_DTO map : maps) {
                if (map.getId_map() <= 0
                || map.getLigne() <= 0
                || map.getColonne() <= 0
                || map.getChemin_image() == null) {
                    return ResponseEntity.badRequest().build(); // HTTP 400
                }
            }
            return ResponseEntity.ok(maps); // HTTP 200
        }
        return ResponseEntity.badRequest().build(); // HTTP 400
    }

    @GetMapping("")
    public List<Map_DTO> getallMap() {
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
