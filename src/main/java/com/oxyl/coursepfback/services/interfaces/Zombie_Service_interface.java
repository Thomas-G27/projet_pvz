package com.oxyl.coursepfback.services.interfaces;

import java.util.List;

import com.oxyl.coursepfback.dto.Zombie_DTO;
import com.oxyl.coursepfback.model.Zombie;

public interface Zombie_Service_interface {
    
    List<Zombie_DTO> listerZombies();
    Zombie_DTO ajouterZombie(Zombie_DTO zombie_dto);
    Zombie_DTO modifierZombie(int id, Zombie_DTO zombie_dto);
    // public void supprimerZombie(Zombie zombie);
    // public Zombie trouverParId(Zombie zombie);
    
}
