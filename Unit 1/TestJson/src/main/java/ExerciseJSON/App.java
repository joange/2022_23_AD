/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ExerciseJSON;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.json.JSONArray;
import org.json.JSONObject;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

/**
 *
 * @author joange
 */
public class App {

    private JSONObject LligJSON(String filename) {
        try {
            // Amb FileReader llegirem caràcter a
            // caràcter el fitxer i l'afegim al string myJson
            FileReader file = new FileReader(filename);
            String myJson = "";

            int i;
            while ((i = file.read()) != -1) {
                myJson = myJson + ((char) i);
            }
            //System.out.println(myJson);
            file.close();

            // al que li passem un string amb el JSON:
            return (new JSONObject(myJson));
        } catch (Exception e) {
            System.out.println("Error llegint el fitxer");
            return null;
        }
    }

    public Document OpenXML(String name) throws IOException, SAXException, ParserConfigurationException, FileNotFoundException {
        // Create an instance of DocumentBuilderFactory
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        // Using the DocumentBuilderFactory instance we create a DocumentBuilder
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        //And we use DocumentBuilder's "parse" method to get the document
        Document doc = dBuilder.parse(new File(name));

        return doc;
    }

    public Document NewXML() throws IOException, SAXException, ParserConfigurationException, FileNotFoundException {
        // Create an instance of DocumentBuilderFactory
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        // Using the DocumentBuilderFactory instance we create a DocumentBuilder
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        //And we use DocumentBuilder's "parse" method to get the document
        Document doc = dBuilder.newDocument();

        return doc;
    }

    
    
    private void writeXMLFile(Document doc, String filename) {
        try {
            
            Transformer trans = TransformerFactory.newInstance().newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new FileOutputStream(filename));
            trans.transform(source, result);
            
        } catch (TransformerConfigurationException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TransformerException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }

    private void withoutVehicles(JSONObject objeto) {

        JSONArray personatges = objeto.getJSONArray("personatges");

        for (int i = 0; i < personatges.length(); i++) {
            JSONObject personatge = personatges.getJSONObject(i);

            JSONArray vehicles = personatge.getJSONArray("vehicles");

            if (vehicles.length() == 0) {
                String name = personatge.getString("name");
                System.out.println(name + " hasn't drove a vehicle");
            }
        }

    }

    /*
    <character films="4" vehicles="0"> 
        <name>Luke Skywalker</name> 
        <mass>77</mass> 
        <url>https://swapi.dev/api/people/1/</url>
    </character>
     */
    private void saveXMLFromJSON(JSONObject objeto, String filename) {
        try {
            Document doc = NewXML();

            Element root = doc.createElement("personatges");
            doc.appendChild(root);

            JSONArray personatges = objeto.getJSONArray("personatges");

            for (int i = 0; i < personatges.length(); i++) {
                JSONObject personatge = personatges.getJSONObject(i);

                Element character=doc.createElement("character");
                
                JSONArray films=personatge.getJSONArray("films");
                JSONArray vehicles=personatge.getJSONArray("vehicles");
                
                character.setAttribute("films", String.valueOf(films.length()));
                character.setAttribute("vehicles", vehicles.length()+"");
                
                // creo el name
                String name=personatge.getString("name"); 
                Element nombre=doc.createElement("name");
                nombre.appendChild(doc.createTextNode(name));
                character.appendChild(nombre);
                
                //creo el mass
                String mass=personatge.getString("mass"); 
                Element peso=doc.createElement("mass");
                peso.appendChild(doc.createTextNode(mass));
                character.appendChild(peso);
                
                //creo el link
                String url=personatge.getString("url"); 
                Element link=doc.createElement("url");
                link.appendChild(doc.createTextNode(url));
                character.appendChild(link);
                
                root.appendChild(character);
                
                
                
                
            }
            
            writeXMLFile(doc, filename);

        } catch (IOException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SAXException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void main(String[] args) {

//        JSONObject obj=new JSONObject();
//        
//        obj.put("name", "Joan Gerard");
//        obj.put("age", 48);
//        System.out.println(obj.toString(2));
//        
        App app = new App();

        JSONObject objeto = app.LligJSON("SW.json");

        System.out.println(objeto.toString(2));

        app.withoutVehicles(objeto);

//        System.out.println("===============================");
        app.saveXMLFromJSON(objeto,"SW.xml");
    }
}
