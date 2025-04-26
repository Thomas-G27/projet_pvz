package com.coursEpfBack.services;

import java.util.List;

import com.coursEpfBack.dao.interfaces.Map_DAO_interface;
import com.coursEpfBack.model.Map;
import com.coursEpfBack.services.interfaces.Map_Service_interface;

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
