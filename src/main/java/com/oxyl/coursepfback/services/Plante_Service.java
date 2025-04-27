package com.oxyl.coursepfback.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oxyl.coursepfback.dao.interfaces.Plante_DAO_interface;
import com.oxyl.coursepfback.dto.Plante_DTO;
import com.oxyl.coursepfback.dto.mapper.Plante_Mapper;
import com.oxyl.coursepfback.services.interfaces.Plante_Service_interface;

@Service
public class Plante_Service implements Plante_Service_interface {

    private final Plante_DAO_interface planteDAO;

    @Autowired
    public Plante_Service(Plante_DAO_interface planteDAO) {
        this.planteDAO = planteDAO;
    }

    @Override
    public List<Plante_DTO> listerPlantes() {
        return planteDAO.getAllPlantes()
                        .stream()
                        .map(Plante_Mapper::toDTO)
                        .collect(Collectors.toList());
    }

    @Override
    public Plante_DTO ajouterPlante(Plante_DTO plante_dto) {
        int id = planteDAO.ajouterPlante(Plante_Mapper.toEntity(plante_dto));
        plante_dto.setId(id);
        return plante_dto;
    }

    @Override
    public Plante_DTO modifierPlante(int id, Plante_DTO plante_dto) {
        int modif = planteDAO.modifierPlante(id, Plante_Mapper.toEntity(plante_dto));
        if (modif == 0) {
            return null; 
        }
        return plante_dto;
    }

    @Override
    public void supprimerPlante(int id) {
        planteDAO.supprimerPlante(id);
    }
}
