/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Sample1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author joange
 */
public class NewClass {
    public static void main(String[] args) throws FileNotFoundException {
       
        File f=new File("/home/joan/texto.md");
        FileInputStream fis= new FileInputStream(f);
        
        if (f.exists()){
            try {
                byte []chunck=new byte[20];
                
                int n=fis.read(chunck);
                
                
            } catch (IOException ex) {
                Logger.getLogger(NewClass.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
        }
        else{
            System.out.println("Error");
        }
        
        
        
    }
}

















