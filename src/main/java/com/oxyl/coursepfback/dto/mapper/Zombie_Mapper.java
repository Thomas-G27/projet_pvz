package com.oxyl.coursepfback.dto.mapper;

import com.oxyl.coursepfback.dto.Zombie_DTO;
import com.oxyl.coursepfback.model.Zombie;

public class Zombie_Mapper {
    // Conversion Zombie -> Zombie_DTO
    public static Zombie_DTO toDTO(Zombie zombie) {
        return new Zombie_DTO(
            zombie.getId_zombie(),
            zombie.getNom(),
            zombie.getPoint_de_vie(),
            zombie.getAttaque_par_seconde(),
            zombie.getDegat_attaque(),
            zombie.getVitesse_de_deplacement(),
            zombie.getChemin_image(),
            zombie.getId_map()
        );
    }

    // Conversion Zombie_DTO -> Zombie
    public static Zombie toEntity(Zombie_DTO zombie_dto) {
        return new Zombie(
            zombie_dto.getId_zombie(),
            zombie_dto.getNom(),
            zombie_dto.getPoint_de_vie(),
            zombie_dto.getAttaque_par_seconde(),
            zombie_dto.getDegat_attaque(),
            zombie_dto.getVitesse_de_deplacement(),
            zombie_dto.getChemin_image(),
            zombie_dto.getId_map()
        );
    }
}
