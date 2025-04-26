package com.coursEpfBack.services;

import java.util.List;

import com.coursEpfBack.model.Map;

public interface Map_Service_interface {
    
    public List<Map> listerMaps();
    public void ajouterMap(Map map);
    public void supprimerMap(int id);
    public Map trouverMap(int id);
    public void updateMap(int id, Map map);
}
