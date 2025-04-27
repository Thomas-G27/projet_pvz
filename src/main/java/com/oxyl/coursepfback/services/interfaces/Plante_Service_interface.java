package com.oxyl.coursepfback.services.interfaces;

import java.util.List;

import com.oxyl.coursepfback.dto.Plante_DTO;

public interface Plante_Service_interface {

    List<Plante_DTO> listerPlantes();
    Plante_DTO trouverPlanteParId(int id);
    Plante_DTO ajouterPlante(Plante_DTO plante_dto);
    Plante_DTO modifierPlante(int id, Plante_DTO plante_dto);
    void supprimerPlante(int id);
}
