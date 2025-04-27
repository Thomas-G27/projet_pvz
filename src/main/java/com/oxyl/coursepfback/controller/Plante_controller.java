package com.oxyl.coursepfback.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;

import com.oxyl.coursepfback.dto.Plante_DTO;
import com.oxyl.coursepfback.services.Plante_Service;
import com.oxyl.coursepfback.services.interfaces.Plante_Service_interface;


@RequestMapping("/plantes")
@RestController
public class Plante_controller {

    private final Plante_Service_interface planteService;

    @Autowired
    public Plante_controller (Plante_Service planteServ){
        this.planteService = planteServ;
    }

    // validation du format des plantes
    @GetMapping("/validation")
    public ResponseEntity<List<Plante_DTO>> validatePlantesFormat() {
        List<Plante_DTO> plantes = getallPlante();
        if (plantes != null && !plantes.isEmpty()) {
            for (Plante_DTO plante : plantes) {
                if (plante.getId() <= 0
                || plante.getNom() == null || plante.getNom().isEmpty() 
                || plante.getPoint_de_vie() <= 0 
                || plante.getAttaque_par_seconde() <= 0 
                || plante.getDegat_attaque() <= 0 
                || plante.getCout() <= 0 
                || plante.getSoleil_par_seconde() <= 0 
                || plante.getEffet() == null 
                || plante.getChemin_vers_image() == null) {
                    return ResponseEntity.badRequest().build(); // HTTP 400
                }
            }
            return ResponseEntity.ok(plantes); // HTTP 200
        }
        return ResponseEntity.badRequest().build(); // HTTP 400
    }

    @GetMapping("")
    public List<Plante_DTO> getallPlante (){
        return this.planteService.listerPlantes();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Plante_DTO> getPlanteById(@PathVariable("id") int id) {
        Plante_DTO plante_dto = this.planteService.trouverPlanteParId(id);
        if (plante_dto == null) {
            return ResponseEntity.notFound().build(); // HTTP 404
        }
        return ResponseEntity.ok(plante_dto); // HTTP 200
    }

    @PostMapping("")
    public ResponseEntity<Plante_DTO> ajouterPlante (@RequestBody Plante_DTO plante_dto){
        Plante_DTO New_Plante = this.planteService.ajouterPlante(plante_dto);
        return ResponseEntity.ok(New_Plante); // HTTP 200
    }

    @PutMapping("/{id}")
    public ResponseEntity<Plante_DTO> modifierPlante (@PathVariable("id") int id, @RequestBody Plante_DTO plante_dto){
        Plante_DTO updatedPlante = this.planteService.modifierPlante(id, plante_dto);
        return ResponseEntity.ok(updatedPlante); // HTTP 200
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> supprimerPlante(@PathVariable("id") int id) {
        this.planteService.supprimerPlante(id);
        return ResponseEntity.noContent().build(); // HTTP 204
    }

}
