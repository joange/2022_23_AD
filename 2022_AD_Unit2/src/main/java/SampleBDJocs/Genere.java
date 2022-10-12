/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SampleBDJocs;

/**
 *
 * @author joange
 */
public class Genere {
    protected String nom;
    protected String descripcio;

    public Genere(String nom, String descripcio) {
        this.nom = nom;
        this.descripcio = descripcio;
    }

    public String getNom() {return nom;}

    public void setNom(String nom) {this.nom = nom;}

    public String getDescripcio() {return descripcio;}

    public void setDescripcio(String descripcio) {
        this.descripcio = descripcio;
    }
}
