package com.epf.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.epf.dao.ZombieDAO;
import com.epf.model.Zombie;

@Service
public class Zombie_Service implements Zombie_Service_interface{

    private final ZombieDAO zombieDAO;

    public Zombie_Service(ZombieDAO zombieDAO) {
        this.zombieDAO = zombieDAO;
    }

    @Override
    public void ajouterZombie(Zombie zombie) {
        // potentiellement ajouter des vérifications avant d'appeler le DAO
        zombieDAO.ajouterZombie(zombie);
    }

    @Override
    public void supprimerZombie(Zombie zombie) {
        int id = zombie.getId_zombie();
        zombieDAO.deleteZombie(id);
    }

    @Override
    public Zombie trouverParId(Zombie zombie) {
        int id = zombie.getId_zombie();
        return zombieDAO.getZombieById(id);
    }

    @Override
    public List<Zombie> listerTous() {
        return zombieDAO.getAllZombies();
    }
}
