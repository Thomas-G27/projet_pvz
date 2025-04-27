package com.oxyl.coursepfback.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oxyl.coursepfback.dao.interfaces.Map_DAO_interface;
import com.oxyl.coursepfback.model.Map;
import com.oxyl.coursepfback.services.interfaces.Map_Service_interface;
import com.oxyl.coursepfback.dto.Map_DTO;
import com.oxyl.coursepfback.dto.mapper.Map_Mapper;

@Service
public class Map_Service implements Map_Service_interface {

    private final Map_DAO_interface mapDAO;

    @Autowired
    public Map_Service(Map_DAO_interface mapDAO) {
        this.mapDAO = mapDAO;
    }

    @Override
    public List<Map_DTO> listerMaps() {
        return mapDAO.getAllMaps()
                .stream()
                .map(Map_Mapper::toDTO)
                .toList();
    }

    @Override
    public void ajouterMap(Map map) {
        mapDAO.ajouterMap(map);
        
    }

    @Override
    public void supprimerMap(int id) {
        mapDAO.deleteMap(id);
    }

    @Override
    public Map trouverMap(int id) {
        return mapDAO.getMapById(id);
    }

    @Override
    public void updateMap(int id, Map map) {
        mapDAO.updateMap(id, map);
    }
}
