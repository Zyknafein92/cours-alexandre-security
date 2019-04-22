package com.sdzee.tp.beans;

public class Utilisateur {
    private String nom;
    private String MotDePasse;
    private String email;

    public Utilisateur() { }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getMotdepasse() {
        return MotDePasse;
    }

    public void setMotDePasse(String motdepasse) {
        this.MotDePasse = motdepasse;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
