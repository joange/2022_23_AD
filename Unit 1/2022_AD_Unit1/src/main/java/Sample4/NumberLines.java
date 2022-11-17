/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Sample4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

/**
 *
 * @author joange
 */
public class NumberLines {
    public static void main(String[] args) throws Exception {

        // Input and Output
        BufferedReader fin;
        PrintWriter fout;

        // line counter
        int num_linia;
        // readed line
        String linia;

        // check args
        if (args.length != 2) {
            System.out.println("Nombre d'arguments erroni. Sintaxi:\n numberLines fitxer eixida");
            return;
        }

        // Creare decorators
        fin = new BufferedReader(new FileReader(args[0]));
        fout = new PrintWriter(new FileWriter(args[1]));

        num_linia = 1;
        do {
            // Read the line
            linia = fin.readLine();
            if (linia != null) {
                fout.println(num_linia + ". " + linia);
            }
            num_linia++;
        } while (linia != null); // until we can't read

        // close all
        fin.close();
        fout.close();

    }
}
