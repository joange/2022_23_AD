/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PROPS;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;

/**
 *
 * @author joange
 */
public class Sample {

    /**
     * Load the file specified and show its properties in different ways
     * @param filename 
     */
    private void loadAndShowProperties(String filename) {

        Properties properties = new Properties();

        try {
            properties.load(new FileInputStream(new File(filename)));

            System.out.println("Whole set: " + properties);

            properties.list(System.out);

            Set<Object> keys = properties.keySet( );

            System.out.println("My listing: ");
            for (Object key : keys) {
                System.out.println(key + " - " + properties.getProperty((String) key));
            }

        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    /**
     * Create a properties object, populated with samples and stores into a 
     * text file and a XML file
     * @throws IOException 
     */
    private void writeProperties() throws IOException {
        Properties props = new Properties();

        props.put("Color", "Green");
        props.put("Range", "123");
        props.put("Visible", "false");
        props.put("Size", "Big");
        props.put("Status", "functional");
        props.put("Value", "345.24");

        props.store(new FileWriter(new File("propis.properties")), "Sample props file");

        props.storeToXML(new FileOutputStream(new File("propis.xml")), "Sample XML Props");
    }

    public static void main(String[] args) throws IOException {
        Sample sam = new Sample();

        sam.loadAndShowProperties("conf.properties");

        sam.writeProperties();
    }

}
