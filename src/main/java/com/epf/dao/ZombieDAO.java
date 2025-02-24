package com.epf.dao;

import java.util.List;

import com.epf.model.Zombie;

public interface ZombieDAO {
    int ajouterZombie(Zombie zombie);
    Zombie getZombieById(int id);
    List<Zombie> getAllZombies();
    int updateZombie(Zombie zombie);
    int deleteZombie(int id);
}
