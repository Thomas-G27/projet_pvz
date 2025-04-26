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
    public void supprimerMap(Map map) {
        int id = map.getId_map();
        mapDAO.deleteMap(id);
    }

    @Override
    public Map trouverMap(Map map) {
        int id = map.getId_map();
        return mapDAO.getMapById(id);
    }

    @Override
    public List<Map> listerMaps() {
        return mapDAO.getAllMaps();
    }
    
}
