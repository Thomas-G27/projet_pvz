package com.epf.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.epf.dao.ZombieDAO;
import com.epf.model.Zombie;

@Service
public class ZombieService {

    private final ZombieDAO zombieDAO;

    public ZombieService(ZombieDAO zombieDAO) {
        this.zombieDAO = zombieDAO;
    }

    public void ajouterZombie(Zombie zombie) {
        // potentiellement ajouter des vérifications avant d'appeler le DAO
        zombieDAO.ajouterZombie(zombie);
    }

    public void supprimerZombie(int id) {
        zombieDAO.deleteZombie(id);
    }

    public Zombie trouverParId(int id) {
        return zombieDAO.getZombieById(id);
    }

    public List<Zombie> listerTous() {
        return zombieDAO.getAllZombies();
    }
}
