package com.oxyl.coursepfback.dao.interfaces;

import java.util.List;

import com.oxyl.coursepfback.model.Zombie;

public interface Zombie_DAO_interface {
    // CRUD operations for Zombie
    List<Zombie> getAllZombies();               //Read
    Zombie getZombieById(int id);               //Read   
    int ajouterZombie(Zombie zombie);           //Create
    int modifierZombie(int id, Zombie zombie);  //Update
    int supprimerZombie(int id);                //Delete
    int supprimerZombieParIdMap(int id_map);    //Delete
}
