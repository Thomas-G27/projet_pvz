package com.oxyl.coursepfback.dao.interfaces;

import java.util.List;

import com.oxyl.coursepfback.model.Zombie;

public interface Zombie_DAO_interface {
    List<Zombie> getAllZombies();
    int ajouterZombie(Zombie zombie);

    
    Zombie getZombieById(int id);
    int updateZombie(Zombie zombie);
    int deleteZombie(int id);
    //List<Zombie> getZombiesByMapId(int id_map); // Récupérer les zombies par ID de map
}
