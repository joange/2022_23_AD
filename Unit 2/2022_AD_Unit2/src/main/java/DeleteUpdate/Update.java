/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DeleteUpdate;

import Utils.ConnexioDB;
import Utils.Utilitats;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author joange
 */
public class Update {

    public static void main(String[] args) {
        try {
            ConnexioDB conDB = new ConnexioDB("Instituto");

            Connection con = conDB.getConnexio();

            // give the age's bounds
            int difAge = Utilitats.leerEnteroC("Give me number oy years: ");
            int idMin = Utilitats.leerEnteroC("Give me minimum id: ");

            // The query
            String SQL = "Update Persona set edad=edad+ ? where idPersona > ?";

            // The statement
            PreparedStatement pst = con.prepareStatement(SQL);

            // fill placeholders            
            pst.setInt(1, difAge);
            pst.setInt(2, idMin);

            System.out.println(pst);
            // The execution
            int updatedRows = pst.executeUpdate();

            System.out.println(updatedRows + " has been updated.");

        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
}
