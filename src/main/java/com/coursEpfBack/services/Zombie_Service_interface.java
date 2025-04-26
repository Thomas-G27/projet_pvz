package com.coursEpfBack.services;

import java.util.List;

import com.coursEpfBack.model.Zombie;

public interface Zombie_Service_interface {
    
    public void ajouterZombie(Zombie zombie);
    public void supprimerZombie(Zombie zombie);
    public Zombie trouverParId(Zombie zombie);
    public List<Zombie> listerTous();
    
    
}
