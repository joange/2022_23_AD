package DatabaseMeta;

import Utils.ConnexioDB;
import Utils.ConsoleColors;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author joange
 */
public class App {

    public static void main(String[] args) {
        try {
            ConnexioDB laConnexioDB = new ConnexioDB("BDJocs");

            Connection con = laConnexioDB.getConnexio();

            DatabaseMetaData dbmd = con.getMetaData();

            System.out.println(ConsoleColors.BLUE + "\nDBMS information--------" + ConsoleColors.RESET);
            System.out.println(ConsoleColors.WHITE_BRIGHT + "DBMS:\t" + ConsoleColors.RESET + dbmd.getDatabaseProductName());
            System.out.println(ConsoleColors.WHITE_BRIGHT + "DBMS:\t" + ConsoleColors.RESET + dbmd.getDriverName());
            System.out.println(ConsoleColors.WHITE_BRIGHT + "DBMS:\t" + ConsoleColors.RESET + dbmd.getURL());
            System.out.println(ConsoleColors.WHITE_BRIGHT + "DBMS:\t" + ConsoleColors.RESET + dbmd.getUserName());

            System.out.println(ConsoleColors.WHITE_BRIGHT + String.format("%-15s %-15s %-15s ", "Database", "Table", "Type"));
            System.out.println("-------------------------------------------------------" + ConsoleColors.RESET);
            ResultSet rsmd = dbmd.getTables("BDJocs", null, null, null);
            while (rsmd.next()) {
                System.out.println(String.format("%-15s %-15s %-15s", rsmd.getString(1), rsmd.getString(3), rsmd.getString(4)));
            }

            rsmd.close();

            String table = "Genere"; // we set the name of an existing table
            ResultSet columnes = dbmd.getColumns("BDJocs", null, table, null);

            System.out.println(ConsoleColors.WHITE_BRIGHT + String.format("%-25s %-15s %-15s ", "Atribut/Claus", "Tipus", "Pot ser nul?" + ConsoleColors.RESET));
            while (columnes.next()) {
                String columnName = columnes.getString(4);
                String tipus = columnes.getString(6);
                String nullable = columnes.getString(18);

                System.out.println(String.format("%-25s %-15s %-15s", columnName,tipus,nullable));
            }
            con.close();

        } catch (SQLException ex) {
            System.out.println(ex);
        }

    }
}
