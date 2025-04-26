package com.coursEpfBack.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.coursEpfBack.dao.interfaces.Zombie_DAO_interface;
import com.coursEpfBack.model.Zombie;
import com.coursEpfBack.services.interfaces.Zombie_Service_interface;

@Service
public class Zombie_Service implements Zombie_Service_interface{

    private final Zombie_DAO_interface zombieDAO;

    public Zombie_Service(Zombie_DAO_interface zombieDAO) {
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
