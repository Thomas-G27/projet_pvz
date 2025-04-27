package com.oxyl.coursepfback.services.interfaces;

import java.util.List;

import com.oxyl.coursepfback.model.Map;
import com.oxyl.coursepfback.dto.Map_DTO;

public interface Map_Service_interface {
    
    public List<Map_DTO> listerMaps();
    public void ajouterMap(Map map);
    public void supprimerMap(int id);
    public Map trouverMap(int id);
    public void updateMap(int id, Map map);
}
