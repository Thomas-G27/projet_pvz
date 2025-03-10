package com.epf.services;

import java.util.List;

import com.epf.model.Plante;

public interface Plante_Service_interface {

    public void ajouterPlante(Plante plante);
    public void suprimerPlante(Plante plante);
    public Plante trouverPlante(Plante plante);
    public List<Plante> listerPlantes();

}
