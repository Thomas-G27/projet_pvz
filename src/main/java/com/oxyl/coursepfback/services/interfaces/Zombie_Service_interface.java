package com.oxyl.coursepfback.services.interfaces;

import java.util.List;

import com.oxyl.coursepfback.dto.Zombie_DTO;
import com.oxyl.coursepfback.model.Zombie;

public interface Zombie_Service_interface {
    
    public List<Zombie_DTO> listerZombies();
    // public void ajouterZombie(Zombie zombie);
    // public void supprimerZombie(Zombie zombie);
    // public Zombie trouverParId(Zombie zombie);
    
}
