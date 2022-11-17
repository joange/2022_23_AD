/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ResultSetMetaData;

import Utils.ConnexioDB;
import Utils.ConsoleColors;
import Utils.Utilitats;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author joange
 */
public class App {

    public static void main(String[] args) {
        try {
            ConnexioDB conDB = new ConnexioDB("Instituto");

            Connection con = conDB.getConnexio();

            String ID = Utilitats.leerTextoC("Give me an id: ");
            // The query
            String SQL = "Select * from Persona where idPersona = ?";
            // The statement
            PreparedStatement pst = con.prepareStatement(SQL);
            // fill placeholders

            pst.setString(1, ID);

            // The execution
            ResultSet rst = pst.executeQuery();

            ResultSetMetaData rstmd = rst.getMetaData();
            int cols = rstmd.getColumnCount();

            //print header
            for (int i = 1; i <= cols; i++) {
                System.out.print(String.format("%20s", rstmd.getColumnName(i)));
            }
            System.out.println("");

            // processing
            while (rst.next()) {
                for (int i = 1; i <= cols; i++) {
                    switch (rstmd.getColumnType(i)) {   // segun el tipo formateamos
                        case java.sql.Types.VARCHAR:
                            System.out.print(String.format("%20s", rst.getString(i)));
                            break;
                        case java.sql.Types.INTEGER:
                            System.out.print(String.format("%20d", rst.getInt(i)));
                            break;
                        case java.sql.Types.DOUBLE,java.sql.Types.FLOAT:
                            System.out.print(String.format("%20lf", rst.getDouble(i)));
                            break;
                        default:    // cualquier otro tipo. El polimorfismo efectua su magia
                            System.out.print(String.format("%20s", rst.getObject(i)));
                    }
                }
            }

            rst.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }
}
