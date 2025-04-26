package com.coursEpfBack.services;

import java.util.List;

import com.coursEpfBack.dao.PlanteDAO;
import com.coursEpfBack.model.Plante;

public class Plante_Service implements Plante_Service_interface {

    private final PlanteDAO planteDAO;

    public Plante_Service(PlanteDAO planteDAO) {
        this.planteDAO = planteDAO;
    }

    @Override
    public void ajouterPlante(Plante plante) {
        planteDAO.ajouterPlante(plante);
    }

    @Override
    public void supprimerPlante(Plante plante) {
        int id = plante.getId_plante();
        planteDAO.deletePlante(id);
    }

    @Override
    public Plante trouverPlante(Plante plante) {
        int id = plante.getId_plante();
        return planteDAO.getPlanteById(id);
    }

    @Override
    public List<Plante> listerPlantes() {
        return planteDAO.getAllPlantes();
    }

    @Override
    public void updatePlante(Plante plante) {
        planteDAO.updatePlante(plante);
    }
}
