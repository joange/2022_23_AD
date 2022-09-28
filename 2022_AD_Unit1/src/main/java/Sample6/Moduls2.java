/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Sample6;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author joange
 */
public class Moduls2 {

    // Arrays with source data
    String[] moduls = {"Accés a Dades", "Programació de serveis i processos", "Desenvolupament d'interfícies", "Programació Multimèdia i dispositiud mòbils", "Sistemes de Gestió Empresarial", "Empresa i iniciativa emprenedora"};
    int[] hores = {6, 3, 6, 5, 5, 3};
    double[] notes = {8.45, 9.0, 8.0, 7.34, 8.2, 7.4};

    public void EscriuObjecte(String nom) throws IOException {

        //destination file
        ObjectOutputStream f = new ObjectOutputStream(new FileOutputStream(nom));

        Modul m; // Single object

        // loop along the arrays
        for (int i = 0; i < this.moduls.length; i++) {
            m = new Modul(this.moduls[i], this.hores[i], this.notes[i]);
            f.writeObject(m);
        }

        // close the file
        f.close();

    }

    public void LligObjecte(String nom) throws IOException, ClassNotFoundException {

        // input file
        ObjectInputStream f = new ObjectInputStream(new FileInputStream(nom));

        Modul m;
        // we don't know how many objects exists in the file.
        try {
            while (true) { // forever

                m = (Modul) f.readObject();

                // show the module
                System.out.println("Modul: " + m.getModul());
                System.out.println("Hores: " + m.getHores());
                System.out.println("Nota: " + m.getNota());
                System.out.println();

            }
        } catch (EOFException ex) {
            f.close();
        }

    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        // test the args
        if (args.length != 2) {
            System.out.println("Nombre d'arguments incorrecte.\n\nSintaxi: \n\t java Moduls2 [ read | write ] fitxer.obj");
            System.exit(0);
        }

        Moduls2 moduls = new Moduls2();
        System.out.println(args[0] + args[1]);
        // depending the args
        if (args[0].equals("read")) {
            moduls.LligObjecte(args[1]);
        } else if (args[0].equals("write")) {
            moduls.EscriuObjecte(args[1]);
        } else {
            System.out.println("No entenc l'ordre " + args[0] + "\n");
        }

    }

}
