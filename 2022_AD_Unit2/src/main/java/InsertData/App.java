/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package InsertData;

import Utils.ConnexioDB;
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
            ConnexioDB conDB=new ConnexioDB("BDJocs");
            
            Connection con=conDB.getConnexio();
            
            String SQL="INSERT INTO Joc VALUES (1, 'Double Dragon', 'Dos germans bessons "
                    + "experts en arts marcials s`han de fer camí en un escenari urbà on "
                    + "membres de bandes rivals volen deixar-los fora de combat.', 1);";
            
            Statement st=con.createStatement();
            
            int affectedRows=st.executeUpdate(SQL);
            
            System.out.println(affectedRows+ " row has been inserted");
                    
           } catch (SQLException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
