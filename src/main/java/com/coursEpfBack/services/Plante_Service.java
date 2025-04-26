package com.coursEpfBack.services;

import java.util.List;

import com.coursEpfBack.dao.interfaces.Plante_DAO_interface;
import com.coursEpfBack.model.Plante;
import com.coursEpfBack.services.interfaces.Plante_Service_interface;

public class Plante_Service implements Plante_Service_interface {

    private final Plante_DAO_interface planteDAO;

    public Plante_Service(Plante_DAO_interface planteDAO) {
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
