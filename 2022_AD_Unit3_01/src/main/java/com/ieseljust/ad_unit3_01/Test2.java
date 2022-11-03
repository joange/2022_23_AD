/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ieseljust.ad_unit3_01;

import Model.Car;
import Model.Peli;
import org.hibernate.Session;

/**
 *
 * @author joange
 */
public class Test2 {
    public static void main(String[] args) {
        // get a Session and start a transaction
        Session laSesion = HibernateUtil.getSessionFactory().getCurrentSession();
        laSesion.getTransaction().begin();

        // Create new object
        Car c=new Car("1234-VLC", "Nissan", 1987);
        
        long l=(Long)laSesion.save(c);

        Car c2=laSesion.get(Car.class, l);
        
        System.out.println(c2);
        //close all
        laSesion.getTransaction().commit();
        laSesion.close();
    }
}
