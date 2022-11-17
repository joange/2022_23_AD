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
public class App2 {

    public static void main(String[] args) {
        // get a Session and start a transaction
        //java.util.logging.Logger.getLogger("org.hibernate").setLevel(Level.OFF);

        @SuppressWarnings("unused")
        org.jboss.logging.Logger logger = org.jboss.logging.Logger.getLogger("org.hibernate");
        java.util.logging.Logger.getLogger("org.hibernate").setLevel(java.util.logging.Level.WARNING); //or whatever level you need

        Session laSesion = HibernateUtil.getSessionFactory().getCurrentSession();
        laSesion.getTransaction().begin();

        Profesor p=laSesion.get(Profesor.class, 2);
        System.out.println(p);
        

        //close all
        laSesion.getTransaction().commit();
        laSesion.close();
    }
}
