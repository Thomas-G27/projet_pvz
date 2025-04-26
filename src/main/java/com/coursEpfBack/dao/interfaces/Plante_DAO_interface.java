package com.coursEpfBack.dao.interfaces;

import java.util.List;

import com.coursEpfBack.model.Plante;

public interface Plante_DAO_interface {
    int ajouterPlante(Plante plante);
    Plante getPlanteById(int id);
    List<Plante> getAllPlantes();
    int updatePlante(Plante plante);
    int deletePlante(int id);
}
