package com.epf.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.epf.model.Zombie;
import com.epf.services.Zombie_Service;

// Les DTO sont juste les objets renvoyés par les fonctions des controller, ce n'est pas une classe a part entière (je crois)
public class Zombie_controller {
    private final Zombie_Service zombieService;
    
    public Zombie_controller (Zombie_Service zombieServ){
        this.zombieService = zombieServ;
    }
    
    @PostMapping
    public void ajouterZombie (Zombie zombie){
        this.zombieService.ajouterZombie(zombie);
    }
    
    @DeleteMapping("/{id}")
    public void suprimerZombie (Zombie zombie){
        this.zombieService.supprimerZombie(zombie);
    }
}
