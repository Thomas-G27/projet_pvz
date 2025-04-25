package com.epf.services;

import java.util.List;

import com.epf.model.Map;

public interface Map_Service_interface {
    
    public void ajouterMap(Map map);
    public void supprimerMap(Map map);
    public Map trouverMap(Map map);
    public List<Map> listerMaps();
}
