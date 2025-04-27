package com.oxyl.coursepfback.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oxyl.coursepfback.dto.Zombie_DTO;
import com.oxyl.coursepfback.services.ZombieService;

import java.util.List;

@RestController
@RequestMapping("/zombies")
public class ZombieController {

    private final ZombieService zombieService;
    
    @Autowired
    public ZombieController (ZombieService zombieServ){
        this.zombieService = zombieServ;
    }
    
    @GetMapping("")
    public List<Zombie_DTO> getAllZombies (){
        return this.zombieService.listerZombies();
    }

    // @PostMapping
    // public void ajouterZombie (Zombie zombie){
    //     this.zombieService.ajouterZombie(zombie);
    // }
    
    // @DeleteMapping("/{id}")
    // public void suprimerZombie (Zombie zombie){
    //     this.zombieService.supprimerZombie(zombie);
    // }
}
