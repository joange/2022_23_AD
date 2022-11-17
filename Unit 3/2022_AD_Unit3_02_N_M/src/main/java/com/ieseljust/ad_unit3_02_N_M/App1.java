/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ieseljust.ad_unit3_02_N_M;



import Model.Modulo;
import Model.Profesor;

import org.hibernate.Session;

/**
 *
 * @author joange
 */
public class App1 {

    public static void main(String[] args) {
        // get a Session and start a transaction
        //java.util.logging.Logger.getLogger("org.hibernate").setLevel(Level.OFF);

        @SuppressWarnings("unused")
        org.jboss.logging.Logger logger = org.jboss.logging.Logger.getLogger("org.hibernate");
        java.util.logging.Logger.getLogger("org.hibernate").setLevel(java.util.logging.Level.WARNING); //or whatever level you need

        Session laSesion = HibernateUtil.getSessionFactory().getCurrentSession();
        laSesion.getTransaction().begin();
        
       
        Profesor p1 = new Profesor("Mario Benedé");
        Profesor p2 = new Profesor("Jose Fernandez");

        Modulo m1 = new Modulo("Acceso a Datos");
        Modulo m2 = new Modulo("Bases de Datos");
        Modulo m3 = new Modulo("Programación");
        Modulo m4 = new Modulo("Diseño de Interfaces");

        // añadimos modulos a p1
        p1.addModulo(m3);
        p1.addModulo(m1);

        // añadimos modulos a p2
        p2.addModulo(m2);
        p2.addModulo(m3);
        p2.addModulo(m4);

        // guardamos
        laSesion.persist(p1);
        laSesion.persist(p2);

        

        //close all
        laSesion.getTransaction().commit();
        laSesion.close();
    }
}
