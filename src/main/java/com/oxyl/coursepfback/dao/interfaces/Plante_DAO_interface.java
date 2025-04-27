package com.oxyl.coursepfback.dao.interfaces;

import java.util.List;

import com.oxyl.coursepfback.model.Plante;

public interface Plante_DAO_interface {
    List<Plante> getAllPlantes();
    int ajouterPlante(Plante plante);
    int modifierPlante(int id, Plante plante);
    void supprimerPlante(int id);
}
