/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SampleBDJocs;

import java.util.Date;
import java.util.Set;

/**
 *
 * @author joange
 */
public class Jugador {

    private String nick;
    private Date dataRegistre;
    private Set<Registre> puntuacions;

    public Jugador(String nick, Date dataRegistre) {
        this.nick = nick;
        this.dataRegistre = dataRegistre;
    }

    public String getNick() {return nick;}
    public void setNick(String nick) {this.nick = nick;}

    public Date getDataRegistre() {return dataRegistre;}
    public void setDataRegistre(Date dataRegistre) {
        this.dataRegistre = dataRegistre;
    }

    public Set getPuntuacions() {return this.puntuacions;}
    public void setPuntuacio(Joc joc, int puntuacio) {
        Registre registre = new Registre(puntuacio, joc);
        this.puntuacions.add(registre);
    }
}
