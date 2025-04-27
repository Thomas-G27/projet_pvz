package com.oxyl.coursepfback.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oxyl.coursepfback.dao.interfaces.Map_DAO_interface;
import com.oxyl.coursepfback.dao.interfaces.Zombie_DAO_interface;
import com.oxyl.coursepfback.services.interfaces.Map_Service_interface;
import com.oxyl.coursepfback.dto.Map_DTO;
import com.oxyl.coursepfback.dto.mapper.Map_Mapper;

@Service
public class Map_Service implements Map_Service_interface {

    private final Map_DAO_interface mapDAO;
    private final Zombie_DAO_interface zombieDAO;

    @Autowired
    public Map_Service(Map_DAO_interface mapDAO, Zombie_DAO_interface zombieDAO) {
        this.mapDAO = mapDAO;
        this.zombieDAO = zombieDAO;
    }

    @Override
    public List<Map_DTO> listerMaps() {
        return mapDAO.getAllMaps()
                .stream()
                .map(Map_Mapper::toDTO)
                .toList();
    }

    @Override
    public Map_DTO trouverMapParId(int id) {
        return Map_Mapper.toDTO(mapDAO.getMapById(id));
    }
    
    @Override
    public Map_DTO ajouterMap(Map_DTO map_dto) {
        int id = mapDAO.ajouterMap(Map_Mapper.toEntity(map_dto));
        map_dto.setId_map(id);
        return map_dto; 
    }

    @Override
    public Map_DTO modifierMap(int id, Map_DTO map_dto) {
        int modif = mapDAO.modifierMap(id, Map_Mapper.toEntity(map_dto));
        if (modif == 0) {
            return null; 
        }
        return map_dto;
    }
    
    @Override
    public void supprimerMap(int id) {
        // Supprimer les zombies associés à la map avant de supprimer la map elle-même
        zombieDAO.supprimerZombieParIdMap(id);
        // Supprimer la map ensuite
        mapDAO.supprimerMap(id);
    }
}
