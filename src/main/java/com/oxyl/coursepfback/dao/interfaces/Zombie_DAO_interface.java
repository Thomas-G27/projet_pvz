package com.oxyl.coursepfback.dao.interfaces;

import java.util.List;

import com.oxyl.coursepfback.model.Zombie;

public interface Zombie_DAO_interface {
    List<Zombie> getAllZombies();
    int ajouterZombie(Zombie zombie);
    int modifierZombie(int id, Zombie zombie);
    int supprimerZombie(int id);
    int supprimerZombieParIdMap(int id_map);
    
    Zombie getZombieById(int id);
    //List<Zombie> getZombiesByMapId(int id_map); // Récupérer les zombies par ID de map
}
