/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ieseljust.ad_unit3_02_1_1;


import Model.Autor;
import Model.Libro;
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


        Libro l1 =laSesion.get(Libro.class, 3L);
        
        Autor a=l1.getElAutor();
        
        System.out.println(a);
        System.out.println(a.listadoLibros());
        //close all
        laSesion.getTransaction().commit();
        laSesion.close();
    }
}
