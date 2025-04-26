package com.coursEpfBack.services;

import java.util.List;

import com.coursEpfBack.model.Map;

public interface Map_Service_interface {
    
    public void ajouterMap(Map map);
    public void supprimerMap(Map map);
    public Map trouverMap(Map map);
    public List<Map> listerMaps();
}
