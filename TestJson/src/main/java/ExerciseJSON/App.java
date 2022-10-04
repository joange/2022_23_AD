/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ExerciseJSON;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.json.JSONArray;
import org.json.JSONObject;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

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
    
    private void withoutVehicles(JSONObject objeto){
        JSONArray personatges= objeto.getJSONArray("personatges");
        
        for (int i = 0; i < personatges.length(); i++) {
            JSONObject personatge=personatges.getJSONObject(i);
            
            //extract the vehicles
            JSONArray vehicles=personatge.getJSONArray("vehicles");
            
            String name=personatge.getString("name");
            
            if (vehicles.length()==0)
                System.out.println("El personatge " + name + " no ha conduït");
            
        }
    }
    
    /*
    <character films="4" vehicles="0"> 
        <name>Luke Skywalker</name> 
        <mass>77</mass> 
        <url>https://swapi.dev/api/people/1/</url>
    </character>
    *
    */
    private void saveXMLFromJSON(JSONObject objeto) {
        
        try {
            JSONArray personatges= objeto.getJSONArray("personatges");
            
            Document doc=DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
            Element root=doc.createElement("Personatges");
            doc.appendChild(root);
            
            for (int i = 0; i < personatges.length(); i++) {
                JSONObject personatgeJSON=personatges.getJSONObject(i);
                
                Element personatgeXML=doc.createElement("character");
                
                JSONArray vehicles=personatgeJSON.getJSONArray("vehicles");
                personatgeXML.setAttribute("vehicles", String.valueOf(vehicles.length()));
                
                JSONArray films=personatgeJSON.getJSONArray("films");
                personatgeXML.setAttribute("films", String.valueOf(films.length()));
               
                root.appendChild(personatgeXML);
                
            }
            
            System.out.println(doc.toString());
            
             Transformer trans = TransformerFactory.newInstance().newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new FileOutputStream("SW.xml"));
            trans.transform(source, result);
            
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TransformerException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void main(String[] args) {
        App app= new App();
        
        JSONObject objeto= app.LligJSON("SW.json");
        
//        System.out.println(objeto);

        app.withoutVehicles(objeto);
        System.out.println("===============================");
        
        app.saveXMLFromJSON(objeto);
    }
}
