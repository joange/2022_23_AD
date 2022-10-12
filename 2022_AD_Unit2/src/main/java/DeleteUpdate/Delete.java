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
public class Delete {

    public static void main(String[] args) {
        try {
            ConnexioDB conDB = new ConnexioDB("Instituto");

            Connection con = conDB.getConnexio();

            // give the age's bounds
            int minAge = Utilitats.leerEnteroC("Give me minimal age: ");
            int maxAge = Utilitats.leerEnteroC("Give me maximun age: ");

            // The query
            String SQL = "Delete from Persona where edad between ? and ?";

            // The statement
            PreparedStatement pst = con.prepareStatement(SQL);

            // fill placeholders            
            pst.setInt(1, minAge);
            pst.setInt(2, maxAge);

            System.out.println(pst);
            // The execution
            int deletedtedRows = pst.executeUpdate();

            System.out.println(deletedtedRows + " has been deleted.");

        } catch (SQLException ex) {
            System.out.println(ex);
        }

    }
}
