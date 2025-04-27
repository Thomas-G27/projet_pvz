package com.oxyl.coursepfback.model;


public class Zombie {
    //attributs
    private int id_zombie;
    private String nom;
    private int point_de_vie;
    private double attaque_par_seconde;
    private int degat_attaque;
    private double vitesse_de_deplacement;
    private String chemin_image;
    private int id_map; // Id de la map associée

    //constructeurs
    public Zombie (int id_zombie, String nom, int pdv, double attaque, int degat, double vitesse, String chemin_img, int id_map){
        this.id_zombie = id_zombie;
        this.nom = nom ;
        this.point_de_vie = pdv ;
        this.attaque_par_seconde = attaque ;
        this.degat_attaque = degat ;
        this.vitesse_de_deplacement = vitesse ;
        this.chemin_image = chemin_img;
        this.id_map = id_map;
    }
    public Zombie (String nom, int pdv, double attaque, int degat, double vitesse, String chemin_img, int id_map){
        this.nom = nom ;
        this.point_de_vie = pdv ;
        this.attaque_par_seconde = attaque ;
        this.degat_attaque = degat ;
        this.vitesse_de_deplacement = vitesse ;
        this.chemin_image = chemin_img;
        this.id_map = id_map;
    }

    //getters
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
    public String getChemin_image() {
        return chemin_image;
    }
    public int getId_map() {
        return id_map;
    }

    //setters
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
    public void setChemin_image(String chemin_image) {
        this.chemin_image = chemin_image;
    }
    public void setId_map(int id_map) {
        this.id_map = id_map;
    }
}
