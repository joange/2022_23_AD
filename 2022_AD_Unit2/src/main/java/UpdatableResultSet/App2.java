/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UpdatableResultSet;

import Utils.ConnexioDB;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author joange
 */
public class App2 {
    public static void main(String[] args) {
        try {
            ConnexioDB db=new ConnexioDB("CineTest");
            Connection con= db.getConnexio();
            
            Statement st=con.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
            
            String SQL="Select * from Pelis";
            
            ResultSet rst=st.executeQuery(SQL);
            
            rst.absolute(5);
            
            System.out.println(rst.getString("Titulo") + " , " +rst.getInt("anyo"));
            
            while(rst.previous()){
                System.out.println(rst.getString("Titulo") + " , " +rst.getInt("anyo"));
            }
            
            rst.absolute(5);
            
            rst.updateString("Titulo", "El amperio contra paca");
            rst.updateRow();
            
            rst.beforeFirst();
            
            while(rst.next()){
                if ((rst.getInt(1)%2)==1)
                    rst.deleteRow();
            }
            
            rst.moveToInsertRow();
            
            rst.updateInt("idPelis", 21);
            rst.updateString("Titulo", "The mandalorian");
            rst.updateInt("anyo",2019);
            
            rst.insertRow();
            
            //Crear un ArrayList de Pelis
            
            ArrayList<Peli> lesPelis= new ArrayList<>();
            
            
            rst.beforeFirst();
            
            while(rst.next()){
                Peli p= new Peli(
                        rst.getInt(1),
                        rst.getString(2),
                        rst.getInt(3));
                
                lesPelis.add(p);
            }
            
            System.out.println("Hi han " + lesPelis.size() + " pelicules");
            
            for (Peli peli : lesPelis) {
                System.out.println(peli);
            }
            
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(App2.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
