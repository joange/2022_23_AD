/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Script;

import Utils.ConnexioDB;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author joange
 */
public class AppFiles {

    public static void main(String[] args) throws IOException {

        try {
            ConnexioDB conDB = new ConnexioDB("Instituto");

            Connection con = conDB.getConnexio();

            String script=Files.readString(Paths.get("sql/EsquemaCine.sql"));
           
            System.out.println(script);
            Statement stm = con.createStatement();
            int result = stm.executeUpdate(script);
            System.out.println("Script ejecutado con salida " + result);

        } catch (SQLException ex) {
            Logger.getLogger(AppFiles.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
