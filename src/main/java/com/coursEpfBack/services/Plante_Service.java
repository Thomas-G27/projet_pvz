package com.coursEpfBack.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coursEpfBack.dao.interfaces.Plante_DAO_interface;
import com.coursEpfBack.dto.Plante_DTO;
import com.coursEpfBack.dto.mapper.Plante_Mapper;
import com.coursEpfBack.services.interfaces.Plante_Service_interface;

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
}
