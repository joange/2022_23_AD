/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ieseljust.ad_unit3_02_1_1;

import Model.Grupo;
import Model.Profesor;
import java.util.logging.Level;

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

        //create 2 Tutors;
        Profesor t1= new Profesor("Joan Gerard");
        Profesor t2= new Profesor("Jose Alfredo");
        
        
        
        Grupo g1= new Grupo("DAM", "Superior",   1);
        g1.setTutor(t1);
        laSesion.save(g1);
        
        Grupo g2= new Grupo("DAM","Superior", 2);
        g2.setTutor(t2);
        t2.setElGrupo(g2);
        
        laSesion.save(g2);
        
        
        // error this tutor also have a Group
//        Grupo g3= new Grupo("ASIX","Superior", 1);
//        g3.setTutor(t2);
//        laSesion.save(g3);
        
        System.out.println(t2);

        //close all
        laSesion.getTransaction().commit();
        laSesion.close();
    }
}
