package com.coursEpfBack.model;

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

    public Zombie (String nom, int pdv, double attaque, int degat, double vitesse, Effet effet, String chemin_img){
        this.nom = nom ;
        this.point_de_vie = pdv ;
        this.attaque_par_seconde = attaque ;
        this.degat_attaque = degat ;
        this.vitesse_de_deplacement = vitesse ;
        this.effet = effet ;
        this.chemin_image = chemin_img;
    }

    public int getId_zombie() {
        return id_zombie;
    }

    public String getNom() {
        return nom;
    }

    public int getPoint_de_vie() {
        return point_de_vie;
    }

    public double getAttaque_par_seconde() {
        return attaque_par_seconde;
    }

    public int getDegat_attaque() {
        return degat_attaque;
    }

    public double getVitesse_de_deplacement() {
        return vitesse_de_deplacement;
    }

    public Effet getEffet() {
        return effet;
    }

    public String getChemin_image() {
        return chemin_image;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPoint_de_vie(int point_de_vie) {
        this.point_de_vie = point_de_vie;
    }

    public void setAttaque_par_seconde(double attaque_par_seconde) {
        this.attaque_par_seconde = attaque_par_seconde;
    }

    public void setDegat_attaque(int degat_attaque) {
        this.degat_attaque = degat_attaque;
    }

    public void setVitesse_de_deplacement(double vitesse_de_deplacement) {
        this.vitesse_de_deplacement = vitesse_de_deplacement;
    }

    public void setEffet(Effet effet) {
        this.effet = effet;
    }

    public void setChemin_image(String chemin_image) {
        this.chemin_image = chemin_image;
    }

    
}
