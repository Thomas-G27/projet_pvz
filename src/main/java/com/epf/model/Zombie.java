package com.epf.model;

public class Zombie {
    //attributs
    private int id_zombie;
    private String nom;
    private int point_de_vie;
    private double attaque_par_seconde;
    private int degat_attaque;
    private double vitesse_de_deplacement;
    private Effet effet;
    private String chemin_image;

    public Zombie (){
        this.nom = "casual" ;
        this.point_de_vie = 70 ;
        this.attaque_par_seconde = 0.8 ;
        this.degat_attaque = 5 ;
        this.vitesse_de_deplacement = 1.0 ;
        this.effet = Effet.NORMAL ;
        this.chemin_image = "chemin/vers/image";
    }


    
    public int getIdZombie() {
        return this.id_zombie;
    }
    
    public String getNom() {
        return this.nom;
    }
    
    public int getPointDeVie() {
        return this.point_de_vie;
    }
    
    public double getAttaqueParSeconde() {
        return this.attaque_par_seconde;
    }
    
    public int getDegatAttaque() {
        return this.degat_attaque;
    }
    
    public double getVitesseDeDeplacement() {
        return this.vitesse_de_deplacement;
    }
    
    public Effet getEffet() {
        return this.effet;
    }
    
    public String getCheminImage() {
        return this.chemin_image;
    }
    
}
