/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RowToObject;

import Utils.ConnexioDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
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
public class App {
    public static void main(String[] args)  {
        try {
            ArrayList<Persona> lasPersonas= new ArrayList();
            
            ConnexioDB conDB=new ConnexioDB("Instituto");
            
            Connection con=conDB.getConnexio();
            
            String SQL="Select * from Persona" ;
            // The statement
            Statement st=con.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);

            // The execution
            ResultSet rst=st.executeQuery(SQL);
            
            if (!rst.next()){
                System.out.println("No people in DB");
            }
            else{
                rst.beforeFirst();
                while(rst.next()){
                    Persona p= new Persona(
                            rst.getInt(1),
                            rst.getString(2),
                            rst.getString(3),
                            rst.getInt(4));
                    System.out.println("Adding " +p);
                    lasPersonas.add(p);
                }
            }
            
            System.out.println("Added " + lasPersonas.size() + " people");
            rst.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
