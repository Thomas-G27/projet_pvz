package com.oxyl.coursepfback.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

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
                || map.getChemin_image() == null || map.getChemin_image().isEmpty()) {
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
    @GetMapping("/{id}")
    public ResponseEntity<Map_DTO> getMapById(@PathVariable("id") int id) {
        Map_DTO map_dto = this.mapService.trouverMapParId(id);
        if (map_dto == null) {
            return ResponseEntity.notFound().build(); // HTTP 404
        }
        return ResponseEntity.ok(map_dto); // HTTP 200
    }

    @PostMapping("")
    public ResponseEntity<Map_DTO> ajouterMap(Map_DTO map_dto) {
        Map_DTO New_Map = this.mapService.ajouterMap(map_dto);
        return ResponseEntity.ok(New_Map); // HTTP 200
    }

    @PutMapping("/{id}")
    public ResponseEntity<Map_DTO> modifierMap(@PathVariable("id") int id, @RequestBody Map_DTO map_dto) {
        Map_DTO modif = this.mapService.modifierMap(id, map_dto);
        return ResponseEntity.ok(modif); // HTTP 200
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> supprimerMap(@PathVariable("id") int id) {
        this.mapService.supprimerMap(id);
        return ResponseEntity.noContent().build(); // HTTP 204
    }
}
