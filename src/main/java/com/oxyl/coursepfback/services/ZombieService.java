package com.oxyl.coursepfback.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oxyl.coursepfback.dao.interfaces.Zombie_DAO_interface;
import com.oxyl.coursepfback.dto.Zombie_DTO;
import com.oxyl.coursepfback.dto.mapper.Zombie_Mapper;
import com.oxyl.coursepfback.services.interfaces.Zombie_Service_interface;

@Service
public class ZombieService implements Zombie_Service_interface{

    private final Zombie_DAO_interface zombieDAO;

    @Autowired
    public ZombieService(Zombie_DAO_interface zombieDAO) {
        this.zombieDAO = zombieDAO;
    }

    @Override
    public List<Zombie_DTO> listerZombies() {
        return zombieDAO.getAllZombies()
                        .stream()
                        .map(Zombie_Mapper::toDTO)
                        .toList();
    }

    // @Override
    // public void ajouterZombie(Zombie zombie) {
    //     // potentiellement ajouter des vérifications avant d'appeler le DAO
    //     zombieDAO.ajouterZombie(zombie);
    // }

    // @Override
    // public void supprimerZombie(Zombie zombie) {
    //     int id = zombie.getId_zombie();
    //     zombieDAO.deleteZombie(id);
    // }

    // @Override
    // public Zombie trouverParId(Zombie zombie) {
    //     int id = zombie.getId_zombie();
    //     return zombieDAO.getZombieById(id);
    // }

}
