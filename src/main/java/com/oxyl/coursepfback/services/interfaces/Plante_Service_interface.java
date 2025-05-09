package com.oxyl.coursepfback.services.interfaces;

import java.util.List;

import com.oxyl.coursepfback.dto.Plante_DTO;

public interface Plante_Service_interface {

    List<Plante_DTO> listerPlantes();                           // Read
    Plante_DTO trouverPlanteParId(int id);                      // Read
    Plante_DTO ajouterPlante(Plante_DTO plante_dto);            // Create
    Plante_DTO modifierPlante(int id, Plante_DTO plante_dto);   // Update
    void supprimerPlante(int id);                               // Delete
}
