package com.coursEpfBack.services;

import java.util.List;

import com.coursEpfBack.dao.MapDAO;
import com.coursEpfBack.model.Map;

public class Map_Service implements Map_Service_interface {

    private final MapDAO mapDAO;

    public Map_Service(MapDAO mapDAO) {
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
