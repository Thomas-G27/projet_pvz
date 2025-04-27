package com.oxyl.coursepfback.dto.mapper;

import com.oxyl.coursepfback.dto.Map_DTO;
import com.oxyl.coursepfback.model.Map;

public class Map_Mapper {
    
    // Conversion Map -> Map_DTO
    public static Map_DTO toDTO(Map map) {
        Map_DTO map_dto = new Map_DTO(
                map.getId_map(),
                map.getLigne(),
                map.getColonne(),
                map.getChemin_image()
        );
        return map_dto;
    }

    // Conversion Map_DTO -> Map
    public static Map toEntity(Map_DTO map_dto) {
        Map map = new Map(
                map_dto.getId_map(),
                map_dto.getLigne(),
                map_dto.getColonne(),
                map_dto.getChemin_image()
        );
        return map;
    }
}
