package com.epf.dao;

import java.util.List;

import com.epf.model.Plante;

public interface PlanteDAO {
    int ajouterPlante(Plante plante);
    Plante getPlanteById(int id);
    List<Plante> getAllPlantes();
    int updatePlante(Plante plante);
    int deletePlante(int id);
}
