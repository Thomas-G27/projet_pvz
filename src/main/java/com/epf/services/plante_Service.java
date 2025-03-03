package com.epf.services;

import java.util.List;

import com.epf.dao.PlanteDAO;
import com.epf.model.Plante;

public class plante_Service {

    private final PlanteDAO planteDAO;

    public plante_Service(PlanteDAO planteDAO) {
        this.planteDAO = planteDAO;
    }

    public void ajouterPlante(Plante plante) {
        planteDAO.ajouterPlante(plante);
    }

    public void suprimerPlante(int id) {
        planteDAO.deletePlante(id);
    }

    public Plante trouverPlante(int id) {
        return planteDAO.getPlanteById(id);
    }

    public List<Plante> listerPlantes() {
        return planteDAO.getAllPlantes();
    }
}
