/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ieseljust.ad_unit3_01;

import Model.Peli;
import org.hibernate.Session;

/**
 *
 * @author joange
 */
public class Test1 {

    public static void main(String[] args) {
        // get a Session and start a transaction
        Session laSesion = HibernateUtil.getSessionFactory().getCurrentSession();
        laSesion.getTransaction().begin();

        // Create new object
        Peli p = new Peli("Piratas del caribe", 2003, "Gore Verbinsky");
        System.out.println("Unsaved: " + p);

        // save in the database
            Long idNueva = (Long) laSesion.save(p);

        // Get the saved object (with another varaible)
        Peli q = laSesion.get(Peli.class, idNueva);

        System.out.println("Saved: "+ q);

        //close all
        laSesion.getTransaction().commit();
        laSesion.close();
    }
}
