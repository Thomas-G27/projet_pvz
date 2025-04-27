package com.oxyl.coursepfback.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.oxyl.coursepfback.dao.interfaces.Map_DAO_interface;
import com.oxyl.coursepfback.model.Map;
import com.oxyl.coursepfback.services.interfaces.Map_Service_interface;

@Service
public class Map_Service implements Map_Service_interface {

    private final Map_DAO_interface mapDAO;

    public Map_Service(Map_DAO_interface mapDAO) {
        this.mapDAO = mapDAO;
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
    public List<Map> listerMaps() {
        return mapDAO.getAllMaps();
    }

    @Override
    public void updateMap(int id, Map map) {
        mapDAO.updateMap(id, map);
    }
}
