package com.oxyl.coursepfback.dao.interfaces;

import java.util.List;

import com.oxyl.coursepfback.model.Plante;

public interface Plante_DAO_interface {
    // CRUD operations for Plante
    List<Plante> getAllPlantes();               //Read
    Plante getPlanteById(int id);               //Read
    int ajouterPlante(Plante plante);           //Create
    int modifierPlante(int id, Plante plante);  //Update
    int supprimerPlante(int id);                //Delete
}
