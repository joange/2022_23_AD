/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ProvaResultSet;

import java.io.File;
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
public class ConnexioBD {
        private Connection conexio=null;

    public ConnexioBD() {
        
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ConnexioBD.class.getName()).log(Level.SEVERE, null, ex);
            }
        
    }
        
        
        
        private void connect(){
            FileInputStream fis=null;
            try {
                // load the properties from file
                Properties prop=new Properties();
                fis = new FileInputStream(new File("conf.properties"));
                prop.load(fis);
                
                // create the connection URL
                String connectionUrl = "jdbc:mysql://" + prop.getProperty("server")
                        + ":" + prop.getProperty("port")
                        + "/" + prop.getProperty("database");
                
                // open the connection
                conexio=DriverManager.getConnection(connectionUrl, prop);
                
                fis.close();
                
            } catch (FileNotFoundException ex) {
                Logger.getLogger(ConnexioBD.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(ConnexioBD.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(ConnexioBD.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                try {
                    fis.close();
                } catch (IOException ex) {
                    Logger.getLogger(ConnexioBD.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        
        public Connection getconexio(){
            if (conexio==null)
                this.connect();
            
            return conexio;
        }
        
        public void desconnect(){
            try {
                conexio.close();
                conexio=null;
            } catch (SQLException ex) {
                Logger.getLogger(ConnexioBD.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
}
