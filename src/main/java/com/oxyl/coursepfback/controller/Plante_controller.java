package com.oxyl.coursepfback.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
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

    @PostMapping("")
    public ResponseEntity<Plante_DTO> ajouterPlante (@RequestBody Plante_DTO plante_dto){
        Plante_DTO Nouvelle_Plante = this.planteService.ajouterPlante(plante_dto);
        return ResponseEntity.ok(Nouvelle_Plante);  // HTTP 200
    }

}
