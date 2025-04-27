package com.oxyl.coursepfback.model;

public class Map {
    //attributs
    private int id_map;
    private int ligne;
    private int colonne;
    private String chemin_image;
    
    public Map (){
        this.ligne = 6 ;
        this.colonne = 9 ;
        this.chemin_image = "../img/map.png" ;
    }

    public Map (int ligne, int colonne, String chemin_img){
        this.ligne = ligne ;
        this.colonne = colonne ;
        this.chemin_image = chemin_img;
    }

    public int getId_map() {
        return id_map;
    }

    public int getLigne() {
        return ligne;
    }

    public int getColonne() {
        return colonne;
    }

    public String getChemin_image() {
        return chemin_image;
    }

    public void setLigne(int ligne) {
        this.ligne = ligne;
    }

    public void setColonne(int colonne) {
        this.colonne = colonne;
    }

    public void setChemin_image(String chemin_image) {
        this.chemin_image = chemin_image;
    }
}
