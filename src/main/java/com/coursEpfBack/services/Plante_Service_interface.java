package com.coursEpfBack.services;

import java.util.List;

import com.coursEpfBack.model.Plante;

public interface Plante_Service_interface {

    public void ajouterPlante(Plante plante);
    public void supprimerPlante(Plante plante);
    public Plante trouverPlante(Plante plante);
    public List<Plante> listerPlantes();

}
