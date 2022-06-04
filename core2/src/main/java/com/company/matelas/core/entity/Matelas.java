/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.company.matelas.core.entity;

/**
 *
 * @author Administrateur
 */
public class Matelas {
   private String id;
    private String name;
    private int langeur;
   private int prix;

    public Matelas() {
    }

    public Matelas(String id, String name, int langeur, int prix) {
        this.id = id;
        this.name = name;
        this.langeur = langeur;
        this.prix = prix;
    }
   

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLangeur() {
        return langeur;
    }

    public void setLangeur(int langeur) {
        this.langeur = langeur;
    }

    public int getPrix() {
        return prix;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }

    @Override
    public String toString() {
        return "Matelas{" + "id=" + id + ", name=" + name + ", langeur=" + langeur + ", prix=" + prix + '}';
        
    }
    
    
}
