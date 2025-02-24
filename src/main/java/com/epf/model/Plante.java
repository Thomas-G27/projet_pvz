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
        this.chemin_image = "data/img";
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

    public int getIdPlante() {
        return this.id_plante;
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
    
    public int getCout() {
        return this.cout;
    }
    
    public double getSoleilParSeconde() {
        return this.soleil_par_seconde;
    }
    
    public Effet getEffet() {
        return this.effet;
    }
    
    public String getCheminImage() {
        return this.chemin_image;
    }
    
}
