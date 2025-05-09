package com.oxyl.coursepfback.dto.mapper;

import com.oxyl.coursepfback.dto.Plante_DTO;
import com.oxyl.coursepfback.model.Plante;


public class Plante_Mapper {

    // conversion Plante -> Plante_DTO
    public static Plante_DTO toDTO(Plante plante) {
        Plante_DTO plante_dto = new Plante_DTO(
                plante.getId(),
                plante.getNom(),
                plante.getPoint_de_vie(),
                plante.getAttaque_par_seconde(),
                plante.getDegat_attaque(),
                plante.getCout(),
                plante.getSoleil_par_seconde(),
                plante.getEffet(),
                plante.getChemin_image()
        );
        return plante_dto;
    }

    // conversion Plante_DTO -> Plante
    public static Plante toEntity(Plante_DTO plante_dto) {
        Plante plante = new Plante(
                plante_dto.getId(),
                plante_dto.getNom(),
                plante_dto.getPoint_de_vie(),
                plante_dto.getAttaque_par_seconde(),
                plante_dto.getDegat_attaque(),
                plante_dto.getCout(),
                plante_dto.getSoleil_par_seconde(),
                plante_dto.getEffet(),
                plante_dto.getChemin_image()
        );
        return plante;
    }
}
