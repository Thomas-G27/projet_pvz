package com.oxyl.coursepfback.services.interfaces;

import java.util.List;

import com.oxyl.coursepfback.dto.Map_DTO;

public interface Map_Service_interface {
    
    List<Map_DTO> listerMaps();                     // Read
    Map_DTO trouverMapParId(int id);                // Read
    Map_DTO ajouterMap(Map_DTO map_dto);            // Create
    Map_DTO modifierMap(int id, Map_DTO map_dto);   // Update
    void supprimerMap(int id);                      // Delete


    // Map_DTO trouverMap(int id);
}
