package com.coursEpfBack.dao.interfaces;

import java.util.List;

import com.coursEpfBack.model.Zombie;

public interface Zombie_DAO_interface {
    int ajouterZombie(Zombie zombie);
    Zombie getZombieById(int id);
    List<Zombie> getAllZombies();
    int updateZombie(Zombie zombie);
    int deleteZombie(int id);
}
