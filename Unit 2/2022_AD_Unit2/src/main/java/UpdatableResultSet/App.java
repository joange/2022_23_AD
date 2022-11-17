/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UpdatableResultSet;

import Utils.ConnexioDB;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
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
            DatabaseMetaData dbmd = con.getMetaData();
            
            System.out.println("TYPE_FORWARD_ONLY: " + dbmd.supportsResultSetType(ResultSet.TYPE_FORWARD_ONLY));
            System.out.println("TYPE_SCROLL_INSENSITIVE: " + dbmd.supportsResultSetType(ResultSet.TYPE_SCROLL_INSENSITIVE));
            System.out.println("TYPE_SCROLL_SENSITIVE: " + dbmd.supportsResultSetType(ResultSet.TYPE_SCROLL_SENSITIVE));
            System.out.println("CONCUR_READ_ONLY: " + dbmd.supportsResultSetConcurrency(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY));
            System.out.println("CONCUR_UPDATABLE: " + dbmd.supportsResultSetConcurrency(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE));
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
}
