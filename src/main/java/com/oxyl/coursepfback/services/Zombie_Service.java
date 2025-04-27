package com.oxyl.coursepfback.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.oxyl.coursepfback.dao.interfaces.Zombie_DAO_interface;
import com.oxyl.coursepfback.dto.Zombie_DTO;
import com.oxyl.coursepfback.model.Zombie;
import com.oxyl.coursepfback.dto.mapper.Zombie_Mapper;
import com.oxyl.coursepfback.services.interfaces.Zombie_Service_interface;

@Service
public class Zombie_Service implements Zombie_Service_interface{

    private final Zombie_DAO_interface zombieDAO;

    @Autowired
    public Zombie_Service(Zombie_DAO_interface zombieDAO) {
        this.zombieDAO = zombieDAO;
    }

    @Override
    public List<Zombie_DTO> listerZombies() {
        return zombieDAO.getAllZombies()
                        .stream()
                        .map(Zombie_Mapper::toDTO)
                        .toList();
    }

    @Override
    public Zombie_DTO ajouterZombie(@RequestBody Zombie_DTO zombie_dto) {
        int id = zombieDAO.ajouterZombie(Zombie_Mapper.toEntity(zombie_dto));
        zombie_dto.setId_zombie(id);
        return zombie_dto;
    }

    @Override
    public Zombie_DTO modifierZombie(int id, @RequestBody Zombie_DTO zombie_dto) {
        int modif = zombieDAO.modifierZombie(id, Zombie_Mapper.toEntity(zombie_dto));
        if (modif == 0) {
            return null; 
        }
        return zombie_dto;
    }
    
    @Override
    public void supprimerZombie(int id) {
        zombieDAO.supprimerZombie(id);
    }
    @Override
    public void supprimerZombieParMap(int id_map) {
        zombieDAO.supprimerZombieParIdMap(id_map);
    }

    // @Override
    // public Zombie trouverParId(Zombie zombie) {
    //     int id = zombie.getId_zombie();
    //     return zombieDAO.getZombieById(id);
    // }

}
