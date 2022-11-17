/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import Utils.ConsoleColors;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author joange
 */
public class ConnexioDB {

    private Connection laConnexio = null;

    private String dbName;
    

    public ConnexioDB() {
        this.dbName="";
    }

    public ConnexioDB(String dbName) {
        this.dbName = dbName;
    }
    
    
    private void obrirConnexio() {

        if (laConnexio == null) {

            Properties config = new Properties();
            try {

                Class.forName("com.mysql.cj.jdbc.Driver");

                config.load(new FileInputStream("conexio.properties"));

                //System.out.println(config.toString());

                String port = config.getProperty("port");
                String server = config.getProperty("server");
                
                 if (dbName==null)
                     dbName=config.getProperty("dbName");

                String connectionUrl = "jdbc:mysql://" + server + ":" + port +"/" + dbName;

                
                Properties p = new Properties();
                
                p.put("user", config.getProperty("user"));
                p.put("password", config.getProperty("password"));
                p.put("allowMultiQueries", config.getProperty("allowMultiQueries"));
                laConnexio = DriverManager.getConnection(connectionUrl, p);
                 
               // laConnexio = DriverManager.getConnection(connectionUrl, config);

                System.out.println(ConsoleColors.GREEN + "Connection to MySQL has been established with DB: " + dbName + ConsoleColors.RESET);

            } catch (FileNotFoundException fnfe) {
                fnfe.printStackTrace();
            } catch (IOException ioe) {
                ioe.printStackTrace();
            } catch (SQLException ex) {
                System.out.println("Error:" + ex.getMessage());
            } catch (ClassNotFoundException ex) {
                System.out.println(ex.getMessage());
            }
        }

    }

    public Connection getConnexio() {
        if (laConnexio == null) {
            obrirConnexio();
        }

        return laConnexio;

    }

    public void tancarConnexio() {
        if (laConnexio != null) {
            try {
                laConnexio.close();
            } catch (SQLException ex) {
                Logger.getLogger(ConnexioDB.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        laConnexio = null;
    }

}
