package com.oxyl.coursepfback.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import com.oxyl.coursepfback.dto.Zombie_DTO;
import com.oxyl.coursepfback.services.ZombieService;

import java.util.List;



@RequestMapping("/zombies")
@RestController
public class Zombie_controller {

    private final ZombieService zombieService;
    
    @Autowired
    public Zombie_controller (ZombieService zombieServ){
        this.zombieService = zombieServ;
    }
    
    // validation du format des zombies
    @GetMapping("/validation")
    public ResponseEntity<List<Zombie_DTO>> validateZombiesFormat() {
        List<Zombie_DTO> zombies = getAllZombies();
        if (zombies != null && !zombies.isEmpty()) {
            for (Zombie_DTO zombie : zombies) {
                if (zombie.getId_zombie() <= 0
                || zombie.getNom() == null || zombie.getNom().isEmpty() 
                || zombie.getPoint_de_vie() <= 0 
                || zombie.getAttaque_par_seconde() <= 0 
                || zombie.getDegat_attaque() <= 0 
                || zombie.getVitesse_de_deplacement() <= 0 
                || zombie.getChemin_image() == null) {
                    return ResponseEntity.badRequest().build(); // HTTP 400
                }
            }
            return ResponseEntity.ok(zombies); // HTTP 200
        }
        return ResponseEntity.badRequest().build(); // HTTP 400
    }

    @GetMapping("")
    public List<Zombie_DTO> getAllZombies (){
        return this.zombieService.listerZombies();
    }

    @PostMapping("")
    public ResponseEntity<Zombie_DTO> ajouterZombie (@RequestBody Zombie_DTO zombie_dto){
        Zombie_DTO New_Zombie = this.zombieService.ajouterZombie(zombie_dto);
        return ResponseEntity.ok(New_Zombie); // HTTP 200
    }
    
    // @DeleteMapping("/{id}")
    // public void suprimerZombie (Zombie zombie){
    //     this.zombieService.supprimerZombie(zombie);
    // }
}
