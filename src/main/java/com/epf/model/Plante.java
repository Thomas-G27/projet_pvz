package com.epf.model;

public class Plante {
    //attributs
    private int id_plante;
    private String nom;
    private int point_de_vie;
    private double attaque_par_seconde;
    private int degat_attaque;
    private int cout;
    private double soleil_par_seconde;
    private Effet effet;
    private String chemin_image;

    public Plante (){
        this.nom = "casual" ;
        this.point_de_vie = 100 ;
        this.attaque_par_seconde = 0.8 ;
        this.degat_attaque = 5 ;
        this.cout = 10 ;
        this.soleil_par_seconde = 0.1 ;
        this.effet = Effet.NORMAL ;
        this.chemin_image = "../img";
    }

    public Plante (String nom, int pdv, double attaque, int degat, int cout, double soleil, Effet effet, String chemin_img){
        this.nom = nom ;
        this.point_de_vie = pdv ;
        this.attaque_par_seconde = attaque ;
        this.degat_attaque = degat ;
        this.cout = cout ;
        this.soleil_par_seconde = soleil ;
        this.effet = effet ;
        this.chemin_image = chemin_img;
    }

    public int getId_plante() {
        return id_plante;
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

    public int getCout() {
        return cout;
    }

    public double getSoleil_par_seconde() {
        return soleil_par_seconde;
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

    public void setCout(int cout) {
        this.cout = cout;
    }

    public void setSoleil_par_seconde(double soleil_par_seconde) {
        this.soleil_par_seconde = soleil_par_seconde;
    }

    public void setEffet(Effet effet) {
        this.effet = effet;
    }

    public void setChemin_image(String chemin_image) {
        this.chemin_image = chemin_image;
    }
    
}