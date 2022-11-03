/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ieseljust.ad_unit3_01;

import Model.Car;
import org.hibernate.Session;

/**
 *
 * @author joange
 */
public class App {
    public static void main(String[] args) {
        
        System.out.println("Hello");
        
       Session laSesion= HibernateUtil.getSessionFactory().getCurrentSession();
       
       System.out.println("Hibernate is running OK");
    }    
}
