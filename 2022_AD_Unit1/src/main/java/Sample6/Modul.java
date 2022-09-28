/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Sample6;

import java.io.Serializable;
import org.json.JSONObject;

/**
 *
 * @author joange
 */
public class Modul implements Serializable {

    private static final long serialVersionUID = 1L;

    String nom;
    int hores;
    double nota;

    public Modul() {
        // Constructor buit
    }

    public Modul(String nom, int hores, double nota) {
        this.nom = nom;
        this.hores = hores;
        this.nota = nota;
    }

    public String getModul() {
        return this.nom;
    }

    public int getHores() {
        return this.hores;
    }

    public double getNota() {
        return this.nota;
    }

    public JSONObject getModulJSON() {
        JSONObject modul = new JSONObject();

        modul.put("nom", this.nom);
        modul.put("hores", this.hores);
        modul.put("nota", this.nota);

        // Si volguerem afegir un element nul, 
        // hauriem de fer:
        // modul.put("atribut", JSONObject.NULL);
        return modul;

    }

    @Override
    public String toString() {
        return "Modul{" + "nom=" + nom + ", hores=" + hores + ", nota=" + nota + '}';
    }

    
}
