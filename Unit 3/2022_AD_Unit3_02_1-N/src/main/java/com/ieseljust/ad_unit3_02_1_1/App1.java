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
public class App1 {

    public static void main(String[] args) {
        // get a Session and start a transaction
        //java.util.logging.Logger.getLogger("org.hibernate").setLevel(Level.OFF);

        @SuppressWarnings("unused")
        org.jboss.logging.Logger logger = org.jboss.logging.Logger.getLogger("org.hibernate");
        java.util.logging.Logger.getLogger("org.hibernate").setLevel(java.util.logging.Level.WARNING); //or whatever level you need

        Session laSesion = HibernateUtil.getSessionFactory().getCurrentSession();
        laSesion.getTransaction().begin();
        
        Autor a= new Autor("George R.R. MArtin", "Americana");
        
        Libro l1=new Libro("Juego de Tronos", "Fantasia");l1.setElAutor(a);
        Libro l2=new Libro("Choque de Reyes", "Fantasia");l2.setElAutor(a);
        Libro l3=new Libro("Danza de Dragones", "Fantasia");l3.setElAutor(a);
        Libro l4=new Libro("Tormenta de Espadas", "Fantasia");l4.setElAutor(a);
        Libro l5=new Libro("Festín de Cuervos", "Fantasia");l5.setElAutor(a);
        
        laSesion.persist(a);
        
        System.out.println(a);
        System.out.println(a.listadoLibros());
        
        System.out.println(l2);
        System.out.println(l4);

        //close all
        laSesion.getTransaction().commit();
        laSesion.close();
    }
}
