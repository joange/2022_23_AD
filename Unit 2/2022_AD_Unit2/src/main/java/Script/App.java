/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Script;

import Utils.ConnexioDB;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
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

            File script = new File("sql/EsquemaCine.sql");

            BufferedReader bfr = bfr = new BufferedReader(new FileReader(script));

            String line = null;
            StringBuilder sb = new StringBuilder();

            // Obtenemos el salto de linea del sistema subyacente
            String breakLine = System.getProperty("line.separator");

            while ((line = bfr.readLine()) != null) {
                sb.append(line);
                sb.append(breakLine);
            }

            String query = sb.toString();   // generemos el Script en un String
            System.out.println(query);
            Statement stm = con.createStatement();
            int result = stm.executeUpdate(query);
            System.out.println("Script ejecutado con salida " + result);

        } catch (FileNotFoundException e) {
            System.out.println("Error: El script no Existe.");
        } catch (IOException e) {
            System.out.println("ERROR d'E/s");
        } catch (SQLException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
