/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SampleBDJocs;

/**
 *
 * @author joange
 */
public class Registre {
    private int puntuacio;
    private Joc joc;

    public Registre(int puntuacio, Joc joc) {
        this.puntuacio = puntuacio;
        this.joc = joc;
    }

    public int getPuntuacio() {return puntuacio;}
    public void setPuntuacio(int puntuacio) {
        this.puntuacio = puntuacio;
    }

    public Joc getJoc() {return joc;}

    public void setJoc(Joc joc) {this.joc = joc;}   
}
