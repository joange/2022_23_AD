/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SampleBDJocs;

/**
 *
 * @author joange
 */
public class Joc {

    protected String nom;
    protected String descripcio;
    protected Genere genere;

    public Joc(String nom, String descripcio, Genere genere) {
        this.nom = nom;
        this.descripcio = descripcio;
        this.genere = genere;

    }

    public String getNom() {return this.nom;}
    public void setNom(String nom) {this.nom = nom;}

    public String getDescripcio() {return this.descripcio;}
    public void setDescripcio(String descripcio) {
        this.descripcio= descripcio;
    }

    public Genere getGenere() {return this.genere;}

    public void setGenere(Genere genere) {this.genere = genere;}
}
