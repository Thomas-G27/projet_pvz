package com.oxyl.coursepfback.services.interfaces;

import java.util.List;

import com.oxyl.coursepfback.dto.Map_DTO;

public interface Map_Service_interface {
    
    List<Map_DTO> listerMaps();
    Map_DTO ajouterMap(Map_DTO map_dto);
    Map_DTO modifierMap(int id, Map_DTO map_dto);
    void supprimerMap(int id);


    // Map_DTO trouverMap(int id);
}
