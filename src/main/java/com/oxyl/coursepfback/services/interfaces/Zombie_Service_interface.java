package com.oxyl.coursepfback.services.interfaces;

import java.util.List;

import com.oxyl.coursepfback.dto.Zombie_DTO;

public interface Zombie_Service_interface {
    
    List<Zombie_DTO> listerZombies();                           // Read
    Zombie_DTO trouverZombieParId(int id);                      // Read
    Zombie_DTO ajouterZombie(Zombie_DTO zombie_dto);            // Create
    Zombie_DTO modifierZombie(int id, Zombie_DTO zombie_dto);   // Update
    void supprimerZombie(int id);                               // Delete
    void supprimerZombieParMap(int id_map);                     // Delete
    
}
