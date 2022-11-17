/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reading;

import InsertData.App;
import Utils.ConnexioDB;
import Utils.ConsoleColors;
import Utils.Utilitats;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author joange
 */
public class AppReading {

    private void fixed() {
        try {
            ConnexioDB conDB = new ConnexioDB("Instituto");

            Connection con = conDB.getConnexio();

            // The query
            String SQL = "Select * from Persona";
            // The statement
            Statement st = con.createStatement();
            // The execution
            ResultSet rst = st.executeQuery(SQL);

            // processing
            while (rst.next()) {
                System.out.print(ConsoleColors.BLUE_BRIGHT + "Person ("+ rst.getInt(1)+ "): " + ConsoleColors.RESET);
                /*
                System.out.println(
                        rst.getString(3)+ ", "+
                        rst.getString(2)+ " "+
                        rst.getInt(4));
                 */
                System.out.println(
                        rst.getString("apellidos") + ", "
                        + rst.getString("nombre") + " "
                        + rst.getInt("edad"));
            }

            rst.close();
        } catch (SQLException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void variable() {
        try {
            ConnexioDB conDB = new ConnexioDB("Instituto");

            Connection con = conDB.getConnexio();

            // hardcoded String
            // String SQL="Select * from Persona where nombre like '%Ma%'";
            String nombre = Utilitats.leerTextoC("Give me part of the name: ");
            // The query
            String SQL = "Select * from Persona where nombre like '%" + nombre + "%'";
            // The statement
            Statement st = con.createStatement();
            // The execution
            ResultSet rst = st.executeQuery(SQL);

            // processing
            while (rst.next()) {
                System.out.print(ConsoleColors.BLUE_BRIGHT + "People with " + nombre + ": " + ConsoleColors.RESET);
                System.out.println(
                        rst.getString("apellidos") + ", "
                        + rst.getString("nombre") + " "
                        + rst.getInt("edad"));
            }

            rst.close();
        } catch (SQLException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void injection() {
        try {
            ConnexioDB conDB = new ConnexioDB("Instituto");

            Connection con = conDB.getConnexio();

            int ID = Utilitats.leerEnteroC("Give me an id: ");
            // The query
            String SQL = "Select * from Persona where idPersona =" + ID;
            // The statement
            Statement st = con.createStatement();
            // The execution
            ResultSet rst = st.executeQuery(SQL);

            // processing
            while (rst.next()) {
                System.out.print(ConsoleColors.BLUE_BRIGHT + "People with " + ID + ": " + ConsoleColors.RESET);
                System.out.println(
                        rst.getString("apellidos") + ", "
                        + rst.getString("nombre") + " "
                        + rst.getInt("edad"));
            }

            rst.close();
        } catch (SQLException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void prepared() {
        try {
            ConnexioDB conDB = new ConnexioDB("Instituto");

            Connection con = conDB.getConnexio();

            int ID = Utilitats.leerEnteroG("Give me an id: ");
            // The query
            String SQL = "Select * from Persona where idPersona = ?";
            // The statement
            PreparedStatement pst = con.prepareStatement(SQL);
            // fill placeholders

            pst.setInt(1, ID);
            
            System.out.println(pst);

            // The execution
            ResultSet rst = pst.executeQuery();

            // processing
            while (rst.next()) {
                System.out.print(ConsoleColors.BLUE_BRIGHT + "People with " + ID + ": " + ConsoleColors.RESET);
                System.out.println(
                        rst.getString("apellidos") + ", "
                        + rst.getString("nombre") + " "
                        + rst.getInt("edad"));
            }

            rst.close();
        } catch (SQLException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
       private void prepared3() {
        try {
            ConnexioDB conDB = new ConnexioDB("Instituto");

            Connection con = conDB.getConnexio();

            int mEdat=Utilitats.leerEnteroC("Dime edad minima: ");
            int MEdat=Utilitats.leerEnteroC("Dime edad maxima: ");
            int longitud=Utilitats.leerEnteroG("Dime tamaño máximo: ");
            
            // The query
            String SQL = "select * from Persona\n" +
                        "where edad between ? and ? and\n" +
                        "length(nombre)<?";
            // The statement
            PreparedStatement pst = con.prepareStatement(SQL);
            // fill placeholders

            pst.setInt(1, mEdat);
            pst.setInt(2, MEdat);
            pst.setInt(3, longitud);
            
            System.out.println(pst);

            // The execution
            ResultSet rst = pst.executeQuery();

            // processing
            while (rst.next()) {
                System.out.println(
                        rst.getString("apellidos") + ", "
                        + rst.getString("nombre") + " "
                        + rst.getInt("edad"));
            }

            rst.close();
        } catch (SQLException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void prepared2() {
        try {
            ConnexioDB conDB = new ConnexioDB("Instituto");

            Connection con = conDB.getConnexio();

            String name = Utilitats.leerTextoC("Give me part of name: ");
            int age = Utilitats.leerEnteroC("Give me an age: ");

            // The query
            String SQL = "Select * from Persona where nombre like ? and edad=?";
            // The statement
            PreparedStatement pst = con.prepareStatement(SQL);
            // fill placeholders

            pst.setString(1, "%" + name + "%");
            //pst.setString(1, name );
            pst.setInt(2, age);

            System.out.println(pst.toString());

            // The execution
            ResultSet rst = pst.executeQuery();

            // processing
            while (rst.next()) {
                System.out.print(ConsoleColors.BLUE_BRIGHT + "People: " + ConsoleColors.RESET);
                System.out.println(
                        rst.getString("apellidos") + ", "
                        + rst.getString("nombre") + " "
                        + rst.getInt("edad"));
            }

            rst.close();
        } catch (SQLException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void main(String[] args) {
        AppReading app = new AppReading();
        
        //app.fixed();
        //app.variable();
        //app.injection();
        // app.prepared();
        // app.prepared2();
        
        app.prepared3();
    }
}
